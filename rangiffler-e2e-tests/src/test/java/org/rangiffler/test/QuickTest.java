package org.rangiffler.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.rangiffler.db.entity.AuthUserEntity;
import org.rangiffler.jupiter.annotation.GenerateUserWithHibernate;
import org.rangiffler.jupiter.extension.GenerateUserHibernateExtension;

@ExtendWith(GenerateUserHibernateExtension.class)
public class QuickTest {

    @Test
    @GenerateUserWithHibernate
    @DisplayName("Quick integration test")
    void createUserTest(AuthUserEntity user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        Assertions.assertNotNull(user.getUsername());
    }
}
