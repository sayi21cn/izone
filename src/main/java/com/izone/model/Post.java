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
package com.izone.model;

import java.io.Serializable;

import blade.plugin.sql2o.Table;

@Table(value = "i_post", PK = "post_id")
public class Post implements Serializable {

	private static final long serialVersionUID = -5601361748536271990L;
	private String post_id;
	private String post_type;
	private String title;
	private String content;
	private Integer star_count;
	private Integer reply_count;
	private Integer dateline;
	private Integer update_time;

	public Post() {
	}

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getPost_type() {
		return post_type;
	}

	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStar_count() {
		return star_count;
	}

	public void setStar_count(Integer star_count) {
		this.star_count = star_count;
	}

	public Integer getReply_count() {
		return reply_count;
	}

	public void setReply_count(Integer reply_count) {
		this.reply_count = reply_count;
	}

	public Integer getDateline() {
		return dateline;
	}

	public void setDateline(Integer dateline) {
		this.dateline = dateline;
	}

	public Integer getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Integer update_time) {
		this.update_time = update_time;
	}
}
