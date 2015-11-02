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
package com.izone.service.impl;

import org.sql2o.Connection;

import com.blade.annotation.Component;
import com.blade.annotation.Inject;
import com.izone.kit.SecretKit;
import com.izone.model.ActiveCode;
import com.izone.model.User;
import com.izone.service.ActiveCodeService;
import com.izone.service.UserService;

import blade.kit.DateKit;
import blade.kit.MailKit;
import blade.kit.StringKit;
import blade.plugin.sql2o.Model;
import blade.plugin.sql2o.Page;
import blade.plugin.sql2o.WhereParam;

@Component
public class UserServiceImpl implements UserService {
	
	private Model<User> model = new Model<User>(User.class);
	
	@Inject
	private ActiveCodeService activeCodeService; 
	
	public User getUser(WhereParam where) {
		return model.select().where(where).fetchOne();
	}
	
	public User signin(String login_name, String pass_word) {
		String pwd = SecretKit.password(login_name, pass_word);
		if(StringKit.isNotBlank(pwd)){
			
			WhereParam where = WhereParam.me();
			where.eq("login_name", login_name)
			.eq("pass_word", pwd);
			
			return getUser(where);
		}
		return null;
	}

	public Page<User> getUserPage(WhereParam where, Integer page, Integer pageSize) {
		Page<User> userPage = 
				model.select().where(where)
				.orderBy("dateline desc")
				.fetchPage(page, pageSize);
		return userPage;
	}

	public boolean updateStatus(String uid, Byte status) {
		if(StringKit.isNotBlank(uid) && null != status){
			return model.update().param("status", status).eq("uid", uid).executeAndCommit() > 0;
		}
		return false;
	}
	
	@Override
	public boolean signup(String login_name, String pass_word, char sex, final String email) {
		if(StringKit.isNotBlank(login_name) && StringKit.isNotBlank(pass_word) && StringKit.isNotBlank(email)){
			
			String pwd = SecretKit.password(login_name, pass_word); 
			
			int count = model.insert()
			.param("login_name", login_name)
			.param("pass_word", pwd)
			.param("sex", sex)
			.param("status", 0)
			.param("email", email)
			.param("group_id", 0)
			.param("reg_time", DateKit.getCurrentUnixTime())
			.executeAndCommit();
			
			if(count > 0){
				// 发送邮件
				MailKit.asynSend(email, "验证你的 Izone 邮箱", "感谢选择 Izone，点击下面链接验证邮箱：<br/> <a>aaaa</a>");
				
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean signinActive(String code) {
		if(StringKit.isNotBlank(code)){
			WhereParam where = WhereParam.me();
			where.eq("code","code");
			ActiveCode activeCode = activeCodeService.getActiveCode(where);
			if(null != activeCode){
				String email = activeCode.getEmail();
				Connection connection = model.getSql2o().beginTransaction();
				connection = model.update().param("status", 1).eq("email", email).execute(connection);
				Integer count = model.update("update i_activecode").param("status", 1).eq("code", code).executeAndCommit();
				
				if(count > 0){
					return true;
				}
			}
		}
		return false;
	}
    
}
