package com.axis.saral.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class PolicyDocument {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String name;
	private String type;
	private String documentCategory;
	

	@Lob
	private byte[] data;
	
	public PolicyDocument() {
	}

	public PolicyDocument(String name, String type, byte[] data) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	public String getDocumentCategory() {
		return documentCategory;
	}

	public void setDocumentCategory(String documentCategory) {
		this.documentCategory = documentCategory;
	}
	
}
