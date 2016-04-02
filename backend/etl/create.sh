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
    title varchar(512) not null,
    mdate date,
    keywords char(128),
    pages char(16),
    year char(16),
    volume char(16),
    journal char(128),
    number char(16),
    ee char(128),
    url char(128),
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
    author char(255),
    primary key(id)
    );"
mysql -u $username -p$password -e "$createAuthor_table"
echo "create author_table successfully"
