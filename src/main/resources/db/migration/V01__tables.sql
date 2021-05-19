CREATE SCHEMA CORE;

-- DROPS
DROP TABLE CORE.TB_USER IF EXISTS;
DROP TABLE CORE.TB_POST IF EXISTS;

DROP SEQUENCE IF EXISTS CORE.SEQ_USER;
DROP SEQUENCE IF EXISTS CORE.SEQ_POST;

-- CREATE
CREATE SEQUENCE CORE.SEQ_USER INCREMENT BY 1 NO MINVALUE NO MAXVALUE START WITH 1;
CREATE SEQUENCE CORE.SEQ_POST INCREMENT BY 1 NO MINVALUE NO MAXVALUE START WITH 1;


CREATE TABLE CORE.TB_USER
(
    ID_USER     numeric(19, 0) NOT NULL,
    NM_NICKNAME varchar(255)   NOT NULL UNIQUE,
    DT_CREATE   datetime       NOT NULL,
    PRIMARY KEY (ID_USER)
);


CREATE TABLE CORE.TB_IMAGE
(
    ID_IMAGE      uuid         NOT NULL,
    NM_IMAGE      varchar(255) NOT NULL,
    DS_IMAGE_TYPE varchar(100) NOT NULL,
    FILE          text         NOT NULL,
    PRIMARY KEY (ID_IMAGE)
);


CREATE TABLE CORE.TB_POST
(
    ID_POST    numeric(19, 0)      NOT NULL,
    ID_USER    numeric(19, 0)      NOT NULL,
    DT_CREATE  datetime            NOT NULL,
    DS_POST    varchar(1000)       NOT NULL,
    IS_DELETED boolean DEFAULT '0' NOT NULL,
    PRIMARY KEY (ID_POST)
);
ALTER TABLE CORE.TB_POST ADD CONSTRAINT FKTB_POSTS519267 FOREIGN KEY (id_user) REFERENCES CORE.TB_USER (id_user);
