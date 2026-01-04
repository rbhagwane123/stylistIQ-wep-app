package com.stylistiq.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "image_attribute")
public class ImageAttribute {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attributeId;

	private String fabricType;
	private Long confidenceScor;
	private String detectedBy;

	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@ManyToOne
	@JoinColumn(name = "image_id")
	private ClothImage clothImage;

	public ImageAttribute() {
	}

	public ImageAttribute(Long attributeId, String fabricType, Long confidenceScor, String detectedBy,
			LocalDateTime createdAt, ClothImage clothImage) {
		super();
		this.attributeId = attributeId;
		this.fabricType = fabricType;
		this.confidenceScor = confidenceScor;
		this.detectedBy = detectedBy;
		this.createdAt = createdAt;
		this.clothImage = clothImage;
	}

	public Long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	}

	public String getFabricType() {
		return fabricType;
	}

	public void setFabricType(String fabricType) {
		this.fabricType = fabricType;
	}

	public Long getConfidenceScor() {
		return confidenceScor;
	}

	public void setConfidenceScor(Long confidenceScor) {
		this.confidenceScor = confidenceScor;
	}

	public String getDetectedBy() {
		return detectedBy;
	}

	public void setDetectedBy(String detectedBy) {
		this.detectedBy = detectedBy;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public ClothImage getClothImage() {
		return clothImage;
	}

	public void setClothImage(ClothImage clothImage) {
		this.clothImage = clothImage;
	}

}
