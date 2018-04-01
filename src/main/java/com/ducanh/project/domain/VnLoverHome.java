package com.ducanh.project.domain;

import java.io.Serializable;
import java.util.List;

public class VnLoverHome implements Serializable{

	private static final long serialVersionUID = -5982227238575718657L;

	private VNLoverInfo info;
	
	private VNLoverRating rating;
	
	private List<List<Long>> post_timestamp;

	public VnLoverHome(VNLoverInfo info, VNLoverRating rating, List<List<Long>> post_timestamp) {
		super();
		this.info = info;
		this.rating = rating;
		this.post_timestamp = post_timestamp;
	}

	public VNLoverInfo getInfo() {
		return info;
	}

	public void setInfo(VNLoverInfo info) {
		this.info = info;
	}

	public VNLoverRating getRating() {
		return rating;
	}

	public void setRating(VNLoverRating rating) {
		this.rating = rating;
	}

	public List<List<Long>> getPost_timestamp() {
		return post_timestamp;
	}

	public void setPost_timestamp(List<List<Long>> post_timestamp) {
		this.post_timestamp = post_timestamp;
	}
	
}
