package com.stylistiq.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "clothes")
public class Cloth {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clothId;

	private String description;

	private String clothType;

	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category category;

	@OneToMany(mappedBy = "cloth", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Wardrobe> wardrobe = new ArrayList<>();

	@OneToMany(mappedBy = "cloth", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<ClothImage> clothImg = new ArrayList<>();

	public Cloth() {
	}

	public Cloth(Long clothId, String description, String clothType, LocalDateTime createdAt, LocalDateTime updatedAt,
			Category category, List<Wardrobe> wardrobe, List<ClothImage> clothImg) {
		super();
		this.clothId = clothId;
		this.description = description;
		this.clothType = clothType;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.category = category;
		this.wardrobe = wardrobe;
		this.clothImg = clothImg;
	}

	public String getClothType() {
		return clothType;
	}

	public void setClothType(String clothType) {
		this.clothType = clothType;
	}

	public List<Wardrobe> getWardrobe() {
		return wardrobe;
	}

	public void setWardrobe(List<Wardrobe> wardrobe) {
		this.wardrobe = wardrobe;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getClothId() {
		return clothId;
	}

	public void setClothId(Long clothId) {
		this.clothId = clothId;
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

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<ClothImage> getClothImg() {
		return clothImg;
	}

	public void setClothImg(List<ClothImage> clothImg) {
		this.clothImg = clothImg;
	}

}
