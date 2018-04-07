package com.margo.elasticsearch.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.margo.elasticsearch.model.SearchTag;
import com.margo.elasticsearch.model.TagSearchLocation;
import com.margo.elasticsearch.repository.TagSearchLocationRepository;
import com.margo.elasticsearch.service.TagSearchLocationService;

@Service
public class TagSerachLocationServiceImpl implements TagSearchLocationService{
	
	@Autowired
	private TagSearchLocationRepository tagSearchLocationRepository;

	@Override
	public void save(SearchTag searchTag) {
		if(searchTag.getTags()!=null && !searchTag.getTags().isEmpty()){
			TagSearchLocation tagSL = null;
			Set<Map<String, Double>> locationDetails=null;
			Map<String, Double> location = new HashMap<>();
			location.put("lat", searchTag.getLat());
			location.put("lon", searchTag.getLon());
			for(String tagName : searchTag.getTags()){
			 tagSL= tagSearchLocationRepository.findByTagName(tagName);
			 if(tagSL!=null){
				 locationDetails = tagSL.getLocation();
				 locationDetails.add(location);
				 tagSL.setLocation(locationDetails);
			 }else{
				 locationDetails = new HashSet<>();
				 locationDetails.add(location);
				 tagSL = new TagSearchLocation(tagName, locationDetails);
			 }
			 tagSearchLocationRepository.save(tagSL);
			}
		}
	}

	@Override
	public List<TagSearchLocation> getListByTagNames(Set<String> tags) {
		return tagSearchLocationRepository.findByTagNameIn(tags);
	}

}
