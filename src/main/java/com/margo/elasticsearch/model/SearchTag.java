package com.margo.elasticsearch.model;

import java.util.Set;

public class SearchTag {
	
	private Set<String> tags;
	
	private double lat;
	
	private double lon;

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public SearchTag() {
		super();
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}
	
	

}
