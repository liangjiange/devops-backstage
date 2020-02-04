FROM openjdk:8-jdk-alpine

MAINTAINER liangjiange <liangjiange@gmail.com>

ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8
ENV TZ=Asia/Shanghai
ENV ACTIVE=""

RUN mkdir /app

WORKDIR /app

COPY target/devops-backstage-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

# -c为清除以前启动的数据
ENTRYPOINT ["sh","-c","java -jar /app/app.jar --spring.profiles.active=$ACTIVE"]