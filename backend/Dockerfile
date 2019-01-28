FROM java:8

COPY ./target/weshare-manage.jar /app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "/app.jar" ]
