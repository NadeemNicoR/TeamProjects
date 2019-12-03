   ![companylogo]({{site.baseurl}}/images/405logo.png)

# Advanced Prototype 

<br>

<p class="justify">
   
Welcome to the third blog post of 405 Found - Money Control Application. It will give you an update on the 3rd Milestone that we have achieved in our project. Also how our basic prototype application has been evolved with the new requirements that has been added by our customer into a final advanced prototype.

</p>

<br>


Without further ado, Lets Start...

## Using a particular Software Design Pattern and the reasons behind it:  
-----------

<br>

<p class="justify">
   
In software development world design pattern is referred to as a general repeatable solution to a commonly occurring problem in your software design. A design pattern isn't a finished design that can be transformed directly into code. It is a description or template for how to solve a problem that can be used in many different situations.

</p>

<br>

<p class="justify">

The design pattern, that we are using in our Money Control- Application is Model-View-Controller (MVC) design pattern, which specifies that an application consist of a data model, presentation information, and control information.

</p>
<br>
<p class="justify">

Let's first know what Model, View and Controller means in MVC pattern and then we can move to an example on how this concept in used in our Application.

</p>
<br>

• The Model contains only the pure application data. It contains no logic describing how to present the data to a user.

• The View is the UI layer. It does visualisation of the data from the Model.

• The Controller exists between the view and the model. It is the logic layer, gets notified of the user’s behavior and updates the Model as needed.

<br>
<p class="justify">

The MVC implemented in our application development has, the model represented by DataBaseHelper class in our application that stores all the data and manipulation methods. That is further linked with MainActivity class surving as Controller, linked to all activity classes which are the view. A graphical respresentation of the MVC pattern:

</p>
<br>

![MVCPattern]({{site.baseurl}}/images/designpattern.jpg)

<br>
<p class="justify">

The Model-View-Controller pattern highly supports the separation of concerns. This advantage not only increases the testability of the code but it also makes it easier to extend, allowing a fairly easy implementation of new features. It also supports rapid and parallel development which we needed because of the tight deadlines of our delieverables we had to work in parallel.

</p>
<br>

## Software Implementation & UI:
-----------


## Coding Conventions:

<br>
<p class="justify">

Coding covention helps different developers working in the same team to read through each other´s codes. Following these conventions helps also in developing a clean code which make it easier for maintenance and enhance its efficiency. Coding convention that is followed through out in 405-Found are Java Code Conventions (by Oracle) - as the software is developed using Java Language so it makes sense to follow them. 

</p>
<br>

Some of the Examples from the Coding Conventions and related code fragments from our project are as follows:

1) The convention states that files in the program should not exceed 2000 lines. 

*Every class in our program is less than 500 lines.*

2) Naming convention states that each class in the program should follow CamelCasing. Meaning first letter of each internal word is  capitalized.

*Every class in our program followed CamelCasing rule. e.g: Categories, DatabaseHelper.*

3) The if and if-else statements according to coding convention should be stated as:


if  (condition) 
{ 
   statements;     
   }
             
if  (condition) 
{    
   statements; 
  } 
  else 
  {  
  statements;  
  }
    
 
 *an example from our code is:*
 
 ![CodeExample]({{site.baseurl}}/images/CodeExample.JPG)


<span style="color:#0000FF">[You can have a look at the full Java Coding Convention, HERE](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf)</span>

<br>
<p class="justify">

As our team is working in parallel it gets very important for everyone to follow a style of code development that is standard throughout. For this reason everytime a new development in terms of coding is done in the application, it is reviewed by the SCRUM MASTER of our team. It enables us to keep a strict check that the coding conventions are not violated throughout our code. 

</p>
<br>

## Context of Use - Personas

<br>
<p class="justify">

Customer Personas are fictional generalisations of our most valuable customers. They help to understand customers by bringing together demographic information like age, gender, location, and income, alongside psychographic information like interests, frustrations and personal/professional motivations.

</p>
<br>
<p class="justify">

Understanding our customer needs, challenges and behavioural influences allows us to better understand what content appeal to them best. A lot of thought goes into developing persons in software development process.

</p>
<br>

The discovery question that we focused on to built our personas are as follows:

1) Location: where do people from this persona live?

2) Age: what is the average age/age range of this persona?

