CREATE TYPE t_periodicity AS ENUM ('WEEKLY','MONTHLY','SEMI_ANNUALLY');

CREATE TABLE publication
(
    ISBN                SERIAL PRIMARY KEY,
    title               VARCHAR(50) NOT NULL,
    year_of_publication INT         NOT NULL,
    pages               INTEGER     NOT NULL
);

CREATE TABLE genres
(
    id    SERIAL PRIMARY KEY,
    genre VARCHAR(50) NOT NULL
);

CREATE TABLE authors
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE books
(
    ISBN      SERIAL PRIMARY KEY,
    genre_id  INT NOT NULL REFERENCES genres (id) ON DELETE SET NULL,
    author_id INT NOT NULL REFERENCES authors (id) ON DELETE SET NULL
);

CREATE TABLE magazines
(
    ISBN        SERIAL PRIMARY KEY,
    periodicity t_periodicity NOT NULL
);

CREATE TABLE users
(
    card_number SERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    surname     VARCHAR(50) NOT NULL,
    birth       DATE        NOT NULL
);

CREATE TABLE loans
(
    id                    SERIAL PRIMARY KEY,
    ISBN                  INT  NOT NULL REFERENCES publication (ISBN) ON DELETE SET NULL,
    user_id               INT  NOT NULL REFERENCES users (card_number) ON DELETE SET NULL,
    loan_date             DATE NOT NULL,
    excepted_return_date  DATE NOT NULL,
    effective_return_date DATE
);