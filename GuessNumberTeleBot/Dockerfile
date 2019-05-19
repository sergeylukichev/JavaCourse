#
# Build stage
#
FROM maven:3.6.0-jdk-8 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:8
COPY --from=build /home/app/target/telegram-spring-boot-starter-example-0.19-SNAPSHOT.jar /usr/local/lib/bot.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/bot.jar"]