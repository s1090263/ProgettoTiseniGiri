# TiseniGiri Application
## Introduction
This project consists in the creation of a Spring application simulating a web server on a local machine which can be used to request a list of tweets related mainly to the official account of the "Università Politecnica delle Marche", but the user can choose every  official page he wants.
Tweets are objects characterised by some parameters of various type, such as  number of retweets or likes, hashtags,user, and more. These parameters will be the criteria used for filtering the list  
When the application starts, the user can make a POST or GET request, which is then sent to the application. For every request the application communicates with twitter's official API through a token that allows us to get a list of tweets written in JSON format. Then the application parses this JSON file in a list of tweets and applies requested filters on parameters to the same list, making stats on the filtered list.
# How it works
<img src = UML%20Diagrams/Use%20Case%20diagrams/Use%20Case%20diagram.jpg>
After starting from Eclipse IDE, the application is ready to receive requests from users or clients, waiting for them on the local port 8080. In fact every requests to the application is sent to the URL http://localhost:8080. In order to test the application we can use a software for API testing like "Postman"
The application let to the user the possibility to choose five different routes to ask information he wants; two of them supports GET-type requests and three of them, instead, support POST-type requests. More over through the features of the software "Postman" we can also specify two values, the key and the count, which allow us to get a certain number of tweets of a certain page. If these values are not specified in Postman, it will be used the dafault values that are @UnivPoliMarche for the key and 100 for the count. Let's now analyse the different routes:

 * /tweets : GET-request which gives back to user a number of tweets related to an official page 
 * /metadata : GET-request which gives back to user the metadata explaining how tweet object is composed
 * /tweets/filter : POST-request which gives back to user tweets complying with fliters requested in body of the POST
 * /tweets/stats : POST-request which gives back to user stats requested in body of the POST, on all available tweets
 * /tweets/filter/stats : POST-request which gives back to user stats requested in body of the POST, on tweets complying with filters requested before stats in the body

Filter and stats are POST-requets, 'cause user need to specify which filters and statistics he wants. For this reason now we will focus on how to make filters and stats requests
### Making a filter request
In order to make a filter request user must have a basic knowledge of JSON syntax, since the use of JSON format makes it easier to write the code which completes filter request written in the body(In such way developers have the possibility to use java reflection libraries to search the correct method to apply the filter). The application also gives the user the possibility to make multiple filter requests, each identified by a unique key. The correct JSON syntax to make a filter request is the following:
{
"key" : ["Field", "Method's name", "Method's parameters"]
}
Key parameter must be different for each filter, otherwise an exception will be thrown.
Field parameter must be one of the following words:

* Favorites
* Retweets 
* Hashtag 
* User
* Time
* Engagement

Method's name represents the name of the method which apply the filter to the list of tweets and method's parameter are the input parameters for that method.
Each field refers to a different field of tweet object which can be both a string, a number or even a date. The fields Favorites,Reetweets and Hashtag refers to numerical features of tweet which are number of like, number of retweets and number of hashtag, and for this reason they are categorised as "numerical filter". For this type of filter are avalaible four methods to apply the filter:

- greater, which returns all the tweets with  a number of likes, retweets or hashtags, higher than the number passed from the user    
  Ex. { "1" : ["Favorites","greater", 5]} returns all tweets with a number of likes higher than five
- lower, which returns all the tweets with  a number of likes, retweets or hashtags, lower than the number passed from the user     
  Ex. { "1" : ["Retweets","lower", 3]} returns all tweets with a number of retweets lower than three
- equal, which returns all the tweets with the same number of likes, retweets or hashtags, passed from the user     
  Ex. { "1" : ["Hashtag","equal", 1]} returns all tweets with a number of hashtags equal to one 
- between, which returns all the tweets with a number of likes,retweets or hashtags, lower than the first number passed from user and greater than the second   
  Ex. { "1" : ["Favorites","between", 5,3]} returns all the tweet with a number of likes included between three and five
  
The field User refers to an object which as a parameter a string called "name", and also the field hashtag refers to another parameter which is the text of the hashtag which is a String parameter. For this reason the filters working with these parameters are categorised as "String Filters" and for them there is only one method avalaible to apply the filter:

- stringSearch, which returns all the tweet containing a string parameter identical to the string passed in input from the user(the method is case sensitive and takes into account spaces )                                                                          
  Ex. { "1" : ["Hashtag","stringSearch","cusancona"]} returns all the tweet with hashtag text "cusancona"                       
  Ex. { "1" : ["User","stringSearch","Emanuele Frontoni"]} returns all the tweet posted by Emanuele Frontoni on that official page
  
The field Time refers also to a string object, namely the parameter created_at of tweet object, which indicates when the tweet was posted on the page. So in order to realise a filter on this particular field we must convert the string into a Date object in Java. Then using some method of the class Date whe can implements four different filters similar to numerical filters for the name, but with a lot a difference in term of parameters and implementation. The dates which the user will gives in input in the JSON body must be written as string in the correct format which is the twitter's date format ( Ex. "Tue Jul 14 14:00:00 +0000 2020, where +0000 indicates time zone). Methods are the following

- greater, which returns all the tweets posted after the date given as input from the user                                                 
  Ex. { "1" : ["Time", "greater", "Tue Jul 14 10:30:00 +0000 2020"]}
- lower, which returns all the tweets posted before the date given as input from the user                                                 
  Ex. { "1" : ["Time", "lower", "Mon Jul 13 12:30:00 +0000 2020"]}
- equal, which returns all the tweets posted in the same date given as input from the user                                                 
  Ex. { "1" : ["Time", "equal", "Sun Jul 12 20:40:00 +0000 2020"]}
- between, which returns all the tweets posted after the first date given as input from the user and before the second                                                  
  Ex. { "1" : ["Time", "between", "Tue Jul 14 10:30:00 +0000 2020","Mon Jul 13 12:30:00 +0000 2020"]}

The last field Engagement refers to a particular filter that was requested in the application commit. These type of field is related to a filter which selects a certain number of tweets with the most valuable engagement parameters. As engagement parameters we chose the number of retweets and the number of like of a tweet giving more importance to the first. The method named "sortForRetweets" associated to the filter sorts the tweets in descending order using firstly the number of retweets, and only if two posts has the same number of retweets, it ordinates them for the numbers of like in descending order. After the sorting operation the method selects only the first num tweets of the list where num is passed by the user in the body of the request

- Ex. { "1" : ["Engagement","sortForRetweets", 40]} returns the first 40 tweets with most valuable engagement parameters

To conclude the analysis of filters we show an example of a request of multiple filters in the same JSON body:

- Ex. { 
       "1" : ["Hashtag","greater", 0],                                                          
       "2" : ["Engagement","sortForRetweets", 40]
       }

Filters in that request body are executed in the order they are written, and these two filters in that order return to user the list of tweet requested in project commit, on which we can make stats. More over adding filters to these two is not difficult beacuse it is only necessary to add a new key(for example "3") specifying the field,  method and parameters( for example we can also filter that list of tweet according to the date in which they were posted adding in that JSON body "3" : ["Time","greater","Tue Jul 14 10:30:00 +0000 2020"]). It is recommended to indicates keys always with numbers between two double quotes.
       

### Making a stats Request
Making a stats request is similar to make requests for filters, in fact the correct JSON symtax to make a stats request is:
{ "key" : [ "Field", "Method's name", "Method's parameters"] }
