package com.axis.saral.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.saral.service.entity.PolicyDocument;

public interface PolicyDocumentRepository extends JpaRepository<PolicyDocument, String> {

}
