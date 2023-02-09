package com.axis.saral.service.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.axis.saral.service.entity.PolicyDocument;
import com.axis.saral.service.repository.PolicyDocumentRepository;

@Service
public class PolicyDocumentService {

	@Autowired
	private PolicyDocumentRepository policyDocumentRepository;
	
	
	public PolicyDocument storeDocument(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		PolicyDocument policyDocument = new PolicyDocument(fileName, file.getContentType(), file.getBytes());
		return policyDocumentRepository.save(policyDocument);
		
	}
	
	public PolicyDocument getPolicyDocument(String id) {
		return policyDocumentRepository.findById(id).get();
	}
	
	 public Stream<PolicyDocument> getAllFiles() {
		    return policyDocumentRepository.findAll().stream();
		  }
}
