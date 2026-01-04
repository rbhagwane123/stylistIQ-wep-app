package com.stylistiq.model.response;

import java.util.List;

public class ImageResponse {

    private Long imageId;
    private String imageUrl;
    private List<ImageAttributeResponse> attributes;

    public ImageResponse(Long imageId, String imageUrl, List<ImageAttributeResponse> attributes) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        this.attributes = attributes;
    }

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<ImageAttributeResponse> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ImageAttributeResponse> attributes) {
		this.attributes = attributes;
	}

	

    
}
