![companylogo]({{site.baseurl}}/images/405logo.png)

# Advanced Prototype 

Welcome to the third blog post of 405 Found - Money Control Application. It will give you an update on the 3rd Milestone that we have achieved in our project also how our basic prototype application has been evolved with the new requirements that has been added by our customers into a final Advanced prototype.

Without further ado, Lets Start...

## Using a particular Software Design Pattern and the reasons behind it:  
---------------


In Software development world, design pattern is referred to as a general repeatable solution to a commonly occuring problem in your software design. A design pattern isn't a finished design that can be transformed directly into code. It is a description or template for how to solve a problem that can be used in many different situations.

The design pattern, that we are using in our Money Control- Application is "Model-View-Controller (MVC)" design pattern, which specifies that an application consist of a data model, presentation information, and control information.

Let's first know what Model, View and Controller means in MVC pattern and then we can move to an example on how this concept in used in our Application.

• The Model contains only the pure application data, it contains no logic describing how to present the data to a user.
• The View is the UI layer  —  it does visualisation of the data from the Model.
• The Controller exists between the view and the model. It is the logic layer, gets notified of the user’s behavior and updates the Model as needed.

The MVC implemented in our application development has, the model represented by DataBaseHelper class in our apaplication that stores all the data and manipulation methods, which is further linked with MainActivity class surving as Controller, linked to all activity classes which are the view. A graphical respresentation of the MVC pattern;

![MVCPattern]({{site.baseurl}}/images/designpattern.jpg)

The Model-View-Controller pattern highly supports the separation of concerns. This advantage not only increases the testability of the code but it also makes it easier to extend, allowing a fairly easy implementation of new features. It also supports rapid and parallel development which we needed becuase of the tight deadlines of our delieverables we had to work in parallel.

## Software Implementation & UI:
-----------


### Coding Conventions:

Coding Covention helps different developers working in the same team to read through each other codes and also following these conventions helps in developing a clean code which make it easier for maintenance and enhance its efficiency. Coding convention that is followed through out in 405-Found are Java Code Conventions (by Oracle) - as the software is developed using Java Language so it makes sense to follow them. 


Some of the Examples from the Coding Conventions and related code fragments from our project are as follows;

1) The convention states that files in the program should not exceed 2000 lines 

- Every class in our program is less than 500 lines.

2) Naming convention states that each class in the program should follow, CamelCasing. Meaning, first letter of each internal word capitalized.

- Every class in our program followed CamelCasing rule. e.g: Categories, DatabaseHelper.

3) The if and if-else statements according to coding convention should be stated as 


if  (condition) { 
   
   statements;  
   
   }
       
       
if  (condition) { 
   
   statements; 
  
  } else {
  
  statements;
  
  }
    
    
 - an example from our code is;
 
 ![MVCPattern]({{site.baseurl}}/images/CodeExample.JPG)


[You can have a look at the full Java Coding Convention, HERE](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf)


As the team is working in parallel it gets very important for everyone to follow a style of code development that is standard throughout, for this reason everytime a new development in terms of coding is done in the application it is reviewed by the SCRUM MASTER of our team. It enables us to keep a strict check that the coding conventions are not violated throughout our code. 


### Context of Use - Personas
Identify the people who will use the application by developing at least two personas 

Example 1

Example 2


### Create Design Solution
Provide a storyboard (i.e., a sequence of screens) for at least two user stories) together with a brief explanation
• What was the rationale of your chosen design? Based on which principles did you design your App?


## Summary of Changes:
----------

 
| Requirements Sprint 1		| Requirements Sprint 2		|
| -------------------------|:-----------------------:	| 
| col 3 is      		   	| right-aligned 		   	|
| col 2 is      		   	| centered      		   	|
| zebra stripes 			   | are neat     			   |  




## Working Prototype
-----

Screenshots of Application


Please find the downloadable application link here: Download

---------

> With every sprint we are getting closer to our goal and also completing our project. I hope you have enjoyed reading our journey of the Third Sprint. See you soon, AGAIN!!! (in the next ONE)
