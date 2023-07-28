package org.rangiffler.test.db;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.rangiffler.db.dao.RangifflerAuthDAO;
import org.rangiffler.db.dao.RangifflerAuthDAOHibernate;
import org.rangiffler.db.entity.AuthorityEntity;
import org.rangiffler.db.entity.AuthUserEntity;
import org.rangiffler.jupiter.annotation.GenerateUserWithHibernate;
import org.rangiffler.jupiter.extension.GenerateUserHibernateExtension;

import java.util.List;
import java.util.UUID;

import static org.rangiffler.utils.DataUtils.generateRandomUsername;

@DisplayName("DATABASE: CRUD TESTS")
@ExtendWith(GenerateUserHibernateExtension.class)
public class HibernateCrudTests {

    @Test
    @AllureId("3306:1001")
    @GenerateUserWithHibernate
    @DisplayName("Can create user")
    void createUserTest(AuthUserEntity user) {
        System.out.println(user.getUsername());
        Assertions.assertNotNull(user.getUsername());
    }

    @Test
    @AllureId("3306:1002")
    @GenerateUserWithHibernate
    @DisplayName("Can read user")
    void readUserTest(AuthUserEntity user) {
        RangifflerAuthDAO db = new RangifflerAuthDAOHibernate();
        List<AuthorityEntity> authorities = db.readUser(user.getId()).getAuthorities();

        Assertions.assertEquals(authorities.get(0).getAuthority().toString(), "read");
        Assertions.assertEquals(authorities.get(1).getAuthority().toString(), "write");
        Assertions.assertTrue(db.readUser(user.getId()).getEnabled());
    }

    @Test //TODO Need Fix: Does not remove user from DB after test
    @AllureId("3306:1003")
    @GenerateUserWithHibernate
    @DisplayName("Can update user")
    void updateUserTest(AuthUserEntity user) {
        RangifflerAuthDAO db = new RangifflerAuthDAOHibernate();
        Assertions.assertTrue(user.getEnabled());

        user.setEnabled(false);
        db.updateUser(user);

        Assertions.assertFalse(user.getEnabled());
    }

    @Test
    @AllureId("3306:1004")
    @GenerateUserWithHibernate
    @DisplayName("Can delete user")
    void deleteUserTest(AuthUserEntity user) {
        Allure.addAttachment("User to delete", user.getUsername());

    }

}
