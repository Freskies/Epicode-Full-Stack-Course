CREATE TYPE t_event AS ENUM ('PUBLIC', 'PRIVATE');
CREATE TYPE t_participant_state AS ENUM ('CONFIRMED', 'PENDING');
CREATE TYPE t_sex AS ENUM ('M', 'F');

CREATE TABLE persons
(
    person_id  SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(50) NOT NULL,
    birth_date DATE        NOT NULL,
    sex        t_sex       NOT NULL
);

CREATE TABLE location
(
    location_id SERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    address     VARCHAR(50) NOT NULL
);

CREATE TABLE events
(
    event_id         SERIAL PRIMARY KEY,
    title            VARCHAR(50)  NOT NULL,
    event_date       DATE         NOT NULL,
    description      VARCHAR(100) NOT NULL,
    event_type       t_event      NOT NULL,
    max_participants INTEGER      NOT NULL,
    location_id      INTEGER REFERENCES location (location_id)
);

CREATE TABLE event_participants
(
    event_id  INTEGER REFERENCES events (event_id),
    person_id INTEGER REFERENCES persons (person_id),
    state     t_participant_state NOT NULL,
    PRIMARY KEY (event_id, person_id)
);

-- DATA

INSERT INTO persons(first_name, last_name, email, birth_date, sex)
VALUES ('John', 'Doe', 'example@gmail.com', '1990-01-01', 'M'),
       ('Mary', 'Jane', 'spaghetti@gmail.com', '1995-01-01', 'F');

INSERT INTO location(name, address)
VALUES ('Location 1', 'Address 1'),
       ('Location 2', 'Address 2'),
       ('Location 3', 'Address 3');

INSERT INTO events(title, event_date, description, event_type, max_participants, location_id)
VALUES ('Event 1', '2020-01-01', 'Description 1', 'PUBLIC', 10, 1),
       ('Event 2', '2020-01-02', 'Description 2', 'PRIVATE', 20, 2),
       ('Event 3', '2020-01-03', 'Description 3', 'PUBLIC', 30, 3);

INSERT INTO event_participants(event_id, person_id, state)
VALUES (1, 1, 'CONFIRMED'),
       (1, 2, 'PENDING'),
       (2, 1, 'CONFIRMED'),
       (2, 2, 'CONFIRMED'),
       (3, 1, 'PENDING'),
       (3, 2, 'PENDING');

SELECT *
FROM persons;