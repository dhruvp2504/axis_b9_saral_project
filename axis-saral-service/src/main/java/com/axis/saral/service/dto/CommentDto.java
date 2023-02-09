package com.axis.saral.service.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class CommentDto {

	private String message;
	private Long employeeId;
	private Long newsFeedId;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private Date commentDate; 
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getMessage() {
		return message;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getNewsFeedId() {
		return newsFeedId;
	}
	public void setNewsFeedId(Long newsFeedId) {
		this.newsFeedId = newsFeedId;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
