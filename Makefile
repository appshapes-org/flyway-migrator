build:
	$(CURDIR)/gradlew build

clean:
	$(CURDIR)/gradlew clean
	git clean -xdf .ignored

commit-only: build test
	git add --verbose :/ .
	git commit -m "$(message)"

commit: commit-only
	git pull
	git push --verbose

down:
	docker compose down

gradle-tasks:
	$(CURDIR)/gradlew tasks --all

image:
	docker build --build-arg PROJECT=$(service) -f $(service)/Dockerfile -t $(service) .

image-run:
	docker run --name $(service) -it --rm --entrypoint $(command) $(service)

image-sh:
	docker exec -it $(service) sh

kube-apply:
	kubectl apply -f $(file)
	kubectl get pods

kube-delete:
	kubectl delete -f $(file)

stop:
	docker compose stop $(service)

test:
	$(CURDIR)/gradlew test

up:
	docker compose build $(service)
	docker compose up -d $(service)