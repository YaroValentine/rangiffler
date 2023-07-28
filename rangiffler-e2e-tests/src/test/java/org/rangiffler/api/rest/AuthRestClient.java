package org.rangiffler.api.rest;

import org.rangiffler.api.rest.context.CookieContext;
import org.rangiffler.api.rest.context.SessionContext;
import org.rangiffler.api.rest.interceptor.AddCookiesInterceptor;
import org.rangiffler.api.rest.interceptor.RecievedCodeInterceptor;
import org.rangiffler.api.rest.interceptor.RecievedCookiesInterceptor;
import org.junit.jupiter.api.Assertions;
import retrofit2.Response;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AuthRestClient extends BaseRestClient implements AuthClient {

    public AuthRestClient() {
        super(
                CFG.getAuthUrl(),
                true,
                new RecievedCookiesInterceptor(),
                new AddCookiesInterceptor(),
                new RecievedCodeInterceptor()
        );
    }

    private final AuthService authService = retrofit.create(AuthService.class);

    @Override
    public void authorizePreRequest() {
        try {
            authService.authorize(
                    "code",
                    "client",
                    "openid",
                    CFG.getFrontUrl() + "/authorized",
                    SessionContext.getInstance().getCodeChallenge(),
                    "S256"
            ).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void login(String username, String password) {
        final CookieContext cookieContext = CookieContext.getInstance();

        try {
            authService.login(
                    cookieContext.getFormattedCookie("JSESSIONID"),
                    cookieContext.getFormattedCookie("XSRF-TOKEN"),
                    cookieContext.getCookie("XSRF-TOKEN"),
                    username,
                    password
            ).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getToken() {
        final SessionContext sessionContext = SessionContext.getInstance();

        try {
            final String token = authService.token(
                    "Basic " + Base64.getEncoder().encodeToString("client:secret".getBytes(StandardCharsets.UTF_8)),
                    "client",
                    CFG.getFrontUrl() + "/authorized",
                    "authorization_code",
                    sessionContext.getCode(),
                    sessionContext.getCodeVerifier()
            ).execute().body().get("id_token").asText();
            sessionContext.setToken(token);
            return token;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void register(String username, String password) {
        CookieContext cookieContext = CookieContext.getInstance();
        try {
            authService.requestRegisterForm().execute();
            Response<Void> response = authService.register(
                            cookieContext.getFormattedCookie("XSRF-TOKEN"),
                            cookieContext.getCookie("XSRF-TOKEN"),
                            username,
                            password,
                            password)
                    .execute();
            Assertions.assertEquals(201, response.code());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
