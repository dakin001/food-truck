FROM amazoncorretto:21
LABEL name="food-truck"
COPY build/libs/app-server.jar app-server.jar
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java -XX:MaxRAMPercentage=100 -jar /app-server.jar" ]
