package com.izone.service.impl;

import blade.kit.StringKit;
import blade.plugin.sql2o.Model;

import com.izone.model.Tag;
import com.izone.service.TagService;

public class TagServiceImpl implements TagService {

	private Model<Tag> model = new Model<Tag>(Tag.class);
	
	@Override
	public boolean saveTag(String tag_name) {
		if (StringKit.isNotBlank(tag_name)) {
			return model
					.insert()
					.param("tag_name", tag_name)
					.executeAndCommit() > 1;
		}
		return false;
	}

	@Override
	public Tag geTag(String tag_name) {
		return  model.select().param("tag_name", tag_name).fetchOne();
	}

	@Override
	public boolean saveTagPost(String tag_name, String post_id) {
		if (StringKit.isNotBlank(tag_name) && StringKit.isNotBlank(post_id)) {
			return model
					.insert()
					.param("tag_name", tag_name)
					.param("post_id", post_id)
					.executeAndCommit() > 1;
		}
		return false;
	}

}
