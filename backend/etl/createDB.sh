#!/bin/bash
#this shell script define creates database and tables
#it also defines schema for each table

echo -n "Enter the mysql username: "
read username
echo -n "Enter the mysql password: "
read -s password

#create database
createDB="create database if not exists article;"
mysql -u $username -p$password -e "$createDB"
echo "create database successfully"

#create article_table
createArticle_table="use article;create table if not exists article_table (
    id int not null auto_increment,
    title varchar(650),
    mdate date,
    keyword char(96),
    pages char(32),
    year int,
    volume char(32),
    journal char(128),
    number char(32),
    url varchar(256),
    ee varchar(256),
    primary key(id)
    );"
mysql -u $username -p$password -e "$createArticle_table"
echo "create article_table successfully"

#create article_author_table
createArticle_author_table="use article;create table if not exists article_author_table (
    id int not null auto_increment,
    article_id int not null,
    author_id int not null,
    primary key(id)
    );"
mysql -u $username -p$password -e "$createArticle_author_table"
echo "create article_author_table successfully"

#create author_table
createAuthor_table="use article;create table if not exists author_table (
    id int not null auto_increment,
    author char(64),
    primary key(id)
    );"
mysql -u $username -p$password -e "$createAuthor_table"
echo "create author_table successfully"
