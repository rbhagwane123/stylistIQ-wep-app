package com.stylistiq.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "wardrobe")
public class Wardrobe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wardrobeId;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cloth_id")
	private Cloth cloth;

	public Wardrobe() {
	}

	public Wardrobe(Long wardrobeId, LocalDateTime createdAt, LocalDateTime updatedAt, User user, Cloth cloth) {
		super();
		this.wardrobeId = wardrobeId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		this.cloth = cloth;
	}

	public Long getWardrobeId() {
		return wardrobeId;
	}

	public void setWardrobeId(Long wardrobeId) {
		this.wardrobeId = wardrobeId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cloth getCloth() {
		return cloth;
	}

	public void setCloth(Cloth cloth) {
		this.cloth = cloth;
	}

	
}
