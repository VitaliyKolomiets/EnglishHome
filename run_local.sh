#!/bin/bash
set -e

export JBT_PROJECT=${JBT_PROJECT:-'EnglishHome'}
export COMPOSE_PROJECT_NAME=${JBT_PROJECT}

docker-compose down || true
docker-compose build --no-cache
docker-compose -p ${JBT_PROJECT} up --force-recreate -d
