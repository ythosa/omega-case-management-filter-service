FROM gradle:jdk15 as builder
WORKDIR /app
COPY src ./src
COPY build.gradle.kts ./build.gradle.kts
RUN gradle clean test installDist
FROM openjdk:15 as backend
WORKDIR /root
COPY --from=builder /app/build/install/app ./
