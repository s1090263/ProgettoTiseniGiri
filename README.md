# TiseniGiri Application
## Introduction
This project consists in the creation of a Spring application simulating a web server on a local machine which can be used to request a list of tweets related mainly to the official account of the "Università Politecnica delle Marche", but the user can choose every official page he wants. The user can also ask for a filtered list instead, and he can make statistics relative to the fields of the tweets.
Tweets are objects characterised by some parameters of various type, such as  number of retweets or likes, hashtags, user, and more. These parameters will be the criteria used for filtering the list of tweets.  
When the application starts, the user can make a POST or GET request, which is then sent to the application. For every request the application communicates with twitter's official API through a token that allows us to get a list of tweets written in JSON format. Then the application parses this JSON file in a list of tweets and applies requested filters on parameters to the same list, making stats on the filtered list.
# How it works
<img src = UML%20Diagrams/Use%20Case%20diagrams/Use%20Case%20diagram.jpg>
After starting from Eclipse IDE, the application is ready to receive requests from users or clients, waiting for them on the local port 8080. In fact every requests to the application is sent to the URL http://localhost:8080. In order to test the application we can use a software for API testing like "Postman".
The application gives the user the possibility to choose five different routes to ask information; two of them supports GET-type requests and three of them, instead, support POST-type requests. More over the client can also specify two values in the request, the key and the count, which allow him to get a certain number of tweets of a certain page. If these values are not explicitly specified, the application will operate with the default values: "@UnivPoliMarche" for the key and "100" for the count. Let's now analyze the different routes:

 * /tweets : GET-request which gives back to the user a number of tweets related to an official page 
 * /metadata : GET-request which gives back to the user the metadata explaining how a tweet object is composed
 * /tweets/filter : POST-request which gives back to the user tweets complying with fliters requested in the body of the POST
 * /tweets/stats : POST-request which gives back to the user stats requested in the body of the POST, on all available tweets
 * /tweets/filter/stats : POST-request which gives back to the user stats requested in the body of the POST, on tweets complying with filters requested in the same body

Filter and stats are POST-requets, 'cause user need to specify which filters and statistics he wants. For this reason we will mow focus on how to make filters and stats requests.
### Making a filter request
In order to make a filter request user must have a basic knowledge of JSON syntax, since the use of JSON format makes it easier to write the code which completes a filter request written in the body (in such way developers have the possibility to use java reflection libraries to search the correct method to applyto the filter). The application also gives the user the possibility to make multiple filter requests, each identified by a unique key. The correct JSON syntax to make a single filter request is the following:

{ "key" : ["Field", "Method's name", "Method's parameters"] }

"Key" parameter is the identifier for that signle request and it must be different for each filter, otherwise an exception will be thrown.
"Field" parameter represents the tweet's field that the user wants to filter and it must be one of the following words:

* Favorites
* Retweets 
* Hashtag 
* User
* Time
* Engagement

"Method's name" represents the name of the method which applies the filter to the list of tweets and "method's parameter" are the input parameters for that method.
Each field refers to a different field of the tweet object which can be both a string, a number or even a date. The fields Favorites,Reetweets and Hashtag, for example, refer to numerical features of the tweet, in particular: number of likes, number of retweets and number of hashtags, and for this reason they are categorised as "numerical filters". For this type of filter the user can choose from four methods that apply different filters:

- "greater", which returns all the tweets with  a number of likes, retweets or hashtags, higher than the number passed from the user    
  Ex. { "1" : ["Favorites","greater", 5]} returns all tweets with a number of likes higher than five
- "lower", which returns all the tweets with  a number of likes, retweets or hashtags, lower than the number passed from the user     
  Ex. { "1" : ["Retweets","lower", 3]} returns all tweets with a number of retweets lower than three
- "equal", which returns all the tweets with the same number of likes, retweets or hashtags, passed from the user     
  Ex. { "1" : ["Hashtag","equal", 1]} returns all tweets with a number of hashtags equal to one 
- "between", which returns all the tweets with a number of likes,retweets or hashtags, lower than the first number passed from user and greater than the second   
  Ex. { "1" : ["Favorites","between", 5,3]} returns all the tweets with a number of likes included between three and five
  
The field "User" refers to an object which contains a string parameter called "name",the field "Hashtag" also refers to an object containing a string parameter representing the text of the hashtag. Filters working with these parameters are categorised as "String Filters" and for them there is only one method avalaible to apply the filter:

