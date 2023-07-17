package org.rangiffler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grpc.rangiffler.grpc.Country;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryJson {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    private String countryName;

    @JsonProperty("code")
    private String countryCode;

    public static CountryJson fromGrpcMessage(Country geo) {
        return new CountryJson(
                UUID.fromString(geo.getId()),
                geo.getCountryName(),
                geo.getCountryCode()
        );
    }

    public Country toGrpcMessage() {
        return Country.newBuilder().setCountryCode(countryCode)
                .setId(/*id != null ? */id.toString()/* : ""*/) //todo check :?
                .setCountryName(countryName)
                .build();
    }

}
