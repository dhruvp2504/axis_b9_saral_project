package com.axis.saral.service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.axis.saral.service.entity.PolicyDocument;
import com.axis.saral.service.entity.ResponseFile;
import com.axis.saral.service.entity.ResponseMessage;
import com.axis.saral.service.service.PolicyDocumentService;

@Controller
@CrossOrigin(value=	"http://localhost:3000")
public class PolicyDocumentsController {

	@Autowired
	private PolicyDocumentService policyDocumentService;

	@PostMapping("/policydoc/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			policyDocumentService.storeDocument(file);

			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@GetMapping("/policydocs")
	public ResponseEntity<List<ResponseFile>> getListFiles() {
		List<ResponseFile> files = policyDocumentService.getAllFiles().map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/")
					.path(dbFile.getId()).toUriString();

			return new ResponseFile(dbFile.getName(), fileDownloadUri, dbFile.getType(), dbFile.getData().length);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		PolicyDocument policyDocument = policyDocumentService.getPolicyDocument(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + policyDocument.getName() + "\"")
				.body(policyDocument.getData());
	}
}