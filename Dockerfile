FROM debian:latest
MAINTAINER Roberto Andrade <roberto.andrade@gmail.com>

ENV DEBIAN_FRONTEND noninteractive
ENV TERM xterm

# Prerequisites
RUN echo 'deb http://http.debian.net/debian jessie-backports main' >> /etc/apt/sources.list && \
	apt-get update && \
	apt-get install -y openjdk-8-jdk && \
	update-alternatives --set java /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java && \
	apt-get clean

RUN mkdir /app

COPY . /app/

WORKDIR /app
CMD javac src/ServerSocketTest.java -d . && java ServerSocketTest