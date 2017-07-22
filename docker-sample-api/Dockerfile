FROM anapsix/alpine-java:8

WORKDIR /opt

ADD build/libs/docker-sample-api.jar docker-sample-api.jar

EXPOSE 8081

ENTRYPOINT ["/usr/bin/java"]

CMD ["-jar",  "/opt/docker-sample-api.jar"]