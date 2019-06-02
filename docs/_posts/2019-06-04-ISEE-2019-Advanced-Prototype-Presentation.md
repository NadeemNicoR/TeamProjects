![companylogo]({{site.baseurl}}/images/405logo.png)

<h1 text-aline="center"> Advanced Prototype </h1>

Welcome to the third blog post of 405 Found - Money Control Application. It will give you an update on the 3rd Milestone that we have achieved in our project also how our basic prototype application has been evolved with the new requirements that has been added by our customers into a final Advanced prototype.

Without further ado, Lets Start...


<h2> Using a particular Software Design Pattern and the reasons behind it!  </h2>
---------------
<p class="justify">
 
 
 In Software development world, design pattern is referred to as a general repeatable solution to a commonly occuring problem in your software design. A design pattern isn't a finished design that can be transformed directly into code. It is a description or template for how to solve a problem that can be used in many different situations.
 
 
 The design pattern, that we are using in our Money Control- Application is "Model-View-Controller (MVC)" design pattern, which specifies that an application consist of a data model, presentation information, and control information.
  
  
 Lets first know what Model, View and Controller means in MVC pattern and then we can move to an example on how this concept in used in our Application.


* The Model contains only the pure application data, it contains no logic describing how to present the data to a user.

* The View is the UI layer — it does visualisation of the data from the Model.

* The Controller exists between the view and the model. It is the logic layer, gets notified of the user’s behavior and updates the Model as needed.


The MVC implemented in our application development has, the model represented by DataBaseHelper class in our apaplication that stores all the data and manipulation methods, which is further linked with MainActivity class surving as Controller, linked to all activity classes which are the view. A graphical respresentation of the MVC pattern;

 
![MVC pattern]({{site.baseurl}}/images/designpattern.PNG)



<h2> IMPLEMENTATION & UI: </h2>



<h2> Coding Conventions </h2>

<p class="justify">
 
• report on coding standards you apply (e.g., JavaSoft conventions, own conventions)
• How do you enforce that all code adheres to your coding conventions? 



</p>

<h2> Specify Context of Use  </h2>


<p class="justify">
 
identify the people who will use the application by developing at least two personas 


</p>

<h2> Create Design Solution  </h2>


<p class="justify">
 
 provide a storyboard (i.e., a sequence of screens) for at least two user stories) together with a brief explanation
• What was the rationale of your chosen design? Based on which principles did you design your App?

</p>

<h2> Summary of Changes: </h2>


<p class="justify">
 
• Which requirements (compared to the basic prototype) did you add or change?
• Reflect on how these added/changed requirements have changed your (a) user
stories and (b) class diagram 

</p>

<h2> Working Prototype (this is not required in the presentation, but in the Blog
article): </h2>


<p class="justify">
 
• Make a working prototype available as (a) downloadable apk file and (b) as a
separate release branch in the git repo
• add screenshots (2 or more) of your app with a brief explanation what they are
about

</p>
