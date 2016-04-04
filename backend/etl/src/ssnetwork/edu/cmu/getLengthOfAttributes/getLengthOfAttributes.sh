#!/bin/bash
#this script compiles and start GetMaxLengthOfAttrributes.java
rm *.class
javac GetMaxLengthOfAttrributes.java
#java GetMaxLengthOfAttrributes ../../../../../eclipse_workspace/dblp.xml  
java GetMaxLengthOfAttrributes ../data/article.xml 
