# SSNetwork Meteor

Acknowledgements:
---------------------------------------------------------
Professor Jia Zhang and the teaching staff of 18-655,
Service Oriented Computing, at Carnegie Mellon University, Spring 2016.


## Compiling and Deployment

To run and test it locally, run following command after you clone the repo:

## Mac or Linux bash
```
$git clone https://github.com/helunwencser/SSNetwork.git
$cd SSNetwork/meteor/
$export MONGO_URL="mongodb://root:root@ec2-54-200-79-239.us-west-2.compute.amazonaws.com:27017/test"
$meteor

```
## File Structure

```
client: client views and interaction design windows
server: server start-up methods and persistant layers design
public: image, stylesheet
package: dependency
.meteor: build and deployment artitfacts
```
