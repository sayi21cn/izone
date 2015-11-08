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

import java.util.Map;

import blade.plugin.sql2o.Page;
import blade.plugin.sql2o.WhereParam;

import com.izone.PostType;
import com.izone.model.Post;

public interface PostService {

	/**
	 * 保存文章
	 * @param uid		用户Id
	 * @param postType	文章类型 {@link com.izone.AttachType}
	 * @param title		文章标题
	 * @param content	文章内容
	 * @return			返回是否保存成功
	 */
	boolean savePost(String uid, PostType postType, String title, String content);
	
	/**
	 * 修改文章
	 * @param post_id	文章id
	 * @param uid		用户id
	 * @param title		文章标题
	 * @param content	文章内容
	 * @return			返回是否修改成功
	 */
	boolean updatePost(String post_id, String uid, String title, String content);
	
	/**
	 * 删除文章
	 * @param post_id	文章id
	 * @return			返回是否删除成功
	 */
	boolean removePost(String post_id);
	
	/**
	 * 查询一个文章
	 * @param post_id	文章id
	 * @return			返回文章对象
	 */
	Post getPost(String post_id);
	
	/**
	 * 分页查询文章
	 * @param whereParam	查询条件
	 * @param orderby		排序规则
	 * @param page			页码
	 * @param pageSize		每页条数
	 * @return				返回分页对象
	 */
	Page<Map<String, Object>> getPostPage(WhereParam whereParam, String orderby, Integer page, Integer pageSize);
	
}
