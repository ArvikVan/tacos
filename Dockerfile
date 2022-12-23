FROM maven:3.8.5-openjdk-11-slim AS build
ENV HOME=/src
ENV SERVICE=tacos
RUN mkdir -p $HOME
WORKDIR $HOME

ADD pom.xml $HOME/pom.xml

RUN --mount=type=cache,target=/root/.m2 mvn -pl $SERVICE verify --fail-never
ADD $SERVICE $HOME/$SERVICE
RUN --mount=type=cache,target=/root/.m2 mvn -pl $SERVICE clean package

FROM openjdk:11-jre-slim

RUN mkdir /v-sql9
RUN mkdir /mnt/Tr_instore
RUN mkdir /mnt/templates

COPY --from=build target/*.jar /app/app.jar

ENTRYPOINT ["java",\
              "-XX:+UseContainerSupport",\
              "-XX:-UseAdaptiveSizePolicy",\
              "-Xmx5120m",\
              "-Xms256m",\
              "-Xss256k",\
              "-Djava.security.egd=file:/dev/./urandom",\
              "-jar",\
              "/app/app.jar"]