package org.rangiffler.service;


import org.rangiffler.data.model.UserJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Nonnull;
import java.net.URI;
import java.util.List;

@Component
public class RestUserdataClient {

    private final WebClient webClient;
    private final String userdataUri;

    @Autowired
    public RestUserdataClient(WebClient webClient,
                              @Value("${rangiffler-userdata.base-uri}") String userdataUri) {
        this.webClient = webClient;
        this.userdataUri = userdataUri;
    }

    public @Nonnull
    List<UserJson> friends(@Nonnull String username) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        URI uri = UriComponentsBuilder.fromHttpUrl(userdataUri + "/friends").queryParams(params).build().toUri();

        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<UserJson>>() {
                })
                .block();
    }
}

