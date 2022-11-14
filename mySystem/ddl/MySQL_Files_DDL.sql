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
INSERT INTO keyCards VALUES ('eba78f05-a0fe-43c1-be91-13adc826d495', 1, 0);
INSERT INTO keyCards VALUES ('6ebd1390-d91b-438e-9059-c1841f29ef71', 7, 1);
INSERT INTO keyCards VALUES ('9f17a7c1-ade9-49dd-baff-e152c3c9cb44', 4, 1);
INSERT INTO keyCards VALUES ('5f899d34-77b2-4cb6-aff1-15945766587e', 2, 1);

INSERT INTO users VALUES ('c88bb0d4-d6e6-48e8-a3ef-86e7550ea1b2','John', 'Doe', '38f5b748-0ca9-4873-ad07-014749cf8389', 'Johnpass');
INSERT INTO users VALUES ('b0915c8a-2a6d-4cbe-ad9d-3caa31c7e972','Jen', 'Doe', 'eba78f05-a0fe-43c1-be91-13adc826d495', NULL);
INSERT INTO users VALUES ('0dde60b8-b148-4d0a-bb3b-14fd9f4ab080','Satanshu', 'Mishra', '6ebd1390-d91b-438e-9059-c1841f29ef71', 'spass');
INSERT INTO users VALUES ('efcd102f-57f9-4c9b-a4f4-f92fd6c97b7f','Kate', 'Willams', '9f17a7c1-ade9-49dd-baff-e152c3c9cb44', 'kpass');
INSERT INTO users VALUES ('d20d7b15-3494-4116-977c-2664b464399f','Alice', 'Stone', '5f899d34-77b2-4cb6-aff1-15945766587e', NULL);