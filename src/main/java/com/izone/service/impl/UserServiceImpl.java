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

import com.blade.annotation.Component;
import com.izone.kit.SecretKit;
import com.izone.model.User;
import com.izone.service.UserService;

import blade.kit.StringKit;
import blade.plugin.sql2o.Model;
import blade.plugin.sql2o.Page;
import blade.plugin.sql2o.WhereParam;

@Component
public class UserServiceImpl implements UserService {
	
	private Model<User> model = new Model<User>(User.class);
	
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

}
