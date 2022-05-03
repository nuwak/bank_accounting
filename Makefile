compile:
	./gradlew clean && ./gradlew build -x test

docker-clean:
	docker rmi -f banka_app:latest

run: compile docker-clean
	docker-compose up -d

stop:
	docker-compose down