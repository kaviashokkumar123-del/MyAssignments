Feature: Edit the Account in the salesforce application 
@Smoke
Scenario: Edit the existing account details 

	Given Launch the browser and open the URL 
	When Enter the username 'kaviashokkumar123118@agentforce.com' 
	When Enter the password 'Kalai12#Arvind' 
	And Click on Login button 
	And Click on the App Launcher Icon next to Setup 
	And Search for the account. 
	And Click on the drop down. 
	And Select Edit button 
	And Select Type value as 'Technology Partner' 
	And Select Industry value as 'Healthcare' 
	And Enter the Billing Address 'No: 8/19, Bajani Street' 
	And Enter the Shipping Address 'No: 8/19, Test Street' 
	And Select Customer priority as 'Low' 
	And Select SLA as 'Silver' 
	And Select Active as 'No' 
	And Enter Unique Phone number '7658943789' 
	And Select upsell Opportunity as 'No' 
	And Click on Save button 
	Then Verify Phone number 
