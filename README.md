# TiseniGiri Application
## Introduction
This project consists in the creation of a Spring application simulating a web server on a local machine which can be used to request a list of tweets related mainly to the official account of the "Università Politecnica delle Marche", but the user can choose every  official page he wants.
Tweets are objects characterised by some parameters of various type, such as  number of retweets or likes, hashtags,user, and more. These parameters will be the criteria used for filtering the list  
When the application starts, the user can make a POST or GET request, which is then sent to the application. For every request the application communicates with twitter's official API through a token that allows us to get a list of tweets written in JSON format. Then the application parses this JSON file in a list of tweets and applies requested filters on parameters to the same list, making stats on the filtered list.
# How it works
