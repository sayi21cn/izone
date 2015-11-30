package com.izone.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blade.kit.DateKit;
import blade.kit.StringKit;
import blade.plugin.sql2o.Model;

import com.izone.model.Options;
import com.izone.service.OptionsService;

public class OptionsServiceImpl implements OptionsService {

	private Model<Options> model = new Model<Options>(Options.class);
	@Override
	public boolean saveOptions(String opt_name, String opt_value) {
		if(StringKit.isNotBlank(opt_name) && StringKit.isNotBlank(opt_value)){
			return model.insert()
			.param("opt_name", opt_name)
			.param("opt_value", opt_value)
			.param("dateline", DateKit.getCurrentUnixTime())
			.executeAndCommit() > 0;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> getOptions() {
		Model<Options> models = model.select();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("modesl", models);
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		resultList.add(resultMap);
		return resultList;
	}
}
