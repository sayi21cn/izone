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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import blade.kit.FileKit;
import blade.kit.IOKit;
import blade.kit.json.JsonObject;

import com.blade.Blade;
import com.blade.annotation.Inject;
import com.blade.http.Request;
import com.blade.http.Response;
import com.blade.servlet.multipart.FileItem;
import com.izone.AttachType;
import com.izone.Const;
import com.izone.kit.SecretKit;
import com.izone.kit.SessionKit;
import com.izone.model.User;
import com.izone.service.AttachService;

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
			response.json(jsonObject.toString());
			return;
		}
		FileItem[] fileItems = request.files();
		if(null != fileItems && fileItems.length > 0){
			
			FileItem fileItem = fileItems[0];
			File file = fileItem.getFile();
			String filename = fileItem.getFileName();
			
			String suffix = FileKit.getExtension(filename);
			
			String attach_id = SecretKit.createAttachId(filename);
			
			String filePath = Const.UPLOAD_DIR + File.separator + user.getUid() + File.separator + attach_id + "." + suffix;
			
			String fileRealPath = Blade.me().webRoot() + File.separator + filePath;
			
			nioTransferCopy(file, fileRealPath);
			
			jsonObject.add("status", 200);
			jsonObject.add("filename", filename);
			jsonObject.add("url", request.contextPath() + filePath.replaceAll("\\\\", "/"));
			
			attachService.saveAttach(attach_id, user.getUid(), AttachType.image, filename, filePath, suffix);
			
		} else {
			jsonObject.add("status", 500);
			jsonObject.add("msg", "no file upload!");
		}
		
		response.json(jsonObject.toString());
	}
	
	private static void nioTransferCopy(File source, String target) {  
	    FileChannel in = null;  
	    FileChannel out = null;  
	    FileInputStream inStream = null;  
	    FileOutputStream outStream = null;  
	    try {  
	        inStream = new FileInputStream(source);  
	        outStream = new FileOutputStream(new File(target));  
	        in = inStream.getChannel();  
	        out = outStream.getChannel();  
	        in.transferTo(0, in.size(), out);  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {  
	    	IOKit.closeQuietly(inStream);
	    	IOKit.closeQuietly(in);  
	    	IOKit.closeQuietly(outStream);  
	    	IOKit.closeQuietly(out);  
	    }  
	}  
	
}
