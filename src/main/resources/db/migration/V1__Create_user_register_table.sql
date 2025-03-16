CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE IF NOT EXISTS public."user-register"
(
    uid SERIAL PRIMARY KEY, 
    email VARCHAR(255),
    password VARCHAR(255),
    phno VARCHAR(255),
    role VARCHAR(255),
    username VARCHAR(255)
);

-- Ensure the owner of the table
ALTER TABLE IF EXISTS public."user-register"
    OWNER TO postgres;
