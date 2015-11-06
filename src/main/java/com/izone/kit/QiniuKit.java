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
package com.izone.kit;

import java.io.File;
import java.util.Properties;

import blade.kit.PropertyKit;
import blade.kit.StringKit;
import blade.kit.log.Logger;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public final class QiniuKit {
	
	private static final Logger LOGGER = Logger.getLogger(QiniuKit.class);
	
	private static Auth auth = null;
	private static String bucket = null;
	private static String domain = null;
	private static UploadManager uploadManager = null;
	
	static{
		Properties qiniuConf = PropertyKit.getProperty("qiniu.conf");
		String ak = qiniuConf.getProperty("ACCESS_KEY");
		String sk = qiniuConf.getProperty("SECRET_KEY");
		String bucket = qiniuConf.getProperty("BUCKET");
		String domain = qiniuConf.getProperty("DOMAIN");
		if(StringKit.isNotBlank(ak) && StringKit.isNotBlank(sk) 
				&& StringKit.isNotBlank(bucket) && StringKit.isNotBlank(domain)){
			auth = Auth.create(ak, sk);
			QiniuKit.bucket = bucket;
			QiniuKit.domain = domain;
			uploadManager = new UploadManager();
		}
	}
	
	/**
	 * @return	返回一个七牛生成的token
	 */
	public static String getToken(){
	    return auth.uploadToken(bucket);
	}

	/**
	 * 获取自定义key的token
	 * @param key	key
	 * @return		返回token
	 */
	public static String getToken(String key){
	    return auth.uploadToken(bucket, key);
	}
	
	/**
	 * 上传文件
	 * @param file	文件对象
	 * @param key	文件key
	 */
	public static void upload(File file, String key){
		try {
	        Response res = uploadManager.put(file, key, getToken(key));
	        LOGGER.info(res.toString());
	        LOGGER.info(res.bodyString());
	    } catch (QiniuException e) {
	        Response r = e.response;
	        // 请求失败时简单状态信息
	        LOGGER.error(r.toString());
	        try {
	            // 响应的文本信息
	        	LOGGER.error(r.bodyString());
	        } catch (QiniuException e1) {
	            //ignore
	        }
	    }
	} 
	
	/**
	 * 根据key获取真实url
	 * @param key	key
	 * @return		返回七牛url
	 */
	public static String getQiniuUrl(String key){
		return domain + "/" + key;
	}
	
	/**
	 * @return	返回是否使用七牛
	 */
	public static boolean useQiniu(){
		return null != auth;
	}
}
