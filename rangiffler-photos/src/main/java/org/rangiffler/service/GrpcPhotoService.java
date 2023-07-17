package org.rangiffler.service;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.grpc.rangiffler.grpc.*;
import org.rangiffler.data.PhotoEntity;
import org.rangiffler.data.model.UserJson;
import org.rangiffler.data.repository.PhotoRepository;
import org.rangiffler.service.api.GrpcCountriesClient;
import org.rangiffler.service.api.RestUserdataClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

@GrpcService
public class GrpcPhotoService extends RangifflerPhotoServiceGrpc.RangifflerPhotoServiceImplBase {
    private static final Logger LOG = LoggerFactory.getLogger(GrpcPhotoService.class);
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

    @Override
    public void addPhoto(Photo request, StreamObserver<Photo> responseObserver) {
        Country countryInfo = getCountryInfoByCode(request.getCountry().getCountryCode());
        PhotoEntity newPhoto = new PhotoEntity();
        newPhoto.setPhoto(request.getPhoto().getBytes(StandardCharsets.UTF_8));
        newPhoto.setCountryCode(request.getCountry().getCountryCode());
        newPhoto.setUsername(request.getUsername());
        newPhoto.setDescription(request.getDescription());
        photoRepository.save(newPhoto);
        Photo response = Photo.newBuilder().setPhoto(new String(newPhoto.getPhoto(), StandardCharsets.UTF_8))
                .setCountry(countryInfo)
                .setUsername(newPhoto.getUsername())
                .setDescription(newPhoto.getDescription())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deletePhoto(PhotoIdRequest request, StreamObserver<Empty> responseObserver) {
        PhotoEntity photoById = photoRepository.findById(UUID.fromString(request.getId())).orElseThrow();
        photoRepository.delete(photoById);
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void editPhoto(Photo request, StreamObserver<Photo> responseObserver) {
        Country countryInfo = getCountryInfoByCode(request.getCountry().getCountryCode());
        PhotoEntity editPhoto = new PhotoEntity();
        editPhoto.setPhoto(request.getPhoto().getBytes(StandardCharsets.UTF_8));
        editPhoto.setCountryCode(request.getCountry().getCountryCode());
        editPhoto.setUsername(request.getUsername());
        editPhoto.setDescription(request.getDescription());
        photoRepository.save(editPhoto);
        Photo response = Photo.newBuilder().setPhoto(new String(editPhoto.getPhoto(), StandardCharsets.UTF_8))
                .setCountry(countryInfo)
                .setUsername(editPhoto.getUsername())
                .setDescription(editPhoto.getDescription())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getPhotosForUser(UsernameRequest request, StreamObserver<Photos> responseObserver) {
        List<PhotoEntity> allPhotosByUsername = photoRepository.findAllPhotosByUsername(request.getUsername());
        Photos.Builder builderAllPhoto = Photos.newBuilder();
        if (allPhotosByUsername.size() > 0) {
            for (PhotoEntity photoEntity : allPhotosByUsername) {
                Photo.Builder photoBuilder = Photo.newBuilder()
                        .setId(photoEntity.getId().toString())
                        .setPhoto(new String(photoEntity.getPhoto(), StandardCharsets.UTF_8))
                        .setCountry(getCountryInfoByCode(photoEntity.getCountryCode()))
                        .setDescription(photoEntity.getDescription())
                        .setUsername(photoEntity.getUsername());
                builderAllPhoto.addPhotos(photoBuilder.build());
            }
        }
        Photos photos = builderAllPhoto.build();
        responseObserver.onNext(photos);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllFriendsPhotos(UsernameRequest request, StreamObserver<Photos> responseObserver) {
        UsernameRequest requestUsername = UsernameRequest.newBuilder().setUsername(request.getUsername()).build();
        List<UserJson> allFriends = restUserdataClient.friends(requestUsername.getUsername());
        List<String> friendsNames = allFriends.stream().map(u -> u.getUsername()).toList();
        List<PhotoEntity> friendsPhotosEntity = photoRepository.findAllByUsernameIn(friendsNames);
        Photos.Builder builderAllPhoto = Photos.newBuilder();
        if (friendsPhotosEntity.size() > 0) {
            for (PhotoEntity photoEntity : friendsPhotosEntity) {
                Photo.Builder photoBuilder = Photo.newBuilder()
                        .setId(photoEntity.getId().toString())
                        .setPhoto(new String(photoEntity.getPhoto(), StandardCharsets.UTF_8))
                        .setCountry(getCountryInfoByCode(photoEntity.getCountryCode()))
                        .setDescription(photoEntity.getDescription())
                        .setUsername(photoEntity.getUsername());
                builderAllPhoto.addPhotos(photoBuilder.build());
            }
        }
        Photos photos = builderAllPhoto.build();
        responseObserver.onNext(photos);
        responseObserver.onCompleted();
    }

    private Country getCountryInfoByCode(String code) {
        CountryByCodeRequest request = CountryByCodeRequest.newBuilder()
                .setCode(code)
                .build();
        return grpcCountriesClient.getCountryByCode(request);
    }
}
