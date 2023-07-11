package org.rangiffler.data.repository;

import org.rangiffler.data.CountryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CountryRepository extends CrudRepository<CountryEntity, UUID> {

    CountryEntity getByCountryName(String nam);

    CountryEntity getByCountryCode(String name);


}
