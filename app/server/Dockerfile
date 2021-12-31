FROM openjdk:8-jdk
EXPOSE 8080:8080
RUN mkdir -p /app/server
COPY ./server/build/install/biblioteka/ /app/server/
WORKDIR /app/server/bin
CMD ["./biblioteka"]