package org.rangiffler.service;

import net.devh.boot.grpc.server.service.GrpcService;
import org.rangiffler.data.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.grpc.rangiffler.grpc.RangifflerCountriesServiceGrpc;

@GrpcService
// RangifflerCountriesServiceGrpc.RangifflerCountriesServiceImplBase
public class GrpcCountryService  /*RangifflerCountriesServiceImplBase*/ {

    private final CountryRepository cr;

    @Autowired
    public GrpcCountryService(CountryRepository cr) {
        this.cr = cr;
    }



}
