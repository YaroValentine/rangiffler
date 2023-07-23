#!/bin/bash

source ./rangiffler-e2e-tests/docker.properties

echo '### Java version ###'
java --version
echo '### Gradle version ###'
gradle --version

docker-compose -f docker-compose.test.yml down
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)
docker rmi -f $(docker images | grep 'rangiffler')

ARCH=$(uname -m)

bash ./gradlew clean build dockerTagLatest -x :rangiffler-e2e-tests:test

var DOCKER_ARCH
if [ "$ARCH" = "arm64" ] || [ "$ARCH" = "aarch64" ]; then
  DOCKER_ARCH="linux/arm64/v8"
  docker build --build-arg DOCKER=arm64v8/eclipse-temurin:19-jdk -t "${IMAGE_NAME}":"${VERSION}" -t "${IMAGE_NAME}":latest -f ./rangiffler-e2e-tests/Dockerfile .
else
  DOCKER_ARCH="linux/amd64"
  docker build --build-arg DOCKER=eclipse-temurin:19-jdk -t "${IMAGE_NAME}":"${VERSION}" -t "${IMAGE_NAME}":latest -f ./rangiffler-e2e-tests/Dockerfile .
fi

var front
if [[ "$1" = "gql" ]]; then front="./rangiffler-client-gql/"; else front="./rangiffler-client/"; fi

cd "$front" || exit
bash ./docker-build.sh test
cd ../ || exit
docker docker pull sskorol/selenoid_chromium_vnc:100.0
docker images
ARCH="$DOCKER_ARCH" docker-compose -f docker-compose.test.yml up -d
docker ps -a
