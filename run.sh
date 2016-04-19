#!/bin/bash
#this shell script create database tables and start the project

echo -n "Enter MySQL username: "
read username
echo -n "Enter MySQL password: "
read -s password
mysql -u $username -p$password < ./app/models/createTable.sql
activator run
