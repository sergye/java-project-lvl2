
setup:
	./gradlew wrapper --gradle-version 7.1

clean:
	./gradlew clean

install:
	./gradlew clean install

test:
	./gradlew test

run:
	./build/install/app/bin/app -f json ./src/test/resources/file1-1.json ./src/test/resources/file2-1.json

run-help:
	./build/install/app/bin/app -h

check-updates:
	./gradlew dependencyUpdates

lint:
	./gradlew checkstyleMain

build:
	./gradlew build

.PHONY: build