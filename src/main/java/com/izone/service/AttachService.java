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

import com.izone.AttachType;

public interface AttachService {

	/**
	 * 保存附件
	 * @param attach_id		附件ID
	 * @param uid			用户ID
	 * @param attach_type	附件类型
	 * @param attach_name	附件名称，如：hello.png
	 * @param save_path		保存路径，如：/static/upload/ccjjND_SSVMD2KSQVM/C56A5EECAPVKUR50.png
	 * @param suffix		附件后缀，如：png
	 * @return				返回是否保存成功
	 */
	boolean saveAttach(String attach_id, String uid, AttachType attach_type, String attach_name, String save_path, String suffix);
}
