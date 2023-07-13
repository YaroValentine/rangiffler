package org.rangiffler.data.repository;

import org.rangiffler.data.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CountryRepository extends JpaRepository<CountryEntity, UUID> {

    CountryEntity getByCountryCode(String code);

}
