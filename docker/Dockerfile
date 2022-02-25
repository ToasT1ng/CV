FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
ENV PROFILE local
ARG JAR_FILE=cv.jar
ADD ${JAR_FILE} cv.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${PROFILE}","-Duser.timezone=Asia/Seoul","/cv.jar","&"]
