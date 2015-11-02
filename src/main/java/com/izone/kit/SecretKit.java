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

import blade.kit.HashidKit;
import blade.kit.StringKit;

/**
 * 
 * <p>
 * 加密解密类
 * </p>
 *
 * @author	<a href="mailto:biezhi.me@gmail.com" target="_blank">biezhi</a>
 * @since	1.0
 */
public class SecretKit {

	/**
	 * 生成用户密码
	 * @param login_name
	 * @param pass_word
	 * @return
	 */
	public static String password(String login_name, String pass_word){
		if(StringKit.isNotBlank(login_name) && StringKit.isNotBlank(pass_word)){
			HashidKit hashidKit = new HashidKit(login_name + pass_word, 32);
			return hashidKit.encode( login_name.length() );
		}
		return null;
	}
	
	public static void main(String[] args) {
		String login_name = "biezhi";
		String pass_word = "123456";
		
		System.out.println(password(login_name, pass_word));
		
	}
}
