FROM openjdk:7
MAINTAINER zhangfei
EXPOSE 20000
COPY *.jar /app.jar
WORKDIR
ENTRYPOINT ["java","-jar","/app.jar"]
