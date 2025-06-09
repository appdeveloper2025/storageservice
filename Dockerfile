FROM openjdk:11-jre-slim
VOLUME /tmp
COPY target/storageservice-0.0.1-SNAPSHOT.jar storageservice.jar
ENTRYPOINT ["java","-jar","/storageservice.jar"]