package com.axis.saral.service.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.saral.service.entity.NewsFeed;



@Repository
public interface NewsFeedRepository extends JpaRepository<NewsFeed, Long> {

}
