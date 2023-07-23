ARG DOCKER
FROM $DOCKER
ENV JAVA_OPTS=""

WORKDIR /rangiffler
COPY ./gradle ./gradle
COPY ./gradlew ./
COPY ./rangiffler-e2e-tests ./rangiffler-e2e-tests
COPY ./rangiffler-grpc-common ./rangiffler-grpc-common
COPY ./build.gradle ./
COPY ./settings.gradle ./

CMD chmod +x ./rangiffler-e2e-tests/send_results.sh; ./gradlew test -Dtest.env=docker; bash ./rangiffler-e2e-tests/send_results.sh
