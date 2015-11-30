package com.izone.service.impl;

import blade.kit.DateKit;
import blade.kit.StringKit;
import blade.plugin.sql2o.Model;

import com.izone.model.UserLog;
import com.izone.service.UserLogService;

public class UserLogServiceImpl implements UserLogService {

	private Model<UserLog> model = new Model<UserLog>(UserLog.class);
	
	@Override
	public boolean saveUserLog(String uid, String action, String action_data) {
		if (StringKit.isNotBlank(uid) && StringKit.isNotBlank(action) && StringKit.isNotBlank(action_data)) {
			return model.insert().param("uid", uid)
					.param("follow_uid", action)
					.param("dateline", action_data)
					.executeAndCommit() > 0;
		}
		return false;
	}
}
