FROM gradle:jdk15 as builder
WORKDIR /root
COPY src ./src
COPY settings.gradle.kts ./settings.gradle.kts
COPY build.gradle.kts ./build.gradle.kts
RUN gradle test installBootDist

FROM openjdk:15 as backend
WORKDIR /root
COPY --from=builder /root/build/install/filter-service-boot ./
