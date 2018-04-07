package com.margo.elasticsearch.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(indexName="margo", type="content")
@XmlRootElement
public class Content {
	
	@Id
	private String id;
	
	private String title;
	
	private long date;
	
	private String status;
	
	@Field(type = FieldType.Object)
	private MetaData metadata;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateValue;
	
	public Content() {
		super();
	}

	public Content(String title, long date, String status, MetaData metadata) {
		super();
		this.title = title;
		this.date = date;
		this.status = status;
		this.metadata = metadata;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public MetaData getMetadata() {
		return metadata;
	}

	public void setMetadata(MetaData metadata) {
		this.metadata = metadata;
	}

	public Date getDateValue() {
		return dateValue;
	}

	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

	public Content(String id, String title, long date, String status, MetaData metadata, Date dateValue) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.status = status;
		this.metadata = metadata;
		this.dateValue = dateValue;
	}
	
	
	
	
}
