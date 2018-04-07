package com.margo.elasticsearch.model;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class MetaData {
	
	private String region;
	
	private String long_synopsis;
	
	private String meta_desc;
	
	private Set<String> tags;
	
	
	
	public MetaData() {
		super();
	}

	public MetaData(String region, String long_synopsis, String meta_desc, Set<String> tags) {
		super();
		this.region = region;
		this.long_synopsis = long_synopsis;
		this.meta_desc = meta_desc;
		this.tags = tags;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLong_synopsis() {
		return long_synopsis;
	}

	public void setLong_synopsis(String long_synopsis) {
		this.long_synopsis = long_synopsis;
	}

	public String getMeta_desc() {
		return meta_desc;
	}

	public void setMeta_desc(String meta_desc) {
		this.meta_desc = meta_desc;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	
	
	

}
