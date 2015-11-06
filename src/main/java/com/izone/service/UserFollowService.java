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

public interface UserFollowService {

	/**
	 * 添加关注
	 * @param uid			我的uid	
	 * @param follow_uid	粉丝uid
	 * @return				返回是否关注成功
	 */
	boolean saveFollow(String uid, String follow_uid);
	
	
	/**
	 * 取消关注
	 * @param uid			我的uid
	 * @param unfollow_uid	我关注的人的uid
	 * @return				返回是否取消成功
	 */
	boolean removeFollow(String uid, String unfollow_uid);
	
	/**
	 * 判断我是否关注follow_uid
	 * @param uid			我的uid
	 * @param follow_uid	关注uid
	 * @return				返回是否关注
	 */
	boolean isFollow(String uid, String follow_uid);
	
}
