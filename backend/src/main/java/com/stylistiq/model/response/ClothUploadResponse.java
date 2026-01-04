package com.stylistiq.model.response;

import com.stylistiq.model.entity.Wardrobe;

public class ClothUploadResponse {
	Wardrobe wardrobe;
	String message;

	public ClothUploadResponse(Wardrobe wardrobe, String message) {
		super();
		this.wardrobe = wardrobe;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Wardrobe getWardrobe() {
		return wardrobe;
	}

	public void setWardrobe(Wardrobe wardrobe) {
		this.wardrobe = wardrobe;
	}

}
