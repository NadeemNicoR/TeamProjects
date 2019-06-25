![companylogo]({{site.baseurl}}/images/405logo.png)
   
# Beta Prototype and Testing

<br>

<p class="justify">

Welcome to the fourth blog of team 405 Found - Money Control Application. In this blog we will give an overview of how we have put our application to test and the testing methods that we have used.

</p>

<br>

## Testing Process

<p class="justify">

Since the beginning for us it was very important that our application should bring the value that it promises. Hence we always make sure it works properly to ensure great customer experience. Among the processes of building an application, testing plays a very important part.

</p>

<br>

<p class="justify">

Test phases according to the The Common V-Model are:

</p>

- Unit Testing

- Integration Testing

- System Testing

- Acceptance Testing

<br>

Two methods of testing are *White BoxTesting* and *Black Box Testing*.



- Black Box Testing is a software testing method in which testers evaluate the functionality of the software without knowing the internal code structure.

- White Box Testing is a software testing method in which testers evaluate the methods of each class of the software application knowing the internal code structure.

For each of the phases we have used the following testing methods:

*Unit Testing* : For this phase we used White Box Testing. We developed JUnit Test Cases for each class, testing the methods used. 

*Integration Testing* : For the second phase we used Black Box Testing to test if the communication between components works.

*System Testing* : For this phase the app was tested from the customer's point of view. We tested our app in two different Android Versions, which are; Oreo 8.0 and Marshmallow 6.0.

*Acceptance Testing* : In the final phase we showed the application to our customer and received his review and opinion about the app until now. We used Black Box Testing for this phase.



<br>



## Black Box Testing

<p class="justify">

For this approach we tested 5 functionalities manually and the details are shown below:

</p>

<br>

![Testcase1]({{site.baseurl}}/images/Black_Box_Testing.png)


<br>




## White Box Testing


<p class="justify">

For this approach we tested methods from 5 classes of our application and the details are shown below:

</p>

**Test Case - 01**


<p class="justify">

In this test case we have tested the "addData()" method inside Transactions.java class, using the branch coverage technique.
</p>

![Testcase1]({{site.baseurl}}/images/WhiteBox1.PNG) ![Testcase1]({{site.baseurl}}/images/WhiteBox1S.PNG)


**Test Case - 02**

<p class="justify">
   
In this test case we have tested the "delete_Data_C()" method inside Categories.java class, using the branch coverage technique.

</p>

![Testcase2]({{site.baseurl}}/images/WhiteBox2.PNG) ![Testcase2]({{site.baseurl}}/images/WhiteBox2S.PNG)


**Test Case - 03**

<p class="justify">

In this test case we have tested the "onCreate()" method inside MainActivity.java class, using the statement coverage technique.

</p>

![Testcase3]({{site.baseurl}}/images/WhiteBox3.PNG) ![Testcase3]({{site.baseurl}}/images/WhiteBox3S.PNG)


**Test Case - 04**


<p class="justify">

In this test case we have tested the method "onCreate()" from the LogInScreen.java class, using the branch coverage technique.

</p>

![Testcase4]({{site.baseurl}}/images/WhiteBox4.PNG) ![Testcase4]({{site.baseurl}}/images/WhiteBox4S.PNG)


**Test Case - 05**

<p class="justify">
   
In this test case we have tested the "viewData()" method inside TransactionReport.java class, using the branch coverage technique.

</p>

![Testcase5]({{site.baseurl}}/images/WhiteBox5.PNG) ![Testcase4]({{site.baseurl}}/images/WhiteBox5S.PNG)


<br>


## Summary of Changes

<br>



Key changes that we have done in our application:

- Combined the income and expense classes into a transaction class. User can choose the transaction type from a drop down list.

- Developed pie and bar charts that can be filtered by categories, amount and date to give a better visualization of user's spending.

- Entered the enable pin toggle button in settings.


The changes that we have done in this sprint can be seen highlighted on UML Class diagram below.



<br>

![UML]({{site.baseurl}}/images/UML_BetaPrototype.png)

Take a look at our **Beta Prototype**.

![StoryBoard]({{site.baseurl}}/images/StoryBoard44.jpg)


![StoryBoard]({{site.baseurl}}/images/StoryBoard55.jpg)


![StoryBoard]({{site.baseurl}}/images/StoryBoard66.JPG)


<br>



*We are close to the end line of our project. We will catch up with you again in the next and last blog in a week :) 
We hope you have enjoyed reading about our journey till here. See you soon, AGAIN!!! (in a next ONE).*
 

 

