ARG DOCKER
FROM $DOCKER
ARG APP_VER
ENV VER=${APP_VER}
ENV JAVA_OPTS=""
WORKDIR /application
COPY rangiffler-photos-$VER.jar ./

EXPOSE 9031
CMD java -jar -Dspring.profiles.active=docker $JAVA_OPTS rangiffler-photos-$VER.jar
