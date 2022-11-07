FROM openjdk:11
VOLUME /tmp
EXPOSE 8082
ADD ./target/ms-bank-credit-0.0.1-SNAPSHOT.jar ms-bank-credit.jar
ENTRYPOINT ["java","-jar","/ms-bank-credit.jar"]