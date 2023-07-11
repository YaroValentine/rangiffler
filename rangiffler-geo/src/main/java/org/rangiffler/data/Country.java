package org.rangiffler.data;

import java.util.UUID;

public class Country {

    private String countryName;
    private String countryCode;
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public static Country fromCountryEntity(CountryEntity ce) {
        Country country = new Country();
        country.setId(ce.getId());
        country.setCountryName(ce.getCountryName());
        country.setCountryCode(ce.getCountryCode());
        return country;
    }

}
