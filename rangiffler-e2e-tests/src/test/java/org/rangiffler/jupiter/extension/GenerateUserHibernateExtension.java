package org.rangiffler.jupiter.extension;

import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.extension.*;
import org.rangiffler.db.dao.RangifflerAuthDAO;
import org.rangiffler.db.dao.RangifflerAuthDAOHibernate;
import org.rangiffler.db.entity.Authority;
import org.rangiffler.db.entity.AuthorityEntity;
import org.rangiffler.db.entity.AuthUserEntity;
import org.rangiffler.db.jpa.EmfProvider;
import org.rangiffler.jupiter.annotation.GenerateUserWithHibernate;

import java.util.Arrays;

import static org.rangiffler.utils.DataUtils.generateRandomUsername;

public class GenerateUserHibernateExtension extends BaseExtension
        implements ParameterResolver, BeforeEachCallback, AfterTestExecutionCallback, SuiteExtension {

    public static ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace
            .create(GenerateUserHibernateExtension.class);

    @Override
    public void beforeEach(ExtensionContext context) {
        final String testId = getTestId(context);
        GenerateUserWithHibernate annotation = context.getRequiredTestMethod().getAnnotation(GenerateUserWithHibernate.class);
        if (annotation != null) {
            AuthUserEntity authUserEntity = new AuthUserEntity();
            authUserEntity.setUsername(generateRandomUsername());
            authUserEntity.setPassword("secret");
            authUserEntity.setEnabled(true);
            authUserEntity.setAccountNonExpired(true);
            authUserEntity.setAccountNonLocked(true);
            authUserEntity.setCredentialsNonExpired(true);

            authUserEntity.setAuthorities(Arrays.stream(Authority.values())
                    .map(authority -> {
                                AuthorityEntity authorityEntity = new AuthorityEntity();
                                authorityEntity.setAuthority(authority);
                                authorityEntity.setUser(authUserEntity);
                                return authorityEntity;
                            }
                    ).toList());
            RangifflerAuthDAO db = new RangifflerAuthDAOHibernate();
            db.createUser(authUserEntity);
            context.getStore(NAMESPACE).put(testId, authUserEntity);
        }
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
                                     ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(AuthUserEntity.class)
               && extensionContext.getRequiredTestMethod().getAnnotation(GenerateUserWithHibernate.class) != null;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext,
                                   ExtensionContext extensionContext) throws ParameterResolutionException {
        GenerateUserWithHibernate annotation = extensionContext.getRequiredTestMethod().getAnnotation(GenerateUserWithHibernate.class);
        if (annotation != null) {
            final String testId = getTestId(extensionContext);
            return extensionContext.getStore(NAMESPACE).get(testId, AuthUserEntity.class);
        }
        return null;
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        GenerateUserWithHibernate annotation = context.getRequiredTestMethod().getAnnotation(GenerateUserWithHibernate.class);
        if (annotation != null) {
            final String testId = getTestId(context);
            AuthUserEntity user = (AuthUserEntity) context.getStore(NAMESPACE).get(testId);
            RangifflerAuthDAO db = new RangifflerAuthDAOHibernate();
            db.removeUser(user);
        }
    }

    @Override
    public void afterSuite() {
        EmfProvider.INSTANCE.storedEmf()
                .forEach(EntityManagerFactory::close);
    }

}