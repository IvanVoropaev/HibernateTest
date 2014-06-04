--
-- ER/Studio 8.0 SQL Code Generation
-- Company :      vivi
-- Project :      Model1.DM1
-- Author :       viv
--
-- Date Created : Wednesday, June 04, 2014 16:48:24
-- Target DBMS : PostgreSQL 8.0
--

-- 
-- TABLE: applicant 
--

CREATE TABLE applicant(
    applicant_id     serial     NOT NULL,
    profession_id    int4		 NOT NULL,
    last_name        char(30)    NOT NULL,
    first_name       char(30)    NOT NULL,
    middle_name      char(30)    NOT NULL,
    entrance_year    int4        NOT NULL,
    CONSTRAINT "PK1" PRIMARY KEY (applicant_id)
)
;



-- 
-- TABLE: applicant_result 
--

CREATE TABLE applicant_result(
    applicant_result_id    serial  NOT NULL,
    applicant_id           int4    NOT NULL,
    subject_id             int4    NOT NULL,
    mark                   int4,
    CONSTRAINT "PK2" PRIMARY KEY (applicant_result_id)
)
;



-- 
-- TABLE: profession 
--

CREATE TABLE profession(
    profession_id      serial      NOT NULL,
    profession_name    char(50)    NOT NULL,
    CONSTRAINT "PK3" PRIMARY KEY (profession_id)
)
;



-- 
-- TABLE: speciality_subject 
--

CREATE TABLE speciality_subject(
    sp_sb_id         serial  NOT NULL,
    profession_id    int4    NOT NULL,
    subject_id       int4    NOT NULL,
    CONSTRAINT "PK4" PRIMARY KEY (sp_sb_id)
)
;



-- 
-- TABLE: subject 
--

CREATE TABLE subject(
    subject_id      serial      NOT NULL,
    subject_name    char(50)    NOT NULL,
    CONSTRAINT "PK5" PRIMARY KEY (subject_id)
)
;



-- 
-- INDEX: "Ref313" 
--

CREATE INDEX "Ref313" ON applicant(profession_id)
;
-- 
-- INDEX: "Ref112" 
--

CREATE INDEX "Ref112" ON applicant_result(applicant_id)
;
-- 
-- INDEX: "Ref514" 
--

CREATE INDEX "Ref514" ON applicant_result(subject_id)
;
-- 
-- INDEX: "Ref315" 
--

CREATE INDEX "Ref315" ON speciality_subject(profession_id)
;
-- 
-- INDEX: "Ref516" 
--

CREATE INDEX "Ref516" ON speciality_subject(subject_id)
;
-- 
-- TABLE: applicant 
--

ALTER TABLE applicant ADD CONSTRAINT "Refprofession13" 
    FOREIGN KEY (profession_id)
    REFERENCES profession(profession_id) ON DELETE RESTRICT ON UPDATE RESTRICT
;


-- 
-- TABLE: applicant_result 
--

ALTER TABLE applicant_result ADD CONSTRAINT "Refapplicant12" 
    FOREIGN KEY (applicant_id)
    REFERENCES applicant(applicant_id) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE applicant_result ADD CONSTRAINT "Refsubject14" 
    FOREIGN KEY (subject_id)
    REFERENCES subject(subject_id) ON DELETE RESTRICT ON UPDATE RESTRICT
;


-- 
-- TABLE: speciality_subject 
--

ALTER TABLE speciality_subject ADD CONSTRAINT "Refprofession15" 
    FOREIGN KEY (profession_id)
    REFERENCES profession(profession_id) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE speciality_subject ADD CONSTRAINT "Refsubject16" 
    FOREIGN KEY (subject_id)
    REFERENCES subject(subject_id) ON DELETE RESTRICT ON UPDATE RESTRICT
;

 create sequence hibernate_sequence
       MINVALUE 1 
       MAXVALUE 99999999999 
       START WITH 1
       INCREMENT BY 1 
       CACHE 100;


