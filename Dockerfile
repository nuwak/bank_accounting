FROM openjdk:17-alpine
COPY ./build/libs/finmid.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
