package com.stylistiq.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.stylistiq.exception.UserException;
import com.stylistiq.model.dto.request.UploadRequest;
import com.stylistiq.model.entity.Cloth;
import com.stylistiq.model.entity.User;
import com.stylistiq.model.entity.Wardrobe;
import com.stylistiq.model.response.ClothUploadResponse;
import com.stylistiq.model.response.ErrorResponse;
import com.stylistiq.repository.CategoryRepository;
import com.stylistiq.service.impl.ClothesServiceImpl;
import com.stylistiq.service.impl.CloudinaryServiceImpl;
import com.stylistiq.service.impl.UserServiceImplementation;

@RestController
@RequestMapping("/api/clothes")
public class ClothController {

	@Autowired
	UserServiceImplementation userService;
	@Autowired
	CloudinaryServiceImpl cloudinaryService;
	@Autowired
	ClothesServiceImpl clothesService;
	@Autowired
	CategoryRepository categoryRepo;

	@PostMapping("/upload")
	private ResponseEntity<ClothUploadResponse> uploadClothes(@RequestParam MultipartFile file,
			@RequestHeader("Authorization") String jwt)
			throws RuntimeException, IOException, ResponseStatusException, UserException {

		User user = userService.findUserProfileByJwt(jwt);
		if (user == null)
			throw new BadCredentialsException("Invalid User", null);

		if (file == null && file.isEmpty())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File is empty");

		if (!file.getContentType().startsWith("image/")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Only images allowed");
		}

		Map<String, Object> result = cloudinaryService.uplaod(file);

// 		1️⃣ clothes
//		2️⃣ clothes_images
//		3️⃣ image_attribute
//		4️⃣ e_wardrobe
		String categoryName = "jeans";
		String description = "Lorem ipsum h hjdghhdyhdy jd";
		String imageUrl = (String) result.get("url");

		if (imageUrl == null) {
			throw new RuntimeException("Failed to uplaod, Try again!...");
		}

		UploadRequest reqData = new UploadRequest(imageUrl, categoryName, description, null, user);
		Wardrobe wardrobe = (Wardrobe) clothesService.createCloth(reqData);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ClothUploadResponse(wardrobe, "Image uploaded successfully"));
	}

	@GetMapping("/{id}")
	private Cloth fetchClothById(@PathVariable Long id) {
		return new Cloth();
	}

	@GetMapping
	private ResponseEntity<Cloth> fetchClothByJwt(@RequestHeader("Authorization") String jwt) throws UserException {
		User user = userService.findUserProfileByJwt(jwt);
		if (user == null)
			return new ResponseEntity<Cloth>(new Cloth(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<Cloth>(new Cloth(), HttpStatus.OK);
	}

}
