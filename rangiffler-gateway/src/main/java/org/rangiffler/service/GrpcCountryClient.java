package org.rangiffler.service;

import com.google.protobuf.Empty;
import io.grpc.StatusRuntimeException;
import jakarta.annotation.Nonnull;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.grpc.rangiffler.grpc.RangifflerCountriesServiceGrpc;
import org.rangiffler.model.CountryJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class GrpcCountryClient {
    private static final Logger LOG = LoggerFactory.getLogger(GrpcCountryClient.class);
    private static final Empty EMPTY = Empty.getDefaultInstance();

    @GrpcClient("grpcCountriesClient")
    private RangifflerCountriesServiceGrpc.RangifflerCountriesServiceBlockingStub countriesServiceStub;

    public @Nonnull
    List<CountryJson> getAllCountries() {

        try {
            return countriesServiceStub.getCountries(EMPTY).getAllCountriesList()
                    .stream().map(CountryJson::fromGrpcMessage)
                    .toList();
        } catch (StatusRuntimeException e) {
            LOG.error("### Error while calling gRPC server ", e);
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "The gRPC operation was cancelled", e);
        }
    }
}
