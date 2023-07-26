package org.rangiffler.jupiter.extension;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.rangiffler.api.rest.AuthClient;
import org.rangiffler.api.rest.AuthRestClient;
import org.rangiffler.api.rest.context.CookieContext;
import org.rangiffler.api.rest.context.SessionContext;
import org.rangiffler.api.rest.util.OauthUtils;
import org.rangiffler.config.Config;
import org.rangiffler.jupiter.annotation.ApiLogin;
import org.rangiffler.model.UserJson;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import java.util.Objects;

import static org.apache.commons.lang3.ArrayUtils.isEmpty;

public class ApiLoginExtension implements BeforeEachCallback, AfterTestExecutionCallback {

    protected static final Config CFG = Config.getConfig();

    private static final GenerateUserService generateUserService = new GenerateUserService();

    private static final AuthClient authClient = new AuthRestClient();
    private static final String JSESSIONID = "JSESSIONID";

    @Override
    public void beforeEach(ExtensionContext context) {
        ApiLogin apiLogin = context.getRequiredTestMethod().getAnnotation(ApiLogin.class);
        if (apiLogin != null) {
            String username;
            String password;

            if ("".equals(apiLogin.username()) || "".equals(apiLogin.password())) {
                if (isEmpty(apiLogin.user())) {
                    throw new IllegalStateException();
                } else {
                    UserJson generatedUser = generateUserService.generateUser(apiLogin.user()[0]);
                    username = generatedUser.getUsername();
                    password = generatedUser.getPassword();
                    context.getStore(GenerateUserExtension.NAMESPACE).put(getTestId(context), generatedUser);
                }
            } else {
                username = apiLogin.username();
                password = apiLogin.password();
            }

            doLogin(username, password);
        }
    }

    private void doLogin(String username, String password) {
        final SessionContext sessionContext = SessionContext.getInstance();
        final String codeVerifier = OauthUtils.generateCodeVerifier();
        final String codeChallenge = OauthUtils.generateCodeChallange(codeVerifier);

        sessionContext.setCodeVerifier(codeVerifier);
        sessionContext.setCodeChallenge(codeChallenge);

        authClient.authorizePreRequest();
        authClient.login(username, password);
        final String token = authClient.getToken();
        setUpBrowser(token);
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        SessionContext.getInstance().release();
        CookieContext.getInstance().release();
    }

    private void setUpBrowser(String token) {
        SessionContext sessionContext = SessionContext.getInstance();
        CookieContext cookieContext = CookieContext.getInstance();
        Selenide.open(CFG.getFrontUrl());
        Selenide.sessionStorage().setItem("id_token", token);
        Selenide.sessionStorage().setItem("codeChallenge", sessionContext.getCodeChallenge());
        Selenide.sessionStorage().setItem("codeVerifier", sessionContext.getCodeVerifier());
        Cookie jssesionIdCookie = new Cookie(JSESSIONID, cookieContext.getCookie(JSESSIONID));
        WebDriverRunner.getWebDriver().manage().addCookie(jssesionIdCookie);
    }

    private String getTestId(ExtensionContext context) {
        return Objects
                .requireNonNull(context.getRequiredTestMethod().getAnnotation(AllureId.class))
                .value();
    }
}
