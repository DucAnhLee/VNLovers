package com.ducanh.project.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mess {
	@Id
	private Long id;
	private String message;
	private String data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + ": " + this.message + ": " + this.data;
	}
}
