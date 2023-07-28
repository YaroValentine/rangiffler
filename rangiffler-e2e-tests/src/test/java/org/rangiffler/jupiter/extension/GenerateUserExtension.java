package org.rangiffler.jupiter.extension;

import org.junit.jupiter.api.extension.*;
import org.rangiffler.db.dao.RangifflerAuthDAO;
import org.rangiffler.db.dao.RangifflerAuthDAOHibernate;
import org.rangiffler.db.entity.AuthUserEntity;
import org.rangiffler.jupiter.annotation.GenerateUser;
import org.rangiffler.model.UserJson;

public class GenerateUserExtension extends BaseExtension
        implements BeforeEachCallback, AfterTestExecutionCallback, ParameterResolver {

    public static ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace
            .create(GenerateUserExtension.class);
    private static final GenerateUserService generateUserService = new GenerateUserService();

    @Override
    public void beforeEach(ExtensionContext context) {
        GenerateUser annotation = context.getRequiredTestMethod()
                .getAnnotation(GenerateUser.class);

        if (annotation != null) {
            context.getStore(NAMESPACE).put(getTestId(context), generateUserService.generateUser(annotation));
        }
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
                                     ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(UserJson.class);
    }

    @Override
    public UserJson resolveParameter(ParameterContext parameterContext,
                                     ExtensionContext extensionContext) throws ParameterResolutionException {
        return extensionContext.getStore(NAMESPACE).get(getTestId(extensionContext), UserJson.class);
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        GenerateUser annotation = context.getRequiredTestMethod().getAnnotation(GenerateUser.class);
        if (annotation != null) {
            final String testId = getTestId(context);
            AuthUserEntity user = (AuthUserEntity) context.getStore(NAMESPACE).get(testId);
            RangifflerAuthDAO db = new RangifflerAuthDAOHibernate();
            db.removeUser(user);
        }
    }
}
