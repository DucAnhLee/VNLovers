package com.ducanh.project.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
@Embeddable
public class VNLoverInfo_Data implements Serializable{

	private static final long serialVersionUID = -5158049731907834989L;

	@Id
	private String id;
	
	private int checkins;
	
	private String description;
	
	private int fan_count;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCheckins() {
		return checkins;
	}

	public void setCheckins(int checkins) {
		this.checkins = checkins;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFan_count() {
		return fan_count;
	}

	public void setFan_count(int fan_count) {
		this.fan_count = fan_count;
	}

	public int getRating_count() {
		return rating_count;
	}

	public void setRating_count(int rating_count) {
		this.rating_count = rating_count;
	}

	public int getTalking_about_count() {
		return talking_about_count;
	}

	public void setTalking_about_count(int talking_about_count) {
		this.talking_about_count = talking_about_count;
	}

	public VNLoverInfo_Cover getCover() {
		return cover;
	}

	public void setCover(VNLoverInfo_Cover cover) {
		this.cover = cover;
	}

	public VNLoverInfo_Picture getPicture() {
		return picture;
	}

	public void setPicture(VNLoverInfo_Picture picture) {
		this.picture = picture;
	}

	private int rating_count;
	
	private int talking_about_count;
	
	@Embedded
	private VNLoverInfo_Cover cover;
	
	@Embedded
	private VNLoverInfo_Picture picture;
	
}