- "stringSearch", which returns all the tweets containing a string parameter identical to the string passed in input from the user (the method is case sensitive and takes into account spaces)                                                                          
  Ex. { "1" : ["Hashtag","stringSearch","cusancona"]} returns all the tweets with hashtag text "cusancona"                       
  Ex. { "1" : ["User","stringSearch","Emanuele Frontoni"]} returns all the tweets posted by Emanuele Frontoni on that official page
  
The field "Time" also refers to a string object, the parameter "created_at" of a tweet object, which indicates when the tweet was posted on the page. This is a special string parameter so in order to create a filter on this particular field we converted the string into a Date object in Java. Then using methods of the class Date we implemented four different filters similar by the name to the numerical ones, but with a lot of difference in term of parameters and implementation. The dates which the user will give in input in the JSON body must be written as a string in the correct format which is the twitter's date format ( Ex. "Tue Jul 14 14:00:00 +0000 2020, where +0000 indicates time zone). Methods are the following:

- "greater", which returns all the tweets posted after the date given in input from the user                                                 
  Ex. { "1" : ["Time", "greater", "Tue Jul 14 10:30:00 +0000 2020"]}
- "lower", which returns all the tweets posted before the date given in input from the user                                                 
  Ex. { "1" : ["Time", "lower", "Mon Jul 13 12:30:00 +0000 2020"]}
- "equal", which returns all the tweets posted in the same date given in input from the user                                                 
  Ex. { "1" : ["Time", "equal", "Sun Jul 12 20:40:00 +0000 2020"]}
- between, which returns all the tweets posted after the first date given as input from the user and before the second one                                                 
  Ex. { "1" : ["Time", "between", "Tue Jul 14 10:30:00 +0000 2020","Mon Jul 13 12:30:00 +0000 2020"]}

The last field "Engagement" refers to a particular filter that was requested in the application commit. These type of field is related to a filter which selects a certain number of tweets with the most valuable engagement parameters. As engagement parameters we chose the number of retweets and the number of likes of a tweet giving more importance to the first. The method named "sortForRetweets" associated to the filter sorts the tweets in descending order using firstly the number of retweets, and only if two posts have the same number of retweets it ordinates them for the numbers of likes in descending order. After the sorting operation the method selects only the first "num" tweets of the list where "num" is passed by the user in the body of the request

- Ex. { "1" : ["Engagement","sortForRetweets", 40]} returns the first 40 tweets with most valuable engagement parameters

To conclude the analysis of filters we show an example of a request with multiple filters in the same JSON body:

- Ex. { 
       "1" : ["Hashtag","greater", 0],                                                          
       "2" : ["Engagement","sortForRetweets", 40]
       }

Filters in that request body are executed in the order they are written, and these two filters in that order return to the user the list of tweets requested in the project commit, on which we can make stats. Moreover adding filters to these two is not difficult beacuse it is only necessary to add a new key(for example "3") specifing the field,  method and parameters( for example we can also filter that list of tweets according to the date in which they were posted adding in that JSON body '"3" : ["Time","greater","Tue Jul 14 10:30:00 +0000 2020"]'). It is recommended to indicate keys always with numbers between two double quotes.
       

### Making a stats Request
Making a stats request is similar to make requests for filters, in fact the correct JSON symtax to make a stats request is:

{ "key" : [ "Field", "Method's name", "Method's parameters"] }

Where the key is unique even for the stats; Field represents the parameter of tweet object on which we want to make stats, and ii followed by the name of the method realising a precise stats and its parameters. Field parameter can be:

- Favorites
- Retweets
- Hashtag

Field "Favorites" refers to the parameter indicating the number of likes of a tweet, while fields Retweets and Hashtags refers respectively to the number of retweets of a tweet and the number of hashatag of a tweet. For each of these numerical parameters we have three methods that realises stats on tweets or on filtered tweets:

- average, which returns the average of likes,retweets, or number of hashtags of tweet's list                                    
  Ex. { "1" : ["Favorites" , "average"]} returns likes average of list
- frequency which returns the count of the post with a precise number of likes,retweets or hashtag, given as input by the user                                  
  Ex. { "1" : ["Retweets","frequency",4]} returns the count of all the post on the page with four retweets
- standardDeviation, which returns the standard deviation of likes,retweets, or number of hashtags of tweet's list                                          
  Ex. { "1" : ["Hashtags","standardDeviation"]} returns Hashtags standardDeviation of list

