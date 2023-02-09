package com.axis.saral.service.dto;

import javax.persistence.Lob;

public class PolicyDocumentDto {
	private String documentId;
	
	private String name;
	private String type;
	private String documentCategory;
	

	@Lob
	private byte[] data;


	public PolicyDocumentDto() {
	}


	public PolicyDocumentDto(String documentId, String name, String type, String documentCategory, byte[] data) {
		this.documentId = documentId;
		this.name = name;
		this.type = type;
		this.documentCategory = documentCategory;
		this.data = data;
	}


	public String getDocumentId() {
		return documentId;
	}


	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDocumentCategory() {
		return documentCategory;
	}


	public void setDocumentCategory(String documentCategory) {
		this.documentCategory = documentCategory;
	}


	public byte[] getData() {
		return data;
	}


	public void setData(byte[] data) {
		this.data = data;
	}
	
	
	
}
