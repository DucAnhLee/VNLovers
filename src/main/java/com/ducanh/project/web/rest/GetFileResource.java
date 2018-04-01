package com.ducanh.project.web.rest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducanh.project.domain.VNLoverInfo;
import com.ducanh.project.domain.VNLoverRating;
import com.ducanh.project.domain.VnLoverHome;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/get-file")
public class GetFileResource {
	
	public ObjectMapper mapper = new ObjectMapper();
	
	@GetMapping("/get-vnlover-home")
	public ResponseEntity<VnLoverHome> getVNLoverHome() throws IOException {
		List<List<Long>> post_timestamp = mapper.readValue(new FileInputStream(ResourceUtils.getFile("classpath:post_timestampv2.json")), new TypeReference<List<List<Long>>>(){});
		
		TypeReference<List<VNLoverInfo>> typeReference = new TypeReference<List<VNLoverInfo>>(){};
		List<VNLoverInfo> info = mapper.readValue(new FileInputStream(ResourceUtils.getFile("classpath:vnlover_info.json")),typeReference);

		TypeReference<List<VNLoverRating>> typeReference1 = new TypeReference<List<VNLoverRating>>(){};
		List<VNLoverRating> rating = mapper.readValue(new FileInputStream(ResourceUtils.getFile("classpath:vnlover_rating.json")),typeReference1);
		
		if (info.size() < 1 || rating.size() < 1) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		VnLoverHome vnLoverHome = new VnLoverHome(info.get(0), rating.get(0), post_timestamp);
		
		return new ResponseEntity<>(vnLoverHome, HttpStatus.OK);
	}

//	@GetMapping("/get-posts-timestamp")
//	public ResponseEntity<List<List<Long>>> getPostTimeStamp() throws IOException {
//		
//		List<List<Long>> ll = mapper.readValue(new FileInputStream(ResourceUtils.getFile("classpath:post_timestampv2.json")), new TypeReference<List<List<Long>>>(){});
//		
//		return new ResponseEntity<List<List<Long>>>(ll, HttpStatus.OK);
//	}
//	
//	@GetMapping("/get-vnlovers-info")
//	public ResponseEntity<VNLoverInfo> getVnLoverInfo() throws IOException {
//		TypeReference<List<VNLoverInfo>> typeReference = new TypeReference<List<VNLoverInfo>>(){};
//		List<VNLoverInfo> info = mapper.readValue(new FileInputStream(ResourceUtils.getFile("classpath:vnlover_info.json")),typeReference);
//
//		if (info.size() < 1) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		
//		return new ResponseEntity<VNLoverInfo>(info.get(0), HttpStatus.OK); 
//	}
//	
//	@GetMapping("/get-vnlovers-rating")
//	public ResponseEntity<VNLoverRating> getVnLoverRating() throws IOException {
//		TypeReference<List<VNLoverRating>> typeReference = new TypeReference<List<VNLoverRating>>(){};
//		List<VNLoverRating> rating = mapper.readValue(new FileInputStream(ResourceUtils.getFile("classpath:vnlover_rating.json")),typeReference);
//		
//		if (rating.size() < 1) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		
//		return new ResponseEntity<VNLoverRating>(rating.get(0), HttpStatus.OK);
//	}
	
}
