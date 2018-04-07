package com.margo.elasticsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.margo.elasticsearch.model.Content;
import com.margo.elasticsearch.model.SearchTag;
import com.margo.elasticsearch.model.TagSearchLocation;
import com.margo.elasticsearch.service.ContentService;
import com.margo.elasticsearch.service.TagSearchLocationService;

@RestController
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private TagSearchLocationService tagSearchLocationService;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Content save(@RequestBody Content content){
		return contentService.save(content);
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public List<Content> searchByTag(@RequestBody SearchTag searchTag){
		tagSearchLocationService.save(searchTag);
		return contentService.search(searchTag);
	}
	
	@RequestMapping(value="/loation-by-tag", method=RequestMethod.POST)
	public List<TagSearchLocation> locationByTag(@RequestBody SearchTag searchTag){
		return tagSearchLocationService.getListByTagNames(searchTag.getTags());
	}

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test(){
		return "Rest is Working";
	}

}
