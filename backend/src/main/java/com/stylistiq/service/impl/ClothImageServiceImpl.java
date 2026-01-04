package com.stylistiq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylistiq.model.entity.ClothImage;
import com.stylistiq.repository.ClothImageRepository;
import com.stylistiq.service.ClothImageService;

@Service
public class ClothImageServiceImpl implements ClothImageService {

	@Autowired
	ClothImageRepository clothImageRepo;

	@Override
	public ClothImage createClothImage(ClothImage clothImage) {
		// TODO Auto-generated method stub
		return clothImageRepo.save(clothImage);

	}

	@Override
	public List<ClothImage> findImagesByClothIds(List<Long> clothIds) {
		// TODO Auto-generated method stub
		return clothImageRepo.findImagesByClothIds(clothIds);
	}

}
