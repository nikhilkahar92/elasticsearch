package com.margo.elasticsearch.service;

import java.util.List;
import java.util.Set;

import com.margo.elasticsearch.model.SearchTag;
import com.margo.elasticsearch.model.TagSearchLocation;

public interface TagSearchLocationService {
	
	public void save(SearchTag searchTag);
	
	public List<TagSearchLocation> getListByTagNames(Set<String> tags);

}
