/**
 *This file defines the schema of database tables,
 *How to run: mysql -u username -ppassword < createTable.sql
 **/

DROP DATABASE IF EXISTS ssnetwork;

CREATE DATABASE ssnetwork;

use ssnetwork;

CREATE TABLE IF NOT EXISTS publication (
    id INTEGER PRIMARY KEY AUTO_INCREMENT, 
    pubkey VARCHAR(50),
    title VARCHAR(250), 
    editor VARCHAR(100), 
    year VARCHAR(50), 
    isbn VARCHAR(50), 
    url TEXT, 
    volume VARCHAR(50), 
    pages VARCHAR(50), 
    mdate VARCHAR(50), 
    series VARCHAR(50), 
    publisher VARCHAR(50), 
    booktitle VARCHAR(50), 
    crossref VARCHAR(50), 
    ee TEXT
);

CREATE TABLE IF NOT EXISTS author (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS publication_author (
    publicationID INTEGER,
    authorID INTEGER
);

create table person (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64),
  dueDate DATETIME(6)
);

create table search (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  keywords  VARCHAR(64),
  searchType VARCHAR(255)
);

commit;