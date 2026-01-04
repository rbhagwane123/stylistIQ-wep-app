package com.stylistiq.service.impl;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import com.stylistiq.model.dto.request.UploadRequest;
import com.stylistiq.model.entity.Category;
import com.stylistiq.model.entity.Cloth;
import com.stylistiq.model.entity.ClothImage;
import com.stylistiq.model.entity.ImageAttribute;
import com.stylistiq.model.entity.Wardrobe;
import com.stylistiq.repository.CategoryRepository;
import com.stylistiq.repository.ClothesRepository;
import com.stylistiq.service.ClothesService;

import jakarta.transaction.Transactional;
import jdk.jshell.spi.ExecutionControl.UserException;

@Service

public class ClothesServiceImpl implements ClothesService {

	private final CategoryRepository categoryRepo;
	private final ClothesRepository clothesRepo;
	private final ClothImageServiceImpl clothImageService;
	private final ImageAttributeServiceImpl imageAttributeService;

	private final WardrobeServiceImpl wardrobeService;

	public ClothesServiceImpl(CategoryRepository categoryRepo, ClothesRepository clothesRepo,
			ClothImageServiceImpl clothImageService, ImageAttributeServiceImpl imageAttributeService,
			WardrobeServiceImpl wardrobeService) {
		super();
		this.categoryRepo = categoryRepo;
		this.clothesRepo = clothesRepo;
		this.clothImageService = clothImageService;
		this.imageAttributeService = imageAttributeService;

		this.wardrobeService = wardrobeService;
	}

	@Override
	@Transactional
	public Object createCloth(UploadRequest req) throws BadRequestException {
		Category category = categoryRepo.findByCategoryNameIgnoreCase(req.getClothCategoryName());

		if (category == null)
			throw new BadRequestException("Invalid cloth category");

		// 1️⃣ Cloth
		Cloth cloth = new Cloth();
		cloth.setCategory(category);
		cloth.setDescription(req.getDescription());
		cloth = clothesRepo.save(cloth);

		// 1️⃣ Cloth Image
		ClothImage clothImage = new ClothImage();
		clothImage.setImageUrl(req.getImageUrl());
		clothImage.setCloth(cloth);
		clothImage = clothImageService.createClothImage(clothImage);

		// 1️⃣ Image Attribute
		ImageAttribute atribute = new ImageAttribute();
		atribute.setConfidenceScor((long) 98.2363);
		atribute.setDetectedBy("AI");
		atribute.setClothImage(clothImage);
		atribute.setFabricType("denim cotton");
		atribute = imageAttributeService.createImageAttribute(atribute);

		// 1️⃣ Wardrobe
		Wardrobe wardrobe = new Wardrobe();
		wardrobe.setCloth(cloth);
		wardrobe.setUser(req.getUser());
		wardrobe = wardrobeService.createWardrobe(wardrobe);

		return wardrobe;
	}

}
