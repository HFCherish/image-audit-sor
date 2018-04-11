FROM java:8
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} /var/run/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/var/run/app.jar"]
EXPOSE 8081