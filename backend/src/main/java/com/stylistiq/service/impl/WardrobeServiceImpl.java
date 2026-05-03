package com.stylistiq.service.impl;

import java.util.List;

import com.stylistiq.model.response.WardrobeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.stylistiq.exception.UserException;
import com.stylistiq.mapper.WardrobeMapper;
import com.stylistiq.model.entity.ClothImage;
import com.stylistiq.model.entity.ImageAttribute;
import com.stylistiq.model.entity.Wardrobe;
import com.stylistiq.model.response.WardrobeResponse;
import com.stylistiq.repository.WardrobeRepository;
import com.stylistiq.service.UserService;
import com.stylistiq.service.WardrobeService;

import jakarta.transaction.Transactional;

@Service
public class WardrobeServiceImpl implements WardrobeService {

    @Autowired
    WardrobeRepository wardrobeRepo;
    @Autowired
    UserService userService;
    @Autowired
    ImageAttributeServiceImpl attributeService;
    @Autowired
    ClothImageServiceImpl clothImageService;
    @Autowired
    WardrobeMapper wardrobeMapper;

    @Override
    public Wardrobe createWardrobe(Wardrobe wardrobe) {
        return wardrobeRepo.save(wardrobe);
    }

    @Override
    @Transactional
    public List<WardrobeResponseDTO> getUserWardrobeByUserId(Long user_id) {
        return wardrobeRepo.findByUserId(user_id);
    }

    @Override
    public int getWardrobeCountByUserId(Long userId) {
        return wardrobeRepo.findWardrobeCount(userId);
    }


}
