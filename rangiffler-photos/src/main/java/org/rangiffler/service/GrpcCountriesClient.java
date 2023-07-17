package org.rangiffler.service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.grpc.rangiffler.grpc.Country;
import org.grpc.rangiffler.grpc.CountryByCodeRequest;
import org.grpc.rangiffler.grpc.RangifflerCountriesServiceGrpc;
import org.springframework.stereotype.Component;

@Component
public class GrpcCountriesClient {

    @GrpcClient("grpcCountriesClient")
    private RangifflerCountriesServiceGrpc.RangifflerCountriesServiceBlockingStub countriesServiceStub;

    public Country getCountryByCode(CountryByCodeRequest request) {
        return countriesServiceStub.getCountriesByCode(request);
    }
}
