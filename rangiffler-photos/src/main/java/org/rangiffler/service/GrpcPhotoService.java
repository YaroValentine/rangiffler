package org.rangiffler.service;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.grpc.rangiffler.grpc.*;
import org.rangiffler.data.PhotoEntity;
import org.rangiffler.data.model.UserJson;
import org.rangiffler.data.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

@GrpcService
public class GrpcPhotoService extends RangifflerPhotoServiceGrpc.RangifflerPhotoServiceImplBase {
    private final PhotoRepository photoRepository;
    private final GrpcCountriesClient grpcCountriesClient;
    private final RestUserdataClient restUserdataClient;

    @Autowired
    public GrpcPhotoService(PhotoRepository photoRepository,
                            GrpcCountriesClient grpcCountriesClient,
                            RestUserdataClient restUserdataClient) {
        this.photoRepository = photoRepository;
        this.grpcCountriesClient = grpcCountriesClient;
        this.restUserdataClient = restUserdataClient;
    }

    private Country getCountryInfoByCode(String code) {
        CountryByCodeRequest request = CountryByCodeRequest.newBuilder()
                .setCode(code)
                .build();
        return grpcCountriesClient.getCountryByCode(request);
    }

    private Photo convertToPhoto(PhotoEntity photoEntity) {
        return Photo.newBuilder()
                .setId(photoEntity.getId().toString())
                .setPhoto(new String(photoEntity.getPhoto(), StandardCharsets.UTF_8))
                .setCountry(getCountryInfoByCode(photoEntity.getCountryCode()))
                .setDescription(photoEntity.getDescription())
                .setUsername(photoEntity.getUsername())
                .build();
    }

    @Override
    public void addPhoto(Photo request, StreamObserver<Photo> responseObserver) {
        PhotoEntity newPhoto = new PhotoEntity();
        newPhoto.setPhoto(request.getPhoto().getBytes(StandardCharsets.UTF_8));
        newPhoto.setCountryCode(request.getCountry().getCountryCode());
        newPhoto.setUsername(request.getUsername());
        newPhoto.setDescription(request.getDescription());
        photoRepository.save(newPhoto);

        Photo response = convertToPhoto(newPhoto);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deletePhoto(PhotoIdRequest request, StreamObserver<Empty> responseObserver) {
        PhotoEntity photo = photoRepository.findById(UUID.fromString(request.getId())).orElseThrow();
        photoRepository.delete(photo);
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void editPhoto(Photo request, StreamObserver<Photo> responseObserver) {
        PhotoEntity existingPhoto = photoRepository.findById(UUID.fromString(request.getId()))
                .orElseThrow(() -> new RuntimeException("Photo not found with id: " + request.getId()));

        existingPhoto.setDescription(request.getDescription());
        existingPhoto.setPhoto(request.getPhoto().getBytes(StandardCharsets.UTF_8));
        existingPhoto.setCountryCode(request.getCountry().getCountryCode());
        photoRepository.save(existingPhoto);

        Photo response = convertToPhoto(existingPhoto);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getPhotosForUser(UsernameRequest request, StreamObserver<Photos> responseObserver) {
        List<PhotoEntity> allPhotosByUsername = photoRepository.findAllPhotosByUsername(request.getUsername());
        Photos photos = Photos.newBuilder()
                .addAllPhotos(allPhotosByUsername.stream().map(this::convertToPhoto).toList())
                .build();
        responseObserver.onNext(photos);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllFriendsPhotos(UsernameRequest request, StreamObserver<Photos> responseObserver) {
        List<UserJson> allFriends = restUserdataClient.friends(request.getUsername());
        List<String> friendsNames = allFriends.stream().map(UserJson::getUsername).toList();
        List<PhotoEntity> friendsPhotosEntity = photoRepository.findAllByUsernameIn(friendsNames);
        Photos photos = Photos.newBuilder()
                .addAllPhotos(friendsPhotosEntity.stream().map(this::convertToPhoto).toList())
                .build();
        responseObserver.onNext(photos);
        responseObserver.onCompleted();
    }
}
