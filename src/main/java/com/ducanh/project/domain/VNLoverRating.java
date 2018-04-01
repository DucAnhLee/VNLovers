package com.ducanh.project.domain;

import java.io.Serializable;
import java.util.List;

public class VNLoverRating implements Serializable{

	private static final long serialVersionUID = 8377485175503653005L;

	private String rating_count;
	
	private List<String> rating_description;
	
	private List<String> rating_star;

	public String getRating_count() {
		return rating_count;
	}

	public void setRating_count(String rating_count) {
		this.rating_count = rating_count;
	}

	public List<String> getRating_description() {
		return rating_description;
	}

	public void setRating_description(List<String> rating_description) {
		this.rating_description = rating_description;
	}

	public List<String> getRating_star() {
		return rating_star;
	}

	public void setRating_star(List<String> rating_star) {
		this.rating_star = rating_star;
	}
	
}
