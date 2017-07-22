FROM java:8-jdk-alpine

WORKDIR /opt

ADD build/libs/docker-sample-web.jar docker-sample-web.jar

EXPOSE 8082

ENTRYPOINT ["/usr/bin/java"]

CMD ["-jar",  "/opt/docker-sample-web.jar"]