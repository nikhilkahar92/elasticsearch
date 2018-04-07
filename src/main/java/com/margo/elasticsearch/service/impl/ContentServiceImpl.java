package com.margo.elasticsearch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.margo.elasticsearch.model.Content;
import com.margo.elasticsearch.model.SearchTag;
import com.margo.elasticsearch.repository.ContentESRepository;
import com.margo.elasticsearch.repository.ContentSearchBuilder;
import com.margo.elasticsearch.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentESRepository contentESRepository;
	
	@Autowired
	private ContentSearchBuilder contentSearchBuilder;
	
	@Override
	public Content save(Content content) {
		content.setDate(content.getDateValue().getTime());
		return contentESRepository.save(content);
	}

	@Override
	public List<Content> search(SearchTag searchTag) {
		return contentSearchBuilder.getList(searchTag);
	}

}
