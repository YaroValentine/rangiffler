package org.rangiffler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grpc.rangiffler.grpc.Photo;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotoJson {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("country")
    private CountryJson countryJson;

    @JsonProperty("photo")
    private String photo;

    @JsonProperty("description")
    private String description;

    @JsonProperty("username")
    private String username;

    public static PhotoJson fromGrpcMessage(Photo photo) {
        return PhotoJson.builder()
                .id(/*!photo.getId().isEmpty() ? */UUID.fromString(photo.getId())/* : null*/) //todo check :?
                .photo(photo.getPhoto())
                .countryJson(CountryJson.fromGrpcMessage(photo.getCountry()))
                .description(photo.getDescription())
                .username(photo.getUsername())
                .build();
    }

    public Photo toGrpcMessage() {
        return Photo.newBuilder()
                .setId(/*id != null ? */id.toString()/* : ""*/) //todo check :?
                .setUsername(username)
                .setDescription(description)
                .setPhoto(photo)
                .setCountry(countryJson.toGrpcMessage())
                .build();
    }
}
