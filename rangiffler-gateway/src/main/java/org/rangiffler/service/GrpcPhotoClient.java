package org.rangiffler.service;


import net.devh.boot.grpc.client.inject.GrpcClient;
import org.grpc.rangiffler.grpc.*;
import org.rangiffler.model.PhotoJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.rangiffler.model.PhotoJson.fromGrpcMessage;

@Service
@RestController
public class GrpcPhotoClient {

    @GrpcClient("grpcPhotoClient")
    private RangifflerPhotoServiceGrpc.RangifflerPhotoServiceBlockingStub photoStub;

    public List<PhotoJson> getPhotosForUser(String username) {
        Photos photosForUser = photoStub.getPhotosForUser(UsernameRequest.newBuilder()
                .setUsername(username)
                .build());
        return photosForUser.getPhotosList().stream()
                .map(PhotoJson::fromGrpcMessage).toList();
    }

    public List<PhotoJson> getAllFriendsPhotos(String username) {
        Photos friendsPhoto = photoStub.getAllFriendsPhotos(UsernameRequest.newBuilder()
                .setUsername(username)
                .build());
        return friendsPhoto.getPhotosList().stream()
                .map(PhotoJson::fromGrpcMessage).toList();
    }

    public PhotoJson addPhoto(PhotoJson photoJson) {
        Photo photo = photoStub.addPhoto(photoJson.toGrpcMessage());
        return fromGrpcMessage(photo);
    }

    public PhotoJson editPhoto(PhotoJson photoJson) {
        Photo photo = photoStub.editPhoto(photoJson.toGrpcMessage());
        return fromGrpcMessage(photo);
    }

    public void deletePhoto(UUID photoId) {
        photoStub.deletePhoto(PhotoIdRequest.newBuilder()
                .setId(photoId.toString())
                .build());
    }

}
