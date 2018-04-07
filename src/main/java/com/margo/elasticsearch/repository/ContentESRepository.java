package com.margo.elasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.margo.elasticsearch.model.Content;

@Repository
public interface ContentESRepository extends ElasticsearchRepository<Content, String>{
	
	public List<Content> findByTitle(String title);
	
}
