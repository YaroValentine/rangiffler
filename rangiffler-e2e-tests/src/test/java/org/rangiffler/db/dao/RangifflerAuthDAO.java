package org.rangiffler.db.dao;

import org.rangiffler.db.entity.AuthUserEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

public interface RangifflerAuthDAO {
    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    int createUser(AuthUserEntity user);

    AuthUserEntity readUser(UUID uuid);

    int updateUser(AuthUserEntity user);

    int removeUser(AuthUserEntity user);

    String getUserId(String userName);
}
