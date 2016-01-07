package com.sbiao360.cmsSSO.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -995675488484970764L;

	private String id;
	
	private String name;
	
	private String tel;
	
	private String mail;
	
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Map<String, Object> getUserMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",this.id);
		map.put("tel",this.tel);
		map.put("mail",this.mail);
		map.put("name",this.name);
		return map;
	}
	
}
