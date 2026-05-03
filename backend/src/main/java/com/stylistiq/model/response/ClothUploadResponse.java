package com.stylistiq.model.response;

public class ClothUploadResponse {
	Long wardrobeId;
	Long userId;
	Long clothId;

	String message;
	String categoryName;

	public ClothUploadResponse(Long wardrobeId, Long userId, Long clothId, String message, String categoryName) {
		super();
		this.wardrobeId = wardrobeId;
		this.userId = userId;
		this.clothId = clothId;
		this.message = message;
		this.categoryName = categoryName;
	}

	public Long getWardrobeId() {
		return wardrobeId;
	}

	public void setWardrobeId(Long wardrobeId) {
		this.wardrobeId = wardrobeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getClothId() {
		return clothId;
	}

	public void setClothId(Long clothId) {
		this.clothId = clothId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
