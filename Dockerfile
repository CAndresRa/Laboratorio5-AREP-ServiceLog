FROM openjdk:8
ENV PORT 35000
COPY "./target/logserviceone-0.0.1-SNAPSHOT.jar" "app1.jar"
ENTRYPOINT ["java","-jar","app1.jar"]
