CREATE DATABASE IF NOT EXISTS files;

USE files;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS keyCards;


CREATE TABLE keyCards (
 kuuid CHAR(36) NOT NULL,
 clearanceLevel INTEGER NOT NULL,
 isActive BIT NOT NULL DEFAULT 1,
 PRIMARY KEY (kuuid)
);

CREATE TABLE users (
 uuid CHAR(36) NOT NULL,
 firstName VARCHAR(64) NOT NULL,
 lastName VARCHAR(64) NOT NULL,			
 kuuid CHAR(36),
 loginKey VARCHAR(34),
 PRIMARY KEY (uuid),
 FOREIGN KEY (kuuid) REFERENCES keyCards(kuuid)
);

INSERT INTO keyCards VALUES ('38f5b748-0ca9-4873-ad07-014749cf8389', 5, 1);
INSERT INTO users VALUES ('c88bb0d4-d6e6-48e8-a3ef-86e7550ea1b2','John', 'Doe', '38f5b748-0ca9-4873-ad07-014749cf8389', NULL);

INSERT INTO keyCards VALUES ('eba78f05-a0fe-43c1-be91-13adc826d495', 1, 1);
INSERT INTO users VALUES ('b0915c8a-2a6d-4cbe-ad9d-3caa31c7e972','Jen', 'Doe', 'eba78f05-a0fe-43c1-be91-13adc826d495', NULL);