package com.izone;

import java.util.HashMap;
import java.util.Map;

import jetbrick.template.JetGlobalContext;

/**
 * 全局常量类
 * @author biezhi
 *
 */
public final class Const {

	/**
	 * 全局登录Session标识
	 */
	public static final String LOGIN_SESSION = "login_user";
	
	/**
	 * 文件上传目录
	 */
	public static final String UPLOAD_DIR = "static/upload"; 
	
	/**
	 * 系统信息
	 */
	public static Map<String, Object> SYSINFO = new HashMap<String, Object>();
	
	/**
	 * 模板全局上下文
	 */
	public static JetGlobalContext CONTEXT;
	
	/**
	 * 文章类型
	 */
	public enum POST{
		text, image, music
	}
	
	/**
	 * 附件类型
	 */
	public enum ATTACH{
		image
	}
}
