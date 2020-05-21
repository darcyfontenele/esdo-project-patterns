CREATE SEQUENCE hibernate_sequence INCREMENT 1;

CREATE TABLE movie (
	id BIGSERIAL PRIMARY KEY NOT NULL,
	title VARCHAR(255) UNIQUE NOT NULL,
	synopsis VARCHAR(255) NULL,
	release_year NUMERIC(4,0) NULL,
	producer_name VARCHAR(255) NULL,
	protagonists_name VARCHAR NULL
);

CREATE TABLE movie_rating (
	id BIGSERIAL PRIMARY KEY NOT NULL,
	appraisers_name VARCHAR(255) NULL,
	rating INT NOT NULL,
	movie_id BIGINT NOT NULL REFERENCES movie(id)
);