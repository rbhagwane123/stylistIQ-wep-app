package com.stylistiq.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryImageService {
	
	public Map uplaod(MultipartFile file);
	
}
