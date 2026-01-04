package com.stylistiq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylistiq.model.entity.ImageAttribute;
import com.stylistiq.repository.ImageAttributeRepository;
import com.stylistiq.service.ImageAttributeService;

@Service
public class ImageAttributeServiceImpl implements ImageAttributeService {

	@Autowired
	ImageAttributeRepository imageAttributeRepo;

	@Override
	public ImageAttribute createImageAttribute(ImageAttribute imageAttribute) {
		// TODO Auto-generated method stub
		return imageAttributeRepo.save(imageAttribute);
	}

	@Override
	public List<ImageAttribute> findAttributesByImageIds(List<Long> imageIds) {
		// TODO Auto-generated method stub
		return imageAttributeRepo.findAttributesByImageIds(imageIds);
	}

}
