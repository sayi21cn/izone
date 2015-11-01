package com.izone;

import com.blade.Blade;
import com.blade.Bootstrap;
import com.blade.render.JetbrickRender;
import jetbrick.template.JetEngine;
import blade.kit.MailKit;

/**
 * 全局初始化配置
 * @author biezhi
 *
 */
public class App extends Bootstrap {

	@Override
	public void init() {
		Blade blade = Blade.me();
		
		// 加载配置文件
		blade.config("blade.properties");
		
		// 加载路由文件
		blade.routeConf("com.izone.route.front", "route-front.conf");
		blade.routeConf("com.izone.route.admin", "route-admin.conf");
		
		// 设置模板引擎
		JetbrickRender jetbrickRender = new JetbrickRender();
		JetEngine jetEngine = jetbrickRender.getJetEngine();
		blade.viewEngin(jetbrickRender);
		
		// 配置邮箱管理员
		MailKit.config(MailKit.SMTP_QQ, blade.config().get("mail.user"), blade.config().get("mail.pass"));
	}
	
}
