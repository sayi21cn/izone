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
import com.izone.model.ActiveCode;
import com.izone.service.ActiveCodeService;

import blade.kit.DateKit;
import blade.kit.EncrypKit;
import blade.kit.StringKit;
import blade.plugin.sql2o.Model;
import blade.plugin.sql2o.WhereParam;

@Component
public class ActiveCodeServiceImpl implements ActiveCodeService {

	private Model<ActiveCode> model = new Model<ActiveCode>(ActiveCode.class);
	
	@Override
	public ActiveCode getActiveCode(WhereParam where) {
		if(null != where){
			return model.select().where(where).fetchOne();
		}
		return null;
	}

	@Override
	public boolean saveActiveCode(String email) {
		if(StringKit.isNotBlank(email)){
			String code = EncrypKit.md5(email + StringKit.random(5));
			return model.insert()
			.param("code", code)
			.param("email", email)
			.param("status", 0)
			.param("dateline", DateKit.getCurrentUnixTime())
			.executeAndCommit() > 0;
		}
		return false;
	}

}
