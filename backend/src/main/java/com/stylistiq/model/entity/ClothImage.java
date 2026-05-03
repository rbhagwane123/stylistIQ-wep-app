package com.stylistiq.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cloth_images")
public class ClothImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long imageId;

	private String imageUrl;

	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cloth_id", nullable = false)
	@JsonIgnore
	private Cloth cloth;

	@OneToMany(mappedBy = "clothImage", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<ImageAttribute> imgAttribute = new ArrayList<>();

	public ClothImage() {
	}

	public ClothImage(Long imageId, String imageUrl, LocalDateTime createdAt, Cloth cloth,
			List<ImageAttribute> imgAttribute) {
		super();
		this.imageId = imageId;
		this.imageUrl = imageUrl;
		this.createdAt = createdAt;
		this.cloth = cloth;
		this.imgAttribute = imgAttribute;
	}

	public List<ImageAttribute> getImgAttribute() {
		return imgAttribute;
	}

	public void setImgAttribute(List<ImageAttribute> imgAttribute) {
		this.imgAttribute = imgAttribute;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Cloth getCloth() {
		return cloth;
	}

	public void setCloth(Cloth cloth) {
		this.cloth = cloth;
	}

}
