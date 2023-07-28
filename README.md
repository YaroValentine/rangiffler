# Rangiffler

Welcome Traveler!
You've found a perfect place to share with friends your most adventurous photos 
from the places you've been.

Meet Rangiffler, a username-friendly app that lets you collect and arrange your travel images. 
Share your thoughts in each of your entry.
Add friends from our username list and explore their posts. 
Use our interactive map feature to keep track of countries you've visited and
lights up on the map, letting you sort your photos by 
country with a simple click.

## Technologies

- [Spring Authorization Server](https://spring.io/projects/spring-authorization-server)
- [Spring OAuth 2.0 Resource Server](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/index.html)
- [Spring data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Web](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#spring-web)
- [Spring actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)
- [Spring gRPC by https://github.com/yidongnan](https://yidongnan.github.io/grpc-spring-boot-starter/en/server/getting-started.html)
- [Spring web-services](https://docs.spring.io/spring-ws/docs/current/reference/html/)
- [Docker](https://www.docker.com/resources/what-container/)
- [Docker-compose](https://docs.docker.com/compose/)
- [MySQL](https://www.mysql.com/why-mysql/)
- [React](https://ru.reactjs.org/docs/getting-started.html)
- [Apache Kafka](https://developer.confluent.io/quickstart/kafka-docker/)
- [Thymeleaf](https://www.thymeleaf.org/)
- [JUnit 5 (Extensions, Resolvers, etc)](https://junit.org/junit5/docs/current/username-guide/)
- [Retrofit 2](https://square.github.io/retrofit/)
- [Allure](https://docs.qameta.io/allure/)
- [Selenide](https://selenide.org/)
- [Selenoid & Selenoid-UI](https://aerokube.com/selenoid/latest/)
- [Allure-docker-service](https://github.com/fescobar/allure-docker-service)
- [Java 19](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html)
- [Gradle 7.6](https://docs.gradle.org/7.6/release-notes.html)
- And more

## Distributed File System Diagram
![Rangiffler.png](images%2FRangiffler.png)

**Minimum requirements to start working with Rangiffler**

Ports need for Rangiffler to work:

|      Service | Port            | 
|------------:|:----------------| 
|    FRONTEND | 3001            |
|        AUTH | 9000            |
|     GATEWAY | 8080            |
|    USERDATA | 9010            |
|         GEO | 9020, gRPC:9021 |
|      PHOTOS | 9030, gRPC:9031 |

#### 1. Install docker (if not installed)

We will be using Docker for the database (MySQL), and additionally, we will be launching 
microservices in a unified Docker network using docker-compose.

[For Windows](https://docs.docker.com/desktop/install/windows-install/)

[For Mac](https://docs.docker.com/desktop/install/mac-install/) (ARM or Intel)

[For Linux](https://docs.docker.com/desktop/install/linux-install/)

After installing and starting the Docker daemon, you need to ensure that the Docker commands 
are working, for example docker -v:

```posh
docker -v
Docker version 20.10.14, build a224086
```

#### 2. Pull the MySQL 8, Zookeeper, and Kafka version 7.3.2 containers.

```posh
docker pull mysql
docker pull confluentinc/cp-zookeeper:7.3.2
docker pull confluentinc/cp-kafka:7.3.2
```

#### 3. Create a volume to save data from the database in Docker on your computer.

```posh
docker volume create mysql_data
```

#### 4. Start Database container.

```posh
docker run --name rangiffler-all -p 5432:5432 -e POSTGRES_PASSWORD=secret -v pgdata:/var/lib/postgresql/data -d postgres:15.1

docker run --name=zookeeper -e ZOOKEEPER_CLIENT_PORT=2181 -e ZOOKEEPER_TICK_TIME=2000 -p 2181:2181 -d confluentinc/cp-zookeeper:7.3.2

Zookeeper_Server_IP=$(docker inspect zookeeper --format='{{ .NetworkSettings.IPAddress }}')

docker run --name=kafka -e KAFKA_BROKER_ID=1 \
-e KAFKA_ZOOKEEPER_CONNECT=${Zookeeper_Server_IP}:2181 \
-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
-e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
-e KAFKA_TRANSACTION_STATE_LOG_MIN_ISR=1 \
-e KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR=1 \
-p 9092:9092 -d confluentinc/cp-kafka:7.3.2
```

#### 5. Install Java version 17 or newer. This is necessary as the project does not support versions less than 17.

Verity java version:

```posh
java -version
openjdk version "19.0.1" 2022-10-18
OpenJDK Runtime Environment Homebrew (build 19.0.1)
```

If you have multiple versions of Java installed simultaneously, at least one of them must be 17 or higher. 
If Java is not installed at all, it is recommended to install OpenJDK (for example, 
from https://adoptium.net/en-GB/).

#### 6. Install the npm package manager for front-end build. [Instructions](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm).

Recommended Node.js - 18.13.0 (LTS)

## Running Rangiffler locally in IDE:

#### 1. Go to the rangiffler-client directory.

```posh
cd rangiffler-client
```

#### 2. Launch the frontend (first update the dependencies).

```posh
npm i
npm run
```

#### 3. Set the run configuration for all rangiffler-* services - Active profiles local.

To do this, go to the Run menu -> Edit Configurations -> select the main class -> specify Active profiles: local.
[Instruction](https://stackoverflow.com/questions/39738901/how-do-i-activate-a-spring-boot-profile-when-running-from-intellij).

#### 4. Start all Rangiffler services using Gradle or the Run command in the IDE in every service directory:

```posh
gradle bootRun --args='--spring.profiles.active=local'
```

- Auth
- Gateway
- Userdata
- Geo
- Photos

Or simply by going to the main class of every RangifflerServiceApplication and selecting run in IDE 
(making sure the previous step has been completed).

The frontend will be available at http://127.0.0.1:3001/

## Running Rangiffler in Docker:

#### 1. Create a free account at https://hub.docker.com/ (if you don't have one already).

#### 2. Create an access_token in the settings of your account. [Instruction](https://docs.docker.com/docker-hub/access-tokens/).

#### 3. Perform a docker login with the created access_token.

#### 4. Add an alias for the Docker-name in the etc/hosts file.
- frontend:  127.0.0.1 frontend.rangiffler.dc,
- auth:      127.0.0.1 auth.rangiffler.dc
- gateway:   127.0.0.1 gateway.rangiffler.dc

```posh
vi /etc/hosts
```

```posh
##
# Host Database
#
# localhost is used to configure the loopback interface
# when the system is booting.  Do not change this entry.
##
127.0.0.1       localhost
127.0.0.1       frontend.rangiffler.dc
127.0.0.1       auth.rangiffler.dc
127.0.0.1       gateway.rangiffler.dc
```

#### 5. Go to the root directory of the project.

```posh
cd rangiffler
```
#### 6. Start all services.

- Start with tests

```posh
bash docker-compose-e2e.sh
```

- Start without tests

```posh
bash docker-compose-dev.sh
```
When running in Docker, Rangiffler will be available at the address http://rangiffler-frontend/
*IMPORTANT!* Only the following ports will be available to you from the docker-network:
- Port 3001 (all requests from it are redirected by nginx to the frontend)
- Port 9000 (rangiffler-auth service)
- Port 8080 (rangiffler-gateway service)

#### 7. Selenoid UI is available at: http://localhost:9090/

#### 8. Allure is available at: http://127.0.0.1:5050/allure-docker-service/projects/rangiffler-e2e-tests/reports/latest/index.html

*Enjoy the Rangiffler*
![logo-rangiffler.svg](images%2Flogo-rangiffler.svg)