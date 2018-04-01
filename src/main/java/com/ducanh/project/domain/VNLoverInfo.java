package com.ducanh.project.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

//@Entity
public class VNLoverInfo implements Serializable{

	private static final long serialVersionUID = -5158049731907834989L;

	@Embedded
	@Column(name = "data")
	private VNLoverInfo_Data data;

	public VNLoverInfo_Data getData() {
		return data;
	}

	public void setData(VNLoverInfo_Data data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		VNLoverInfo_Data d = this.data;
		return "Id: "+d.getId() +"\nCheckins:" + d.getCheckins() + "\nFancount: " + d.getFan_count() + "\nRatingCOunt:" + d.getRating_count() + "\nTalkingAbout: " + d.getTalking_about_count() + "\nCover: " + d.getCover() + "\nPicture: " + d.getPicture();
	}
}
