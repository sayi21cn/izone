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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import blade.kit.PatternKit;
import blade.kit.PropertyKit;

/**
 * 
 * <p>
 * 表单验证器
 * </p>
 *
 * @author	<a href="mailto:biezhi.me@gmail.com" target="_blank">biezhi</a>
 * @since	1.0
 */
public class Validator {
	
	private Object object;
	
	private String keyName;
	
	private List<String> errors;
	
	private boolean isNull;
	
	private static Map<String, String> errorMsg = new HashMap<String, String>();
	
	static {
		errorMsg = PropertyKit.getPropertyMap("validation.lang");
	}
	
	public Validator(Object object, String keyName) {
		this.object = object;
		this.keyName = keyName;
		this.errors = new ArrayList<String>();
		if(null == object){
			isNull = false;
		}
	}
	
	public Validator required(){
		if(isNull){
			String msg = String.format(errorMsg.get("required"), keyName);
			errors.add(msg);
		}
		return this;
	}
	
	public Validator email(){
		if(!isNull){
			if(!PatternKit.isEmail(object.toString())){
				errors.add(errorMsg.get("email"));
			}
		}
		return this;
	}
	
	public Validator date(){
		if(!isNull){
			if(!PatternKit.isBirthday(object.toString())){
				errors.add(errorMsg.get("date"));
			}
		}
		return this;
	}
	
	public Validator number(){
		if(!isNull){
			if(!PatternKit.isNumber(object.toString())){
				errors.add(errorMsg.get("number"));
			}
		}
		return this;
	}
	
	public Validator phone(){
		if(!isNull){
			if(!PatternKit.isPhone(object.toString())){
				errors.add(errorMsg.get("phone"));
			}
		}
		return this;
	}
	
	public Validator url(){
		if(!isNull){
			if(!PatternKit.isURL(object.toString())){
				errors.add(errorMsg.get("url"));
			}
		}
		return this;
	}
	
	public Validator min(Number number){
		if(!isNull){
			Number obj = (Number) object;
			if( obj.doubleValue() < number.doubleValue() ){
				errors.add(errorMsg.get("min"));
			}
		}
		return this;
	}
	
	public Validator max(Number number){
		if(!isNull){
			Number obj = (Number) object;
			if( obj.doubleValue() > number.doubleValue() ){
				errors.add(errorMsg.get("max"));
			}
		}
		return this;
	}
	
	public Validator minLen(int len){
		if(!isNull){
			int objLen = object.toString().length();
			if( objLen < len ){
				errors.add(errorMsg.get("minLen"));
			}
		}
		return this;
	}
	
	public Validator maxLen(int len){
		if(!isNull){
			int objLen = object.toString().length();
			if( objLen > len ){
				errors.add(errorMsg.get("maxLen"));
			}
		}
		return this;
	}
	
}
