DROP TABLE IF EXISTS DNA;
DROP TABLE IF EXISTS DNA_TYPES;

CREATE TABLE DNA_TYPES
(
    id varchar(5) NOT NULL,
    description varchar(20)  NOT NULL,
    CONSTRAINT dna_type_pkey PRIMARY KEY (id)
);
 
CREATE TABLE DNA
(
    dna_string varchar(255)  NOT NULL,
    dna_type varchar(5) NOT NULL,
    CONSTRAINT dna_pkey PRIMARY KEY (dna_string),
    CONSTRAINT dna_type_fkey FOREIGN KEY (dna_type)
        REFERENCES dna_types (id)
);

