package org.rangiffler.data.model;

import org.rangiffler.data.PhotoEntity;

import java.util.UUID;

public class Photo {

    private UUID id;
    private String username;
    private String countryCode;
    private String description;
    private byte[] photo;

    public Photo fromEntity(PhotoEntity entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.countryCode = entity.getCountryCode();
        this.description = entity.getDescription();
        this.photo = entity.getPhoto();
        return this;
    }
}
