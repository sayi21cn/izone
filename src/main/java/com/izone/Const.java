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

	public static final String LOGIN_SESSION = "login_user";
	
	public static Map<String, Object> SYSINFO = new HashMap<String, Object>();
	
	public static JetGlobalContext CONTEXT;
	
}
