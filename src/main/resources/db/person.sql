CREATE TABLE public.person
(
    person_id     UUID NOT NULL,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    email         VARCHAR(255),
    phone         VARCHAR(255),
    photo         BYTEA,
    passport_face BYTEA,
    passport_back BYTEA,
    CONSTRAINT pk_person PRIMARY KEY (person_id)
);