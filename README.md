# What is this for?

This repository demonstrates running Flyway migrations in a Spring Boot app.

# Who is this for?

Developers, platform engineers, and others may use this repository for design and architectural patterns for
implementing Flyway migrations.

# What is here?

## Migrator

The `migrator` runs a set of migrations at startup and then exits. The `migrator` module is a Spring Boot non-web
application.

## Docker Compose

`docker-compose.yml` contains a MySQL definition, as well as a definition for `migrator`.

# What are the dependencies?

- Docker

# How do I run?

```shell
~/projects/flyway-migrator # docker compose up migrator
```