package com.stylistiq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.stylistiq.mapper.WardrobeMapper;
import com.stylistiq.model.entity.ClothImage;
import com.stylistiq.model.entity.ImageAttribute;
import com.stylistiq.model.entity.Wardrobe;
import com.stylistiq.model.response.WardrobeResponse;
import com.stylistiq.repository.WardrobeRepository;
import com.stylistiq.service.UserService;
import com.stylistiq.service.WardrobeService;

import jakarta.transaction.Transactional;

@Service
public class WardrobeServiceImpl implements WardrobeService {

	@Autowired
	WardrobeRepository wardrobeRepo;
	@Autowired
	UserService userService;
	@Autowired
	ImageAttributeServiceImpl attributeService;
	@Autowired
	ClothImageServiceImpl clothImageService;
	@Autowired
	WardrobeMapper wardrobeMapper;

	@Override
	public Wardrobe createWardrobe(Wardrobe wardrobe) {
		return wardrobeRepo.save(wardrobe);
	}

	@Override
	@Transactional
	public List<WardrobeResponse> getUserWardrobe(Long user_id) {

//		List<Wardrobe> wardrobeList = wardrobeRepo.findFullWardrobeByUserId(user_id);

		List<Wardrobe> wardrobes = wardrobeRepo.findWardrobeWithCloth(user_id);

		List<Long> clothIds = wardrobes.stream().map(w -> w.getCloth().getClothId()).toList();

		List<ClothImage> images = clothImageService.findImagesByClothIds(clothIds);

		List<Long> imageIds = images.stream().map(ClothImage::getImageId).toList();

		List<ImageAttribute> attributes = attributeService.findAttributesByImageIds(imageIds);

		return wardrobeMapper.map(wardrobes, images, attributes);
	}

}
