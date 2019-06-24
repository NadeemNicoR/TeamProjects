![companylogo]({{site.baseurl}}/images/405logo.png)
   
# Beta Prototype and Testing

<br>

<p class="justify"/>

Welcome to the fourth blog of team 405 Found - Money Control Application. In this blog we will give an overview of how we have put our application to test and the testing methods that we have used.
<br>

<p class="justify"/>

Since the beginning for us it was very important that our application should bring the value that it promises. Hence we always make sure it works properly to ensure great customer experience. Among the processes of building an application, testing plays a very important part.
<br>

<p class="justify"/>

Test phases according to the The Common V-Model are:

- Unit Testing
- Integration Testing
- System Testing
- Acceptance Testing

Two methods of testing are *White BoxTesting* and *Black Box Testing*.

- Black Box Testing is a software testing method in which testers evaluate the functionality of the software without knowing the internal code structure.

- White Box Testing is a software testing method in which testers evaluate the methods of each class of the software application knowing the internal code structure.

For each of the phases we have used the following testing methods:

*Unit Testing* : For this phase we used White Box Testing. We developed Junit Test Cases for each class, testing the methods used. 

*Integration Testing* : For the second phase we used Black Box Testing to test if the communication between components works.

*System Testing* : For this phase the app was tested from the customer point of view. We tested our app in two different type of Android Versions as Oreo 8.0 and Marshmallow 6.0.

*Acceptance Testing* : In the final phase we showed the application to our customer and received his review and opinion about the app until now. We used Black Box Testing for this phase.

<br>

<p class="justify"/>


## Black Box Testing


For this approach we tested 5 functionalities manually and the details are shown below:


![Testcase1]({{site.baseurl}}/images/Black_Box_Testing.png)


<br>

<p class="justify"/>


## White Box Testing


For this approach we tested methods from 5 classes of our application and the details are shown below:


**Test Case - 01**

In this test case we have tested the arePinsSame() method inside EnablePin.java class, using the scenario when both PIN match.


![Testcase1]({{site.baseurl}}/images/JunitTestEnablePin1.JPG)


**Test Case - 02**

In this test case we have tested the isValidEmail() method inside EmailReport.java class, using the scenario of entering a correct and wrong e-mail.


![Testcase2]({{site.baseurl}}/images/JunitTestEmailReport1.JPG)


**Test Case - 03**

In this test case we have tested the isDateValid() method inside NewExpense.java class, using the scenario of entering a correct and wrong date format.


![Testcase3]({{site.baseurl}}/images/JunitTestDateFormat1.JPG)


**Test Case - 04**

In this test case we have tested the method insertCategories() from the DatabaseHelper.java class.


![Testcase4]({{site.baseurl}}/images/JunitTestDatabaseHelp1.JPG)


**Test Case - 05**

In this test case we have tested the showMessage() method inside Budget.java class.


![Testcase5]({{site.baseurl}}/images/JunitTestBudgetShowMessage1.JPG)


<br>

<p class="justify"/>

## Summary of Changes

<br>

<p class="justify"/>

Key changes that we have done in our application:

- Combined the income and expense class into one and made a transaction class. User can choose the transaction type from a drop down list.

- Developed pie and bar charts that can be filtered by categories, amount and date to give a better visualization of user's spendings.

- Entered enable pin toggle button in settings.


The changes that we have done in this sprint can be seen through UML Class diagram below.

![UML]({{site.baseurl}}/images/UML_BetaPrototype.png)

Have a look at our **Beta Prototype**.

![StoryBoard]({{site.baseurl}}/images/StoryBoard44.jpg)


![StoryBoard]({{site.baseurl}}/images/StoryBoard55.jpg)


![StoryBoard]({{site.baseurl}}/images/StoryBoard66.JPG)


<br>

<p class="justify"/>

*We are almost near the finishing line of our project. We will catch you again in the next and last blog in a week :) 
We hope you have enjoyed reading about our journey till here. See you soon, AGAIN!!! (in a next ONE).*
 
<br>

<p class="justify"/>
