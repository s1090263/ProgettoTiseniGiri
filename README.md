# TiseniGiri Application
## Introduction
This project consists in the creation of a Spring application simulating a web server on a local machine which can be used to request a list of tweets related mainly to the official account of the "Università Politecnica delle Marche", but the user can choose every  official page he wants.
Tweets are objects characterised by some parameters of various type, such as  number of retweets or likes, hashtags,user, and more. These parameters will be the criteria used for filtering the list  
When the application starts, the user can make a POST or GET request, which is then sent to the application. For every request the application communicates with twitter's official API through a token that allows us to get a list of tweets written in JSON format. Then the application parses this JSON file in a list of tweets and applies requested filters on parameters to the same list, making stats on the filtered list.
# How it works
<img src = UML%20Diagrams/Use%20Case%20diagrams/Use%20Case%20diagram.jpg>
After starting from Eclipse IDE, the application is ready for receiving requests from users or clients, waiting for them on the local port 8080. In fact every requests to the application is sent to the URL http://localhost:8080. In order to test the application we can use a software for API testing like "Postman"
The application let to the user the possibility to choose five different routes to ask information he wants; two of them supports GET-type requests and three of them, instead, support POST-type requests. More over through the features of the software "Postman" we can also specify two values, the key and the count, which allow us to get a certain number of tweets of a certain page. If these values are not specified in Postman, it will be used the dafault values that are @UnivPoliMarche for the key and 100 for the count. Let's now analyse the different routes:

 * /tweets : GET-request which gives back to user a number of tweets related to an official page 
 * /metadata : GET-request which gives back to user the metadata explaining how tweet object is composed
 * /tweets/filter : POST-request which gives back to user tweets complying with fliters requested in body of the POST
 * /tweets/stats : POST-request which gives back to user stats requested in body of the POST, on all available tweets
 * /tweets/filter/stats : POST-request which gives back to user stats requested in body of the POST, on tweets complying with filters requestedbefore stats in the body
