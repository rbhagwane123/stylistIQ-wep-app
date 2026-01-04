package com.stylistiq.service.impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.stylistiq.service.CloudinaryImageService;

@Service
public class CloudinaryServiceImpl implements CloudinaryImageService {

	@Autowired
	private Cloudinary cloudinary;

	@Value("${cloudinary.folderPath}")
	private String folderPath;

	@Override
	public Map uplaod(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			Map data = this.cloudinary.uploader().upload(file.getBytes(),
					ObjectUtils.asMap("folder", folderPath, "resource_type", "image"));
			return data;
		} catch (RuntimeException ex) {
			System.out.println("Image failed to uplaod!...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
