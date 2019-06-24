![companylogo]({{site.baseurl}}/images/405logo.png)
   
# Beta Prototype and Testing

<br>

<p class="justify"/>

Welcome to the fourth blog of team 405 Found - Money Control Application. In this blog we will give an overview of how we have put our application to test and the testing methods that we have used.
<br>

<p class="justify"/>

Since the beginning for us it was very important that our application should bring the value that it promises. Hence we always make sure it works properly to ensure great customer experience. Among the processes of building an application, testing plays a very integral part. It checks if the apps graphics are aligned properly, tests the main functionality, checks if menus are intuitive, etc. When making changes according to customer requirements, we faced problems with the methods and their functionalities. This is where testing came in to work. It helped finding bugs, defects and fixing them.
<br>

<p class="justify"/>


If we look into a more technical definition of software testing, according to ANSI/IEEE 1059 standard Software testing is a process of analyzing a software item to detect the differences between existing and required conditions (i.e., defects) and to evaluate the features of the software item.
<br>

<p class="justify"/>

Two classifications of testing are *White BoxTesting* and *Black Box Testing*. For testing our application we have used both of them.
<br>

<p class="justify"/>


## Black Box Testing

Black Box Testing is a software testing method in which testers evaluate the functionality of the software without knowing the internal code structure.

For this approach we tested 5 functionalities manually and the details are shown below:

**Test Case - 01**

![Testcase1]({{site.baseurl}}/images/TC1.JPG)


**Test Case - 02**

![Testcase2]({{site.baseurl}}/images/TC2.jpg)


**Test Case - 03**

![Testcase3]({{site.baseurl}}/images/TC3.jpg)


**Test Case - 04**

![Testcase4]({{site.baseurl}}/images/TC4.jpg)


**Test Case - 05**

![Testcase5]({{site.baseurl}}/images/TC5.jpg)


<br>

<p class="justify"/>


## White Box Testing

White Box Testing is a software testing method in which testers evaluate the methods of each class of the software application knowing the internal code structure.

For this approach we tested methods from 5 classes of our application and the details are shown below:

**Test Case - 01**

![Testcase1]({{site.baseurl}}/images/JunitTestEnablePin1.JPG)

In this test case we have tested the arePinsSame() method inside EnablePin.java class, using the scenario when both PIN match.


**Test Case - 02**

![Testcase2]({{site.baseurl}}/images/JunitTestEmailReport1.jpg)

In this test case we have tested the isValidEmail() method inside EmailReport.java class, using the scenario of entering a correct and wrong e-mail.


**Test Case - 03**

![Testcase3]({{site.baseurl}}/images/JunitTestDateFormat1.jpg)

In this test case we have tested the isDateValid() method inside NewExpense.java class, using the scenario of entering a correct and wrong date format.


**Test Case - 04**

![Testcase4]({{site.baseurl}}/images/JunitTestDatabaseHelp1.jpg)

In this test case we have tested the method insertCategories() from the DatabaseHelper.java class.


**Test Case - 05**

![Testcase5]({{site.baseurl}}/images/JunitTestBudgetShowMessage1.jpg)

In this test case we have tested the showMessage() method inside Budget.java class.


<br>

<p class="justify"/>

## SUMMARY OF CHANGES

<br>

<p class="justify"/>


The changes that we have done in this sprint can be seen through UML Class diagram below.


*Please insert uml class diagram here*
![UML]({{site.baseurl}}/images/UML_BetaPrototype.png)

Key changes that we have done in our application:

- Combined the income and expense class into one and made a transaction class. User can choose the transaction type from a drop down list.

-  Developed pie and bar charts that can be filtered by expense type and categories to give a better visualization of user's spendings.

- Entered enable pin toggle button in settings.

- Developed budget class which will enable user to set a budget per category for his/her spendings.

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
