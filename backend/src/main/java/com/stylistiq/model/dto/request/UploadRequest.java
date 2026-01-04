package com.stylistiq.model.dto.request;

import com.stylistiq.model.entity.User;

public class UploadRequest {

	private String imageUrl;
	private String clothCategoryName;
	private String description;
	private Long categoryId;
	private User user;

	public UploadRequest(String imageUrl, String clothCategoryName, String description, Long categoryId, User user) {
		super();
		this.imageUrl = imageUrl;
		this.clothCategoryName = clothCategoryName;
		this.description = description;
		this.categoryId = categoryId;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getClothCategoryName() {
		return clothCategoryName;
	}

	public void setClothCategoryName(String clothCategoryName) {
		this.clothCategoryName = clothCategoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
