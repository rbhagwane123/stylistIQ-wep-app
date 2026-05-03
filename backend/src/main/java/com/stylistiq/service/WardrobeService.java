package com.stylistiq.service;

import java.util.List;

import com.stylistiq.model.entity.Wardrobe;
import com.stylistiq.model.response.WardrobeResponse;
import com.stylistiq.model.response.WardrobeResponseDTO;

public interface WardrobeService {

	public Wardrobe createWardrobe(Wardrobe wardrobe);

	public List<WardrobeResponseDTO> getUserWardrobeByUserId(Long userId);

	public int getWardrobeCountByUserId(Long userId);


}
