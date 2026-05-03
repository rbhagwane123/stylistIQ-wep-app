package com.stylistiq.controller;

import java.util.List;
import java.util.Optional;

import com.stylistiq.model.response.WardrobeResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.stylistiq.exception.UserException;
import com.stylistiq.model.entity.User;
import com.stylistiq.model.entity.Wardrobe;
import com.stylistiq.model.response.WardrobeResponse;
import com.stylistiq.repository.WardrobeRepository;
import com.stylistiq.service.impl.UserServiceImplementation;
import com.stylistiq.service.impl.WardrobeServiceImpl;

@RestController
@RequestMapping("/api/wardrobe")
public class WardrobeController {

    private final WardrobeServiceImpl wardrobeService;
    private final UserServiceImplementation userService;
    private final WardrobeRepository wardrobeRepo;
    private final WardrobeServiceImpl wardrobeServiceImpl;

    public WardrobeController(WardrobeServiceImpl wardrobeService, UserServiceImplementation userService, WardrobeRepository wardrobeRepo, WardrobeServiceImpl wardrobeServiceImpl) {
        super();
        this.wardrobeService = wardrobeService;
        this.userService = userService;
        this.wardrobeRepo = wardrobeRepo;
        this.wardrobeServiceImpl = wardrobeServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<WardrobeResponseDTO>> getUserWardrobe(@RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        if (user == null) throw new BadCredentialsException("Invalid Username or Password");
        return new ResponseEntity<List<WardrobeResponseDTO>>(wardrobeService.getUserWardrobeByUserId(user.getUserId()), HttpStatus.OK);
    }

    @GetMapping("/{wardrobeId}")
    public ResponseEntity<Wardrobe> getWardrobeById(@PathVariable Long wardrobeId, @RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        if (user == null) throw new BadCredentialsException("Invalid Username or Password");
        Optional<Wardrobe> wardrobe = wardrobeRepo.findById(wardrobeId);
        return new ResponseEntity<Wardrobe>(wardrobe.get(), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getWardrobeCount(@RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        if (user == null) throw new BadCredentialsException("Invalid Username or Password");
        return new ResponseEntity<>(wardrobeServiceImpl.getWardrobeCountByUserId(user.getUserId()), HttpStatus.OK);
    }

}
