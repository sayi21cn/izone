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

import com.izone.model.ActiveCode;

import blade.plugin.sql2o.WhereParam;

public interface ActiveCodeService {
	
	/**
	 * 根据条件获取激活码
	 * @param where	查询条件
	 * @return		返回激活码对象
	 */
	ActiveCode getActiveCode(WhereParam where);
	
	/**
	 * 保存一个激活码
	 * @param email	邮箱
	 * @return		返回是否保存成功
	 */
	boolean saveActiveCode(String email);
	
}
