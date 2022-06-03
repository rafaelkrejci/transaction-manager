run-dev:
	mvn clean spring-boot:run

build-docker-image:
	mvn clean install

run-docker-image:
	docker run -p 8080:8080 krejci:latest