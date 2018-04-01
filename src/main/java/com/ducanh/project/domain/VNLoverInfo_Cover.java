package com.ducanh.project.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
@Embeddable
public class VNLoverInfo_Cover implements Serializable{

	private static final long serialVersionUID = -7862662839721832534L;
	
	@Id
	private String id;
	
	private String cover_id;
	
	private int offset_x;
	
	private int offset_y;
	
	private String source;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCover_id() {
		return cover_id;
	}

	public void setCover_id(String cover_id) {
		this.cover_id = cover_id;
	}

	public int getOffset_x() {
		return offset_x;
	}

	public void setOffset_x(int offset_x) {
		this.offset_x = offset_x;
	}

	public int getOffset_y() {
		return offset_y;
	}

	public void setOffset_y(int offset_y) {
		this.offset_y = offset_y;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id: " + this.id + "\nX: " + this.offset_x + "\nY:" + this.offset_y + "\nSource: " + this.source;
	}
	
}
