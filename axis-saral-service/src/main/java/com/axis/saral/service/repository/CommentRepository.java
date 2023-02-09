package com.axis.saral.service.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.axis.saral.service.entity.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Modifying
	@Query("update Comment set message=?1, commentDate=?2, feedId=?3 where commentId=?4")
	public void updateCommentInfo(String message, Date commentDate, long feedId, long commentId);
}
