package com.stylistiq.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryid;

	private String categoryName;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_category_id")
	private Category parentCategory;

	@OneToMany
	List<Cloth> cloth = new ArrayList<>();

	@OneToMany(mappedBy = "parentCategory")
	private List<Category> subCategories = new ArrayList<>();

	public Category() {
	}

	public Category(Long categoryid, String categoryName, LocalDateTime createdAt, Category parentCategory,
			List<Cloth> cloth, List<Category> subCategories) {
		super();
		this.categoryid = categoryid;
		this.categoryName = categoryName;
		this.createdAt = createdAt;
		this.parentCategory = parentCategory;
		this.cloth = cloth;
		this.subCategories = subCategories;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<Cloth> getCloth() {
		return cloth;
	}

	public void setCloth(List<Cloth> cloth) {
		this.cloth = cloth;
	}

	public List<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}

}
