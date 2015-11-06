/**
 * Copyright (c) 2015, biezhi 王爵 (biezhi.me@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.izone.route;

import com.blade.context.BladeWebContext;
import com.blade.render.ModelAndView;
import com.izone.Const;
import com.izone.model.User;

public class BaseRoute {
	
	/**
	 * 默认分页条数
	 */
	protected Integer pageSize = 10;
	
	/**
	 * 状态字段
	 */
	protected String STATUS = "status";
	
	/**
	 * 成功
	 */
	protected String SUCCESS = "success";
	
	/**
	 * 服务器异常
	 */
	protected String ERROR = "error";
	
	/**
	 * 已经存在
	 */
	protected String EXIST = "exist";
	
	/**
	 * 失败
	 */
	protected String FAILURE = "failure";
	
	
	protected ModelAndView getFront(String view){
		return new ModelAndView(view);
	}
	
	protected ModelAndView getAdmin(String view){
		view = "admin/" + view;
		return new ModelAndView(view);
	}
	
	/**
	 * @return	返回是否登录
	 */
	public User isSignin(){
		return BladeWebContext.session().attribute(Const.LOGIN_SESSION);
	}
	
	/**
	 * @return	返回是否登录并且是管理员
	 */
	public User isAdmin(){
		return BladeWebContext.session().attribute(Const.LOGIN_SESSION);
	}
}
