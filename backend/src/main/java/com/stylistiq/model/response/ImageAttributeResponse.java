package com.stylistiq.model.response;

public class ImageAttributeResponse {

	private String fabricType;
	private Long confidenceScore;
	private String detectedBy;

	public ImageAttributeResponse(String fabricType, Long confidenceScore, String detectedBy) {
		this.fabricType = fabricType;
		this.confidenceScore = confidenceScore;
		this.detectedBy = detectedBy;
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
