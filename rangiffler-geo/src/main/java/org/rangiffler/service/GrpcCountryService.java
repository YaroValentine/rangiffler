package org.rangiffler.service;

import net.devh.boot.grpc.server.service.GrpcService;
import org.rangiffler.data.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class GrpcCountryService {

    private final CountryRepository cr;

    @Autowired
    public GrpcCountryService(CountryRepository cr) {
        this.cr = cr;
    }



}
