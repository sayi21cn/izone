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
package com.izone.service;

import com.izone.model.User;

import blade.plugin.sql2o.Page;
import blade.plugin.sql2o.WhereParam;

public interface UserService {

	/**
	 * 查询User
	 * @param where	查询条件
	 * @return		返回user对象
	 */
	User getUser(WhereParam where);
	
	/**
	 * 用户登录
	 * @param login_name	用户名
	 * @param pass_word		密码
	 * @return				返回登录的user
	 */
	User signin(String login_name, String pass_word);
	
	/**
	 * 分页获取user
	 * @param where		查询条件
	 * @param page		页码
	 * @param pageSize	每页条数
	 * @return			返回分页user对象
	 */
	Page<User> getUserPage(WhereParam where, Integer page, Integer pageSize);
	
	/**
	 * 用户邮件激活
	 * @param code	激活码
	 * @return		返回是否激活成功
	 */
	boolean signinActive(String code);
	
	/**
	 * 用户注册
	 * @param login_name	用户名
	 * @param pass_word		密码
	 * @param sex			性别
	 * @param email			邮箱
	 * @return				返回是否注册成功
	 */
	boolean signup(String login_name, String pass_word, char sex, String email);
}
