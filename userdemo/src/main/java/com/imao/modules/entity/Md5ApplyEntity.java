package com.imao.modules.entity;

import java.io.Serializable;

public class Md5ApplyEntity  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String md5;
	
	
	private String len;
	
	public Md5ApplyEntity() {
		
	}
	
	public Md5ApplyEntity(String name, String md5, String len) {
		
		this.name = name;
		this.md5 = md5;
		this.len = len;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getLen() {
		return len;
	}
	public void setLen(String len) {
		this.len = len;
	}
	
}
