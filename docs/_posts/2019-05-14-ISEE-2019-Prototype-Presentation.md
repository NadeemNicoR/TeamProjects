![companylogo]({{site.baseurl}}/images/405logo.png)

# Basic Prototype

## Essential requirements
---



### Requirement Gathering

  <br /> 
  
![requirementGanthering]({{site.baseurl}}/images/RequirementGathering.jpg)

 <br /> 
 
During the weekly team meetings, every question formulated for a team member was collected, after that, we processed them into a meeting agenda, which was a powerful tool that helped us to make the correct questions that later could be clarified by the customer.

The customer was pretty sure about the requirements he had, and the fact he managed to split them into "Required" and "Nice to have" helped us to establish priorities for the user stories, here we also mention some ideas we had for the project that were easily assigned to one of the previously mentioned categories.



### Wrong assumptions identification

  
  <image class="center">
  
  ![requirememtAnalysis]({{site.baseurl}}/images/RequirememtAnalysis.png)
 
    
  </image>


Taking as a starting point the fact that not all the requirements are gathered since the beginning, and also that some of them are going to inevitably change, we tried to involve our customer as much as possible in the phase of requirement processing, this way he could see and make an early correction of every aspect that wasn't an actual requirement.
 
  
  <br /> 

![ExUserStory2]({{site.baseurl}}/images/ExUserStory2.png)

<br /> 
Even though, we have as a principle to work only on what is a requirement from our customer, we couldn't avoid to come across with some features that we thought were necessary to satisfy one of the requirements, we dealt with these assumptions remaking them within the respective user story that was later explained to the customer, so that he could approve or dismiss them. One example for this was the assumption of having a user account that can be used to log in on different devices, while the desire of the client was to have a PIN that could be used to access the application.

### Use case diagram 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![Usercasediagram]({{site.baseurl}}/images/Usercase_newest1.png)  

<br /> 

This diagram depicts the in high level the interactions that the user can have with the application, among them; **"Enter PIN"** used to get access to the application, which must be verified, **"Enter expense"** necessary to register the expenditure information, **"Enter income"** where the user must detail his/her incomes, **"Check dashboard"** used to monitor the user's finances, and **"Change settings"** where the user can establish preferences for the system.


### User Stories (Excel map pic)

In order to write the user stories, we took the requirements expressed by the customer using the "I need" phase, and turned them into small pieces of work expressed using the format *" as a [type of user], I want to [perform some task], so that I can [achieve some goal]"*; and for that goal we established some acceptance criteria that should be fulfilled in order to the user story to be complete.<br /> 

![UserStoriesManagement]({{site.baseurl}}/images/UserStoriesManagement_newest1.png)  

## System design
---

### Class Diagrams
  <br /> 
  
![ClassDiagram]({{site.baseurl}}/docs/images/Blank%20Diagram.png)

 <br /> 
 
The UML Class Diagram of our Money Control App has following main classes; User, Income, Expense, Settings and Manager Class. 
The User class, takes in input from user such as its Name, Email and it allows the user to set a PIN which he/she can use whenever they want to log into the account after the first use (or registration).
The Income Class, lets the user to define a Income and set its recurrence if needed. 
The Expense Class, will allow the user to set/enter a new expense and the date whenever it occurred also it will let the user define the method of payment, currency and the category of the expense.
The Settings Class, lets the user with the help of other classes of Currency, Method of Payment, Category, to define a new or edit a previous value in the mentioned class it also allows the user to set a new pin for the application access. 
The Manager class has a number of methods which will allow the user to insert, update and delete operation of all other classes. Every class is contained by the manager class and no class will exist if the manager class doesn’t exist. Manager class also allows us to get the statistics defined on a specific period and class type. 


### Activity Diagrams

### Development Strategy
Since the beginning of the project we decided to use the tool Asana in order to keep track of tasks and also to divide the work between the team members, which will lead us to know who is doing what so that we can exchange roles in a fair way, additionally to that we also use the estimated times for the user stories and compare them to the actual times that we spent on every user story, with which we will make better estimations for the future, and also establish a project development speed in order to know; whether the project is going to be ready on time, or if we have to speed up the development process, or else we are doing great and we will have time to add some nice-to-have features at the end.
