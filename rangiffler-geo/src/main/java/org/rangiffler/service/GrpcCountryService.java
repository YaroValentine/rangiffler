package org.rangiffler.service;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.grpc.rangiffler.grpc.Countries;
import org.grpc.rangiffler.grpc.Country;
import org.grpc.rangiffler.grpc.CountryByCodeRequest;
import org.grpc.rangiffler.grpc.RangifflerCountriesServiceGrpc;
import org.rangiffler.data.CountryEntity;
import org.rangiffler.data.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GrpcService
public class GrpcCountryService extends RangifflerCountriesServiceGrpc.RangifflerCountriesServiceImplBase {

    private final CountryRepository cr;

    @Autowired
    public GrpcCountryService(CountryRepository cr) {
        this.cr = cr;
    }

    @Override
    public void getCountries(Empty request, StreamObserver<Countries> responseObserver) {
        List<CountryEntity> allCountries = cr.findAll();

        Countries response = Countries.newBuilder()
                .addAllAllCountries(
                        allCountries.stream().map(
                                countryEntity -> Country.newBuilder()
                                        .setId(countryEntity.getId().toString())
                                        .setCountryName(countryEntity.getCountryName())
                                        .setCountryCode(countryEntity.getCountryCode())
                                        .build()
                        ).toList()
                )
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getCountriesByCode(CountryByCodeRequest request, StreamObserver<Country> responseObserver) {
        CountryEntity countryEntity = cr.getByCountryCode(request.getCode());

        Country response = Country.newBuilder()
                .setId(countryEntity.getId().toString())
                .setCountryName(countryEntity.getCountryName())
                .setCountryCode(countryEntity.getCountryCode())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
