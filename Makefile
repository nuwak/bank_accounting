compile:
	./gradlew clean && ./gradlew build -x test

docker-clean:
	docker rmi -f finmid_app:latest

run: compile docker-clean
	docker-compose up -d

stop:
	docker-compose down