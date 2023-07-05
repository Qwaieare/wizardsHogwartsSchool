-- liquibase formatted sql

-- changeset postgres:1
CREATE TABLE faculty (
                         id BIGINT NOT NULL generated by default as identity PRIMARY KEY,
                         color varchar(255),
                         name varchar(255)
);
-- changeset postgres:2
ALTER TABLE faculty ADD CONSTRAINT name_unique UNIQUE (name);