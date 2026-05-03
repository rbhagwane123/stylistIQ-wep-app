package com.stylistiq.mapper;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.stylistiq.model.response.*;

import com.stylistiq.model.entity.*;

@Component
public class WardrobeMapper {

	public List<WardrobeResponse> map(List<Wardrobe> wardrobes, List<ClothImage> images,
			List<ImageAttribute> attributes) {

		// Group attributes by imageId
		System.out.println("Attributed data : " + attributes.get(0).getPrimaryColor() + attributes);
		Map<Long, List<ImageAttributeResponse>> attributeMap = attributes.stream()
				.collect(Collectors.groupingBy(a -> a.getClothImage().getImageId(),
						Collectors.mapping(
								a -> new ImageAttributeResponse(a.getPrimaryColor(), a.getSecondaryColor(),
										a.getFabricType(), a.getConfidenceScor(), a.getDetectedBy()),
								Collectors.toList())));

		// Group images by clothId
		Map<Long, List<ImageResponse>> imageMap = images.stream()
				.collect(
						Collectors
								.groupingBy(
										img -> img.getCloth()
												.getClothId(),
										Collectors.mapping(
												img -> new ImageResponse(img.getImageId(), img.getImageUrl(),
														attributeMap.getOrDefault(img.getImageId(), List.of())),
												Collectors.toList())));

		// Build final response
		return wardrobes.stream()
				.map(w -> new WardrobeResponse(w.getWardrobeId(), w.getCloth().getCategory().getCategoryName(),
						w.getCloth().getDescription(), w.getCreatedAt(),
						imageMap.getOrDefault(w.getCloth().getClothId(), List.of())))
				.toList();
	}
}
