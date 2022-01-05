cd server
./gradlew clean :installDist
cd ..
docker compose up --build