3) Relationship Status: Single? Married? Children?

4) Education: what level of education do they have?

5) Frustrations: the biggest challenges for people in this persona?

6) Motivations: what motivates people in this persona to be successful?

7) Personal/Professional Goals: what do they wish to achieve?


The persona that we have developed are:



![PersonaDevelopment]({{site.baseurl}}/images/Persona11.jpg)


![PersonaDevelopment]({{site.baseurl}}/images/Persona22.jpg)


## Story Board 

Here in the Story board we will potray how our app transitions through two of the user stories/scenarios. Are you ready?

Lets have a look.

**1. PIN activation screen sequence:**

![StoryBoard1]({{site.baseurl}}/images/StoryBoard1.1.png)

![StoryBoard1]({{site.baseurl}}/images/StoryBoard11.png)


In this picture you can see a journey of a user when he opens an app and wants to save a PIN for the future access of the app.


**2. Email Summary screen sequence:**

![StoryBoard2]({{site.baseurl}}/images/StoryBoard2.1.png)

![StoryBoard2]({{site.baseurl}}/images/StoryBoard22.png)


Above picture depicts how a user can send/share a summary of all his/her transactions for the month through email.


## Design Principles

<br>
<p class="justify">

Design Principles are fundamental points of advice for making easy-to-use, pleasurable designs as we select, create and organize elements and features in our work. The design principles that we have followed to use to develop our app are *"Andriod Design Principles"*, developed by and for the Android User Experience Team to keep users' best interests in mind.

</p>
<br>
<p class="justify">

We have applied as many principles as we could to our project. The goal is to develop an app that is widely loved by a variety of users.

</p>
<br>
<p class="justify">

<b>Keep it brief:</b> Throughout our application we have used short phrases and simple words. People are likely to skip sentences if they're long and get frustrated if they don't know at the end what action they need to take or when encountering an error what that error really mean.

</p>
<br>
<p class="justify">

<b>Let me make it mine:</b> People love to add personal touches because it makes them feel at home and in control. We have provided sensible, beautiful defaults, in our categories section but also considered optional customizations that can be done by the user that doesn't hinder primary tasks.

</p>
<br>
<p class="justify">

<b>Decide for me but let me have the final say:</b> Taking your best guess and act rather than asking first we have made our app to be able to open without a PIN. Too many choices and decisions make people unhappy. Just in case user needs the app security, we have kept an option to enable the PIN.

</p>
<br>
<p class="justify">

<b>Do the heavy lifting for me:</b> This features has been incoporated in our app by providing the user with drop down lists and date and time pickers which will not only restrict the user to put in the right values in right formats in the app but will also make it easier for them to log in the data.

</p>
<br>

## Summary of Changes:
-----------

<br>
<p class="justify">

The illustration below depicts the requirements for the first epic-user story as well as the second. It needs to be mentioned that, among the second set of user stories there are new requirements and changed requirements.

</p>
<br>


![Requirements]({{site.baseurl}}/images/Requirements.png)


<br>
<p class="justify">

To remark the previously mentioned changes, we decided to show the most explicit one, which is related with the use of a PIN in order to enter the application.

</p>
<br>

Before the change:

![UserStoryChange]({{site.baseurl}}/images/US_Bef.png)

After the change:

![UserStoryChange]({{site.baseurl}}/images/US_Bef.png)

<p class="justify">
   
Since the changes and the new requirements influenced the structure of the application itself, the best way to visualize them is by using the class diagram. There the most significative changes (Class level) have been especified.

</p>

![UserStoryChange]({{site.baseurl}}/images/ClassDiagram.png)

## Working Prototype
-----

Have a look at our advanced prototype and some key features of Sprint 3:



![AdvancedPrototype]({{site.baseurl}}/images/AdvancedPrototype2.1.png)


![AdvancedPrototype]({{site.baseurl}}/images/AdvancedPrototype2.png)



Please find the downloadable application link here: https://github.com/DBSE-teaching/isee2019-405-Found/blob/master/MoneyControl_AdvancedPrototype.apk

---------

<br>
<p class="justify">

 With every sprint we are getting closer to our goal and also completing our project. I hope you have enjoyed reading our journey of the Third Sprint. See you soon, AGAIN!!! (in a next ONE).

</p>
