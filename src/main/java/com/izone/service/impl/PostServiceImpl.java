package com.izone.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blade.kit.StringKit;
import blade.plugin.sql2o.Model;
import blade.plugin.sql2o.Page;
import blade.plugin.sql2o.WhereParam;

import com.izone.PostType;
import com.izone.model.Post;
import com.izone.model.UserFollow;
import com.izone.service.PostService;

public class PostServiceImpl implements PostService {

	private Model<Post> model = new Model<Post>(Post.class);

	@Override
	public boolean savePost(String uid, PostType postType, String title,
			String content) {
		if (StringKit.isNotBlank(uid) && StringKit.isNotBlank(title)
				&& StringKit.isNotBlank(content)) {
			return model
					.insert()
					.param("uid", uid)
					.param("postType", postType)
					.param("title", title)
					.executeAndCommit() > 1;
		}
		return false;
	}

	@Override
	public boolean updatePost(String post_id, String uid, String title, String content) {
		Model<Post> param = model.update();
		if (StringKit.isNotBlank(post_id)){
			param.param("post_id", post_id);
		}else if (StringKit.isNotBlank(uid)) {
			param.param("uid", uid);
		}else if (StringKit.isNotBlank(title)) {
			param.param("title", title);
		}else if (StringKit.isNotBlank(content)) {
			param.param("content", content);
		}
		return false;
	}

	@Override
	public boolean removePost(String post_id) {
		if (StringKit.isNotBlank(post_id)){
			return model.delete().param("post_id", post_id).executeAndCommit() > 1;
		}
		return false;
	}

	@Override
	public Post getPost(String post_id) {
		return  model.select().param("post_id", post_id).fetchOne();
	}

	@Override
	public Page<Post> getPostPage(WhereParam whereParam, String orderby, Integer page, Integer pageSize) {
		return model.select().where(whereParam).orderBy(orderby).fetchPage(page, pageSize);
	}
}
