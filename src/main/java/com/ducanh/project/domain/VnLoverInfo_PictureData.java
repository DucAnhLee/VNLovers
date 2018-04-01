package com.ducanh.project.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

//@Entity
@Embeddable
public class VnLoverInfo_PictureData implements Serializable{

	private static final long serialVersionUID = 1962299717586031799L;

	private int height;
	
	private int width;
	
	private boolean is_silhouette;
	
	private String url;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public boolean isIs_silhouette() {
		return is_silhouette;
	}

	public void setIs_silhouette(boolean is_silhouette) {
		this.is_silhouette = is_silhouette;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
