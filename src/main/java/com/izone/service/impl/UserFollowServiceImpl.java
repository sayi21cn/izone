package com.izone.service.impl;

import blade.kit.DateKit;
import blade.kit.StringKit;
import blade.plugin.sql2o.Model;
import blade.plugin.sql2o.WhereParam;

import com.izone.model.UserFollow;
import com.izone.service.UserFollowService;

public class UserFollowServiceImpl implements UserFollowService {

	private Model<UserFollow> model = new Model<UserFollow>(UserFollow.class);

	@Override
	public boolean saveFollow(String uid, String follow_uid) {
		if (StringKit.isNotBlank(uid) && StringKit.isNotBlank(follow_uid)) {
			return model.insert().param("uid", uid)
					.param("follow_uid", follow_uid)
					.param("dateline", DateKit.getCurrentUnixTime())
					.executeAndCommit() > 0;
		}
		return false;
	}

	@Override
	public boolean removeFollow(String uid, String unfollow_uid) {
		if (StringKit.isNotBlank(uid) && StringKit.isNotBlank(unfollow_uid)) {
			WhereParam whereParam = WhereParam.me();
			whereParam.eq("uid", uid).eq("unfollow_uid", unfollow_uid);
			return model.delete().where(whereParam).executeAndCommit() > 1;
		}
		return false;
	}

	@Override
	public boolean isFollow(String uid, String follow_uid) {
		if (StringKit.isNotBlank(uid) && StringKit.isNotBlank(follow_uid)) {
			WhereParam whereParam = WhereParam.me();
			whereParam.eq("uid", uid).eq("follow_uid", follow_uid);
			return model.select().where(whereParam).executeAndCommit() > 1;
		}
		return false;
	}

}
