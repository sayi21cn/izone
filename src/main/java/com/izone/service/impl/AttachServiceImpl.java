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
import com.izone.model.Attach;
import com.izone.service.AttachService;

import blade.kit.DateKit;
import blade.kit.StringKit;
import blade.plugin.sql2o.Model;

@Component
public class AttachServiceImpl implements AttachService {

	private Model<Attach> model = new Model<Attach>(Attach.class);
	
	@Override
	public boolean saveAttach(String attach_id, String uid, String attach_type, String attach_name, String save_path,
			String suffix) {
		if(StringKit.isNotBlank(attach_id) && StringKit.isNotBlank(uid) && StringKit.isNotBlank(attach_type)
				&& StringKit.isNotBlank(attach_name) && StringKit.isNotBlank(save_path) && StringKit.isNotBlank(suffix)){
			
			return model.insert()
			.param("attach_id", attach_id)
			.param("uid", uid)
			.param("attach_type", attach_type)
			.param("attach_name", attach_name)
			.param("save_path", save_path)
			.param("suffix", suffix)
			.param("dateline", DateKit.getCurrentUnixTime())
			.executeAndCommit() > 0;
		}
		return false;
	}

}
