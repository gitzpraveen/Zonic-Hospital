
CREATE TABLE IF NOT EXISTS public.appointment
(
    pid SERIAL NOT NULL PRIMARY KEY,
    additional_information VARCHAR(2000),
    age INTEGER,
    date VARCHAR(255),
    doctor VARCHAR(255),
    patient_name VARCHAR(255),
    user_uid INTEGER
);


CREATE TABLE IF NOT EXISTS public."user-register_appointments"
(
    id SERIAL NOT NULL PRIMARY KEY,
    user_uid INTEGER NOT NULL,
    appointments_pid BIGINT NOT NULL
);

