package org.rangiffler.model;

import lombok.*;
import org.grpc.rangiffler.grpc.Photo;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PhotoJson {

    private UUID id;

    private CountryJson countryJson;

    private String photo;

    private String description;

    private String username;

    public static PhotoJson convertFromGrpc(Photo photosGrpc) {
        return PhotoJson.builder()
                .id(!photosGrpc.getId().isEmpty() ? UUID.fromString(photosGrpc.getId()) : null)
                .photo(photosGrpc.getPhoto())
                .countryJson(CountryJson.fromGrpcMessage(photosGrpc.getCountry()))
                .description(photosGrpc.getDescription())
                .username(photosGrpc.getUsername())
                .build();
    }

    public Photo convertToGrpc() {
        return Photo.newBuilder()
                .setId(id != null ? id.toString() : "")
                .setUsername(username)
                .setDescription(description)
                .setPhoto(photo)
                .setCountry(countryJson.toGrpcMessage())
                .build();
    }
}
