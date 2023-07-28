package org.rangiffler.api.rest;

public interface AuthClient {

    void authorizePreRequest();

    void login(String username, String password);

    String getToken();
}
