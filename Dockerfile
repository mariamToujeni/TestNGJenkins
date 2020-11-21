FROM selenium/standalone-chrome:3.141.59

USER root

RUN apt-get update -y && \
    apt-get install -y maven && \
    apt-get install -y openjdk-8-jdk
#file to create a docker images with maven + jdk8


