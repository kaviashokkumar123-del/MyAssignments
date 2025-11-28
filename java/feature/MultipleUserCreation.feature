Feature: create multiple account user functionality for Salesforece application 

Background: 
	Given Launch the browser and open the URL 
	
@Regression
Scenario Outline: multiple account user creation 

	When Enter the username 'kaviashokkumar123118@agentforce.com' 
	When Enter the password 'Kalai12#Arvind' 
	And Click on Login button 
	And Click on the App Launcher Icon next to Setup 
	And Search for the account. 
	And Click on New button to add new account user 
	And Enter the Account Name <AccountName> 
	And Click on Save button 
	Then Verify User Created Successfully  <AccountName> 
	
	Examples: 
		|AccountName|
		|FirstName|
		