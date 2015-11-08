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

import com.izone.model.Tag;

public interface TagService {

	/**
	 * 保存标签
	 * @param tag_name	标签名称
	 * @return			返回是否保存成功
	 */
	boolean saveTag(String tag_name);
	
	/**
	 * 查询标签
	 * @param tag_name	标签名称
	 * @return			返回标签对象
	 */
	Tag geTag(String tag_name);
	
	/**
	 * 保存文章关联标签
	 * @param tag_name	标签id
	 * @param post_id	文章id
	 * @return
	 */
	boolean saveTagPost(String tag_name, String post_id);
}
