FROM java:8-jdk-alpine

WORKDIR /opt

ADD build/libs/docker-sample-api.jar docker-sample-api.jar

EXPOSE 8081

ENTRYPOINT ["/usr/bin/java"]

CMD ["-jar",  "/opt/docker-sample-api.jar"]