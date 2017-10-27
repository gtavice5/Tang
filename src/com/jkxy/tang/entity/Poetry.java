package com.jkxy.tang.entity;

import java.util.Date;

/**
 * 诗歌实体类
 * @author allroot123
 *
 */
public class Poetry {
	private int id;
	private int poet_id;
	private String name="";
	private String content;
	private String title;
	private Date created_at;
	private Date updated_at;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPoet_id() {
		return poet_id;
	}
	public void setPoet_id(int poet_id) {
		this.poet_id = poet_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
