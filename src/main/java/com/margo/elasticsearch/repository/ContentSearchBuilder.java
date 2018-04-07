package com.margo.elasticsearch.repository;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import com.margo.elasticsearch.model.Content;
import com.margo.elasticsearch.model.SearchTag;

@Component
public class ContentSearchBuilder {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	public List<Content> getList(SearchTag searchTag){
		String searchContent = "";
		StringBuilder sb = new StringBuilder("");
		if(searchTag.getTags()!=null && !searchTag.getTags().isEmpty()){
		for(String s : searchTag.getTags()){
			sb=sb.append(s+",");
		}
		 searchContent = sb.substring(0, sb.lastIndexOf(","));
		}
		QueryBuilder query = QueryBuilders.boolQuery()
				.should(QueryBuilders.queryStringQuery(searchContent)
				.lenient(true).field("metadata.tags"));
		NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(query).build();
		return elasticsearchTemplate.queryForList(build, Content.class);
	}
}
