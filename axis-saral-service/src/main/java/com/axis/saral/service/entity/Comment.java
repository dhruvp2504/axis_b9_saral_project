package com.axis.saral.service.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private long commentId;
	private String message;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private Date commentDate;
	private long feedId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "news_feed_id")
	private NewsFeed newsFeed;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "commented_by")
	private Employee employee;

	public Comment() {
	}

	public Comment(long commentId, String message, Date commentDate, long feedId) {
		super();
		this.commentId = commentId;
		this.message = message;
		this.commentDate = commentDate;
		this.feedId = feedId;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public long getFeedId() {
		return feedId;
	}

	public void setFeedId(long feedId) {
		this.feedId = feedId;
	}

	public NewsFeed getNewsFeed() {
		return newsFeed;
	}

	public void setNewsFeed(NewsFeed newsFeed) {
		this.newsFeed = newsFeed;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return commentId == other.commentId;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", message=" + message
				+ ", commentDate=" + commentDate + ", feedId=" + feedId + "]";
	}

}
