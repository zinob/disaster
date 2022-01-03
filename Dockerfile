FROM openjdk:8-jdk
EXPOSE 8365:8080
RUN mkdir /app
WORKDIR /app/
COPY ./src/ /app/src/
COPY ./gradle/ /app/gradle/
COPY ./*gradle* /app/
RUN pwd;ls 
RUN ./gradlew wrapper; ./gradlew build
CMD ["./gradlew", "run"]
