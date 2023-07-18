package org.rangiffler.controller;

import org.rangiffler.model.CountryJson;
import org.rangiffler.service.GrpcCountryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private final GrpcCountryClient cc;

    @Autowired
    public CountryController(GrpcCountryClient countryService) {
        this.cc = countryService;
    }

    @GetMapping("/countries")
    public List<CountryJson> getAllCountries(@AuthenticationPrincipal Jwt principal) {
        return cc.getAllCountries();
    }

}
