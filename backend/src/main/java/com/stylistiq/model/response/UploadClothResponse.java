package com.stylistiq.model.response;

import java.time.LocalDateTime;
import java.util.List;

public class UploadClothResponse {

    private Long wardrobeId;
    private String category;
    private String description;
    private LocalDateTime createdAt;
    private String imageUrl;
    private String primaryColor;
    private String secondaryColor;
    private String fabricType;

    public UploadClothResponse() {
    }

    public UploadClothResponse(Long wardrobeId, String category, String description, LocalDateTime createdAt, String imageUrl, String primaryColor, String secondaryColor, String fabricType) {
        this.wardrobeId = wardrobeId;
        this.category = category;
        this.description = description;
        this.createdAt = createdAt;
        this.imageUrl = imageUrl;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.fabricType = fabricType;
    }


    public Long getWardrobeId() {
        return wardrobeId;
    }

    public void setWardrobeId(Long wardrobeId) {
        this.wardrobeId = wardrobeId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
}
