CREATE TABLE IF NOT EXISTS articles
(
    id           INT8 GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    title        TEXT,
    author       TEXT,
    created_date TIMESTAMP,
    description  TEXT,
    photo        TEXT,
    locale       TEXT
);