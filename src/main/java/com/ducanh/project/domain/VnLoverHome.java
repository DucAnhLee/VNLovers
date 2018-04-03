package com.ducanh.project.domain;

import java.io.Serializable;
import java.util.List;

public class VnLoverHome implements Serializable{

	private static final long serialVersionUID = -5982227238575718657L;

	private VNLoverInfo info;
	
	private VNLoverRating rating;
	
	private List<List<Long>> post_timestamp;
	
	private List<List<Long>> post_per_hours;
	
	private List<List<String>> top10_locations;;

	public VnLoverHome(VNLoverInfo info, VNLoverRating rating, List<List<Long>> post_timestamp, List<List<Long>> post_per_hours, List<List<String>> top10_locations) {
		super();
		this.info = info;
		this.rating = rating;
		this.post_timestamp = post_timestamp;
		this.post_per_hours = post_per_hours;
		this.top10_locations = top10_locations;
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

	public List<List<Long>> getPost_per_hours() {
		return post_per_hours;
	}

	public void setPost_per_hours(List<List<Long>> post_per_hours) {
		this.post_per_hours = post_per_hours;
	}

	public List<List<String>> getTop10_locations() {
		return top10_locations;
	}

	public void setTop10_locations(List<List<String>> top10_locations) {
		this.top10_locations = top10_locations;
	}
	
}
