#!/bin/bash
#this script compiles and start GetMaxLengthOfAttrributes.java
rm *.class
javac GetMaxLengthOfAttrributes.java
java GetMaxLengthOfAttrributes ../data/article.xml
