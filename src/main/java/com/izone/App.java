package com.izone;

import java.util.Properties;

import javax.sql.DataSource;

import jetbrick.template.JetEngine;
import jetbrick.template.JetGlobalContext;
import jetbrick.template.resolver.GlobalResolver;
import blade.kit.MailKit;
import blade.kit.PropertyKit;
import blade.plugin.sql2o.Sql2oPlugin;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.blade.Blade;
import com.blade.Bootstrap;
import com.blade.render.JetbrickRender;
import com.izone.func.Funcs;

/**
 * 全局初始化配置
 * @author biezhi
 *
 */
public class App extends Bootstrap {

	@Override
	public void init(Blade blade) {
		
		// 加载配置文件
		blade.config("blade.properties");
		
		// 加载路由文件
		blade.routeConf("com.izone.route.front", "route-front.conf");
		blade.routeConf("com.izone.route.admin", "route-admin.conf");
		
		// 设置模板引擎
		JetbrickRender jetbrickRender = new JetbrickRender();
		JetEngine jetEngine = jetbrickRender.getJetEngine();
		
		JetGlobalContext globalContext = jetEngine.getGlobalContext();
		Const.CONTEXT = globalContext;
		
		GlobalResolver resolver = jetEngine.getGlobalResolver();
		resolver.registerFunctions(Funcs.class);
		
		blade.viewEngin(jetbrickRender);
		
		// 配置数据库
		try {
			Properties props = PropertyKit.getProperty("ds.properties");
			DataSource dataSource = DruidDataSourceFactory.createDataSource(props);
			Sql2oPlugin sql2oPlugin = blade.plugin(Sql2oPlugin.class);
			sql2oPlugin.config(dataSource).run();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
				
		// 配置邮箱管理员
		MailKit.config(MailKit.SMTP_QQ, blade.config().get("mail.user"), blade.config().get("mail.pass"));
	}
	
	@Override
	public void contextInitialized(Blade blade) {
		
	}
	
}
