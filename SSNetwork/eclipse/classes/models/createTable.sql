/**
 *This file defines the schema of database tables,
 *How to run: mysql -u username -ppassword < createTable.sql
 **/

CREATE DATABASE IF NOT EXISTS ssnetwork;

use ssnetwork;

CREATE TABLE IF NOT EXISTS publications (
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

CREATE TABLE IF NOT EXISTS authors (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS publication_author (
    publicationID INTEGER,
    authorID INTEGER
);

commit;
