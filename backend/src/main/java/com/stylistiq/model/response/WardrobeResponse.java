package com.stylistiq.model.response;

import java.util.List;

import java.time.LocalDateTime;
import java.util.List;

public class WardrobeResponse {

	private Long wardrobeId;
	private String category;
	private String description;
	private LocalDateTime createdAt;
	private List<ImageResponse> images;

	public WardrobeResponse(Long wardrobeId, String category, String description, LocalDateTime createdAt,
			List<ImageResponse> images) {
		this.wardrobeId = wardrobeId;
		this.category = category;
		this.description = description;
		this.createdAt = createdAt;
		this.images = images;
	}

	public Long getWardrobeId() {
		return wardrobeId;
	}

	public void setWardrobeId(Long wardrobeId) {
		this.wardrobeId = wardrobeId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<ImageResponse> getImages() {
		return images;
	}

	public void setImages(List<ImageResponse> images) {
		this.images = images;
	}

	// getters

}
