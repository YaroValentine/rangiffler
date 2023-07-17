package org.rangiffler.service.api;

import com.google.protobuf.Empty;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GrpcUsersClient {
    private static final Logger LOG = LoggerFactory.getLogger(GrpcCountriesClient.class);
    private static final Empty EMPTY = Empty.getDefaultInstance();

    @GrpcClient("grpcUsersClient")
    private RangifflerUsersServiceGrpс.RangifflerUsersServiceBlockingStub rangifflerUsersServiceBlockingStub;

    public Users getAllFriends(UsernameRequest request) {
        return rangifflerUsersServiceBlockingStub.getAllFriends(request);
    }
}
