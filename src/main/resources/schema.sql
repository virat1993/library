--ALTER TABLE borrow IF EXISTS DROP CONSTRAINT FKOQABI0TJFC9TI5RS149NG76Q1;
--DROP TABLE IF EXISTS borrow;
--DROP TABLE IF EXISTS books;
--DROP TABLE IF EXISTS users;
--
--
--CREATE TABLE books (
--  ID INT AUTO_INCREMENT  PRIMARY KEY,
--  name VARCHAR(250) NOT NULL,
--  author VARCHAR(250) NOT NULL,
--  publication VARCHAR(250) DEFAULT NULL,
--  year_of_publication VARCHAR(250) DEFAULT NULL,
--  isbn_no VARCHAR(250) DEFAULT NULL,
--  quantity INT DEFAULT 1
--);
--
--CREATE TABLE users (
--  ID INT AUTO_INCREMENT  PRIMARY KEY,
--  name VARCHAR(250) NOT NULL,
--  address VARCHAR(250) NOT NULL,
--  library_card_number VARCHAR(250) DEFAULT NULL,
--  is_active INT DEFAULT 1
--);
--
--
--CREATE TABLE borrow (
--  ID INT AUTO_INCREMENT  PRIMARY KEY,
--  library_card_number VARCHAR(250) NOT NULL,
--  BOOK_ID INT NOT NULL,
--  USER_ID INT NOT NULL,
--  is_returned INT DEFAULT 1
--);


CREATE TABLE borrows ();