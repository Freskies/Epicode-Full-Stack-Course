CREATE TYPE t_event AS ENUM ('PUBLIC', 'PRIVATE');

CREATE TABLE events(
    event_id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    event_date DATE NOT NULL,
    description VARCHAR(100) NOT NULL,
    event_type t_event NOT NULL,
    max_participants INTEGER NOT NULL
);