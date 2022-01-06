#!/bin/bash

./mvnw package

docker build -f src/main/docker/Dockerfile.jvm -t quarkus/comics-jvm .
