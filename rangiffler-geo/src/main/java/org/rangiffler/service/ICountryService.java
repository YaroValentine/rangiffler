package org.rangiffler.service;

import org.rangiffler.data.Country;

import java.util.List;

public interface ICountryService {

    Country getCountry();

    String getCountryNameByCode(String countryCode);

    List<Country> getAllCountries();

}
