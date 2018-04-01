package com.ducanh.project.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

//@Entity
@Embeddable
public class VNLoverInfo_Picture implements Serializable{

	private static final long serialVersionUID = -5476099856840821524L;
	
	@Column(name = "data")
	private VnLoverInfo_PictureData data;

	public VnLoverInfo_PictureData getData() {
		return data;
	}

	public void setData(VnLoverInfo_PictureData data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Url: " + this.data.getUrl() + "\nHeight: " + this.data.getHeight() + "\nWidth: " + this.data.getWidth();
	}
}
