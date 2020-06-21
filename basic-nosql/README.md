# Basic NoSQL

## Running local machine

run docker-compose.yml to start mongoDB with Redis

cd jax-rs-jakarta-security/basic-nosql

mvn clean package payara-micro:bundle

java -jar target/microprofile-microbundle.jar

## Infos

- Don't work in PayaraMicro 5.2020.2
- Updated Microprofile 2.2 to 3.3.
- Updated beans.xml bean-discovery-mode="annotated" to bean-discovery-mode="all"
