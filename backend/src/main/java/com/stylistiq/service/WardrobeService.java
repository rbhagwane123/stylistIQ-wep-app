package com.stylistiq.service;

import java.util.List;

import com.stylistiq.model.entity.Wardrobe;
import com.stylistiq.model.response.WardrobeResponse;

import jakarta.transaction.Transactional;

public interface WardrobeService {

	public Wardrobe createWardrobe(Wardrobe wardrobe);

	
	public List<WardrobeResponse> getUserWardrobe(Long user_id);

}
