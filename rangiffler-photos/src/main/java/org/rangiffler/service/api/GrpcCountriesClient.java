package org.rangiffler.service.api;

import com.google.protobuf.Empty;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.grpc.rangiffler.grpc.Country;
import org.grpc.rangiffler.grpc.CountryByCodeRequest;
import org.grpc.rangiffler.grpc.RangifflerCountriesServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GrpcCountriesClient {

    private static final Logger LOG = LoggerFactory.getLogger(GrpcCountriesClient.class);

    @GrpcClient("grpcCountriesClient")
    private RangifflerCountriesServiceGrpc.RangifflerCountriesServiceBlockingStub countriesServiceStub;

    public Country getCountryByCode(CountryByCodeRequest request) {
        return countriesServiceStub.getCountriesByCode(request);
    }
}
