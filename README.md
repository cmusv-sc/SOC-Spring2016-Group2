# SSNetwork

Scientific Social Network

18-655, Spring 2016, Carnegie Mellon University  

Scientists collaborate and publish papers together, to share their experiments, and other scientists may either communicate or comment on papers. In this project, we design and develop an SOA solution for scientific social network, based on scientists' co-authorship, citation relationship, and follow up relationship.

##Contributor
###Team 4:
  Lunwen He, Chun-Yen Hsu, Yu-Liang Hsu, Ziming Wang
###Team 5:
  Jiajie Liang, Zhenbiao Yan, Yanning Liu, Yuan Yuan
###Team 6:
  Yi Cao, Xun Zhang, Meng Wu, Qing Guo

## How to run

Prequisite:
  1. Make sure you have installed Java(JDK 8), MySQL, Play Framework(Version 2.5.0) and Meteor Framework.
  2. Make sure you have database named "ssnetwork" in your MySQL database.
  3. Change the default.username and default.password for JDBC in SSNetwork/backend/conf/application.conf to your MySQL database name and passwork.
  4. Set the environment variable for MongoDB using: 
      export MONGO_URL="mongodb://root:root@ec2-54-200-79-239.us-west-2.compute.amazonaws.com:27017/test"
  
To run and test it locally, run following commands:

```bash
git clone https://github.com/helunwencser/SSNetwork.git
cd SSNetwork/backend
activator run
cd ../frontend/meteor
meteor
```

##File structure:

backend: the backend of SSNetwork which is based on play framework, backend default port number: 9000

meteor: the frontend of SSNetwork which is based on meteor framework, frontend default port number: 3000


Acknowledgements:
---------------------------------------------------------
Professor Jia Zhang and the teaching staff of 18-655,
Service Oriented Computing, at Carnegie Mellon University, Spring 2016.
