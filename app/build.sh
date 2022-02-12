cd server || return
./gradlew clean :installDist
cd ..
docker-compose build
docker-compose up
