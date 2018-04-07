package com.margo.elasticsearch.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.margo.elasticsearch.model.TagSearchLocation;

@Repository
public interface TagSearchLocationRepository extends ElasticsearchRepository<TagSearchLocation, String>{
	
	public TagSearchLocation findByTagName(String tag);
	
	public List<TagSearchLocation> findByTagNameIn(Set<String> tags);

}
