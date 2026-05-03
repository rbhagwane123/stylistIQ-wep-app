package com.stylistiq.model.response;

public class ImageAttributeResponse {

	private String primaryColor;
	private String secondaryColor;
	private String fabricType;
	private Long confidenceScore;
	private String detectedBy;

	public ImageAttributeResponse(String primaryColor, String secondaryColor, String fabricType, Long confidenceScore,
			String detectedBy) {
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.fabricType = fabricType;
		this.confidenceScore = confidenceScore;
		this.detectedBy = detectedBy;
	}

	public String getPrimaryColor() {
		return primaryColor;
	}

	public void setPrimaryColor(String primaryColor) {
		this.primaryColor = primaryColor;
	}

	public String getSecondaryColor() {
		return secondaryColor;
	}

	public void setSecondaryColor(String secondaryColor) {
		this.secondaryColor = secondaryColor;
	}

	public String getFabricType() {
		return fabricType;
	}

	public void setFabricType(String fabricType) {
		this.fabricType = fabricType;
	}

	public Long getConfidenceScore() {
		return confidenceScore;
	}

	public void setConfidenceScore(Long confidenceScore) {
		this.confidenceScore = confidenceScore;
	}

	public String getDetectedBy() {
		return detectedBy;
	}

	public void setDetectedBy(String detectedBy) {
		this.detectedBy = detectedBy;
	}

	// getters

}
