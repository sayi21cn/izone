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
package com.izone.route.front;

import java.io.File;

import com.blade.annotation.Inject;
import com.blade.http.Request;
import com.blade.http.Response;
import com.blade.servlet.multipart.FileItem;
import com.izone.kit.SessionKit;
import com.izone.model.User;
import com.izone.service.AttachService;

import blade.kit.json.JsonObject;

/**
 * 
 * <p>
 * 上传路由
 * </p>
 *
 * @author	<a href="mailto:biezhi.me@gmail.com" target="_blank">biezhi</a>
 * @since	1.0
 */
public class UploadRoute {

	@Inject
	private AttachService attachService;
	
	/**
	 * 上传图片接口
	 * @param request
	 * @param response
	 * 返回格式：
	 * {"status":200, "url":"", "filename":"aaa.jpg"}
	 */
	public void upload_img(Request request, Response response){
		
		JsonObject jsonObject = new JsonObject();
		
		User user = SessionKit.getLoginUser(request);
		if(null == user){
			jsonObject.add("status", 500);
			jsonObject.add("msg", "user not signin!");
			return;
		}
		
		FileItem[] fileItems = request.files();
		if(null != fileItems && fileItems.length > 0){
			
			FileItem fileItem = fileItems[0];
			File file = fileItem.getFile();
			String filename = fileItem.getFileName();
			String name = fileItem.getName();
			System.out.println("file = " + file);
			System.out.println("filename = " + filename);
			System.out.println("name = " + name);
			
		} else {
			jsonObject.add("status", 500);
			jsonObject.add("msg", "no file upload!");
		}
	}
}
