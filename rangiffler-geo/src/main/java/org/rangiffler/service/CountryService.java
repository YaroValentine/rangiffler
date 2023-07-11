package org.rangiffler.service;

import org.rangiffler.data.Country;
import org.rangiffler.data.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService implements ICountryService {

    private final CountryRepository cr;

    @Autowired
    public CountryService(CountryRepository cr) {
        this.cr = cr;
    }

    @Override
    public Country getCountry() {
        return Country.fromCountryEntity(cr.getByCountryName("Ukraine"));
    }

    @Override
    public String getCountryNameByCode(String countryCode) {
        return Country.fromCountryEntity(cr.getByCountryCode(countryCode)).getCountryName();
    }

    @Override
    public List<Country> getAllCountries() {
        List<Country> allCountries = new ArrayList<>();
        cr.findAll().forEach(countryEntity -> allCountries.add(Country.fromCountryEntity(countryEntity)));
        return allCountries;
    }

}

