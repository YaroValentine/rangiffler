package org.rangiffler.config;

import org.rangiffler.data.Country;
import org.rangiffler.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@Service
public class CountryController {

    private final ICountryService cs;

    @Autowired
    public CountryController(ICountryService cs) {
        this.cs = cs;
    }

    @GetMapping("/country")
    public Country getCountry() {
        return cs.getCountry();
    }

    @GetMapping("/countryByCode/{code}")
    public ResponseEntity<String> getCountryByCode(@PathVariable("code") String countryCode) {
        String countryName = cs.getCountryNameByCode(countryCode);
        if (countryName != null) {
            return ResponseEntity.ok(countryName);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/allCountries")
    public List<Country> getAllCountries() {
        return cs.getAllCountries();
    }

}
