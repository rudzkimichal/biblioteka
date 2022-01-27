cd server || return
./gradlew clean :installDist
cd ..
docker compose up --build
