package com.margo.elasticsearch.model;

import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="margo", type="tag-location")
@XmlRootElement
public class TagSearchLocation {
	
	@Id
	private String id;
	
	private String tagName;
	
	private Set<Map<String,Double>> location;
	
	public TagSearchLocation() {
		super();
	}

	public TagSearchLocation(String tagName, Set<Map<String, Double>> location) {
		super();
		this.tagName = tagName;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Set<Map<String, Double>> getLocation() {
		return location;
	}

	public void setLocation(Set<Map<String, Double>> location) {
		this.location = location;
	}
	
	

}
