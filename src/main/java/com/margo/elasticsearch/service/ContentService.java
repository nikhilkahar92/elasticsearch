package com.margo.elasticsearch.service;

import java.util.List;

import com.margo.elasticsearch.model.Content;
import com.margo.elasticsearch.model.SearchTag;

public interface ContentService {
	
	public Content save(Content content);
	
	public List<Content> search(SearchTag searchTag);

}
