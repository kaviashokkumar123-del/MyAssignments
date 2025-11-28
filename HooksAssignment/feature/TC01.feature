Feature: Login functionality for LeafTaps application

#Background:
#Given launch the browser and load the URL

Scenario: Login with valid credentials
When Enter the username as 'DemoSalesManager'
And Enter the password as 'crmsfa'
And click on Login
Then Homepage is displayed

Scenario: Login with invalid credentials
When Enter the username as 'DemoSales'
And Enter the password as 'crmsfa'
And click on Login
But Error msg should be displayed