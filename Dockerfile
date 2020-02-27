FROM maven:3-jdk-8-alpine as builder

COPY . /tmp

WORKDIR /tmp

RUN mvn clean package

FROM openjdk:8-jre-alpine

ENV COOKIE_DOMAIN, AUTH_HOST, SECRET
ENV VALIDITY_PERIOD=86400
ENV PWD_FILE=/htpasswd
EXPOSE 4567/tcp

COPY --from=builder /tmp/target/*.jar /app.jar

WORKDIR /

ENTRYPOINT /usr/bin/java -jar /app.jar -c $COOKIE_DOMAIN -h $AUTH_HOST -p $VALIDITY_PERIOD -f $PWD_FILE -s $SECRET