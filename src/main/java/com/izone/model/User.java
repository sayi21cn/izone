package com.izone.model;

import java.io.Serializable;

import blade.plugin.sql2o.Table;

@Table(value = "i_user", PK = "uid")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uid;
	private String login_name;
	private String nick_name;
	private String pass_word;
	private char sex;
	private String email;
	private String avatar;
	private Byte status;
	private Byte group_id;
	private Integer reg_time;
	
	public User() {
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Byte group_id) {
		this.group_id = group_id;
	}

	public Integer getReg_time() {
		return reg_time;
	}

	public void setReg_time(Integer reg_time) {
		this.reg_time = reg_time;
	}
	
}
