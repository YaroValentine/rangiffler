package org.rangiffler.service;

import jakarta.annotation.Nonnull;
import org.rangiffler.model.FriendJson;
import org.rangiffler.model.UserJson;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@Service
@Qualifier("rest")
public class RestUserClient implements IUserdataClient {

    private final WebClient webClient;
    private final String rangifflerUserdataBaseUri;

    public RestUserClient(WebClient webClient,
                          @Value("${rangiffler-userdata.base-uri}") String rangifflerUserdataBaseUri) {
        this.webClient = webClient;
        this.rangifflerUserdataBaseUri = rangifflerUserdataBaseUri;
    }

    //region User Controller
    @Override
    public @Nonnull
    List<UserJson> allUsers(@Nonnull String username) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        URI uri = UriComponentsBuilder.fromHttpUrl(rangifflerUserdataBaseUri + "/users").queryParams(params).build().toUri();

        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<UserJson>>() {
                })
                .block();
    }

    @Override
    public @Nonnull
    UserJson currentUser(@Nonnull String username) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        URI uri = UriComponentsBuilder.fromHttpUrl(rangifflerUserdataBaseUri + "/currentUser").queryParams(params).build().toUri();

        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(UserJson.class)
                .block();
    }

    @Override
    public @Nonnull
    UserJson updateUserInfo(@Nonnull UserJson user) {
        return webClient.patch()
                .uri(rangifflerUserdataBaseUri + "/currentUser")
                .body(Mono.just(user), UserJson.class)
                .retrieve()
                .bodyToMono(UserJson.class)
                .block();
    }
    //endregion

    //region Friends Controller
    @Override
    public @Nonnull
    List<UserJson> friends(@Nonnull String username) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        URI uri = UriComponentsBuilder.fromHttpUrl(rangifflerUserdataBaseUri + "/friends").queryParams(params).build().toUri();

        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<UserJson>>() {
                })
                .block();
    }

    @Override
    public @Nonnull
    List<UserJson> invitations(@Nonnull String username) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        URI uri = UriComponentsBuilder.fromHttpUrl(rangifflerUserdataBaseUri + "/invitations").queryParams(params).build().toUri();

        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<UserJson>>() {
                })
                .block();
    }

    @Override
    public @Nonnull
    UserJson acceptInvitation(@Nonnull String username,
                              @Nonnull UserJson friend) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        URI uri = UriComponentsBuilder.fromHttpUrl(rangifflerUserdataBaseUri + "/acceptInvitation").queryParams(params).build().toUri();

        return webClient.post()
                .uri(uri)
                .body(Mono.just(friend), UserJson.class)
                .retrieve()
                .bodyToMono(UserJson.class)
                .block();
    }

    @Override
    public @Nonnull
    UserJson declineInvitation(@Nonnull String username,
                               @Nonnull FriendJson invitation) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        URI uri = UriComponentsBuilder.fromHttpUrl(rangifflerUserdataBaseUri + "/friends/decline").queryParams(params).build().toUri();

        return webClient.post()
                .uri(uri)
                .body(Mono.just(invitation), FriendJson.class)
                .retrieve()
                .bodyToMono(UserJson.class)
                .block();
    }

    @Override
    public UserJson addFriend(@Nonnull String username,
                              @Nonnull FriendJson friend) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        URI uri = UriComponentsBuilder.fromHttpUrl(rangifflerUserdataBaseUri + "/addFriend").queryParams(params).build().toUri();

        return webClient.post()
                .uri(uri)
                .body(Mono.just(friend), FriendJson.class)
                .retrieve()
                .bodyToMono(UserJson.class)
                .block();
    }

    public @Nonnull
    UserJson removeFriend(@Nonnull String username,
                          @Nonnull UserJson friend) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        URI uri = UriComponentsBuilder.fromHttpUrl(rangifflerUserdataBaseUri + "/removeFriend").queryParams(params).build().toUri();

        return webClient.post()
                .uri(uri)
                .body(Mono.just(friend), UserJson.class)
                .retrieve()
                .bodyToMono(UserJson.class)
                .block();
    }
    //endregion
}
