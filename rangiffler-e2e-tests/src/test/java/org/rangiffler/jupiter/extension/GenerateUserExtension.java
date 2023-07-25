package org.rangiffler.jupiter.extension;

import org.rangiffler.jupiter.annotation.GenerateUser;
import org.rangiffler.model.UserJson;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.extension.*;

import java.util.Objects;

public class GenerateUserExtension implements BeforeEachCallback, ParameterResolver {

    public static ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace
            .create(GenerateUserExtension.class);


    private static final GenerateUserService generateUserService = new GenerateUserService();

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
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

    private String getTestId(ExtensionContext context) {
        return Objects
                .requireNonNull(context.getRequiredTestMethod().getAnnotation(AllureId.class))
                .value();
    }
}
