package org.rangiffler.controller;

import org.rangiffler.model.PhotoJson;
import org.rangiffler.service.GrpcPhotoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PhotoController {

    private static final Logger LOG = LoggerFactory.getLogger(CountryController.class);
    private final GrpcPhotoClient photoService;

    @Autowired
    public PhotoController(GrpcPhotoClient photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/photos")
    public List<PhotoJson> getPhotosForUser(@AuthenticationPrincipal Jwt principal) {
        String username = principal.getClaim("sub");
        return photoService.getPhotosForUser(username);
    }

    @GetMapping("/friends/photos")
    public List<PhotoJson> getAllFriendsPhotos(@AuthenticationPrincipal Jwt principal) {
        String username = principal.getClaim("sub");
        return photoService.getAllFriendsPhotos(username);
    }

    @PostMapping("/photos")
    public PhotoJson addPhoto(@AuthenticationPrincipal Jwt principal,
                              @RequestBody PhotoJson photoJson) {
        String username = principal.getClaim("sub");
        photoJson.setUsername(username);
        return photoService.addPhoto(photoJson);
    }

    @PatchMapping("/photos/{id}")
    public PhotoJson editPhoto(@AuthenticationPrincipal Jwt principal,
                               @RequestBody PhotoJson photoJson) {
        String username = principal.getClaim("sub");
        photoJson.setUsername(username);
        return photoService.editPhoto(photoJson);
    }

    @DeleteMapping("/photos")
    public void deletePhoto(@AuthenticationPrincipal Jwt principal,
                            @RequestParam UUID photoId) {
        photoService.deletePhoto(photoId);
    }

}
