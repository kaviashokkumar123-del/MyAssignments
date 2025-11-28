Feature: editLead functionality for Leaftaps application

#Background:
#Given launch the browser and load the URL

Scenario Outline: edit lead for multiple data
When Enter the username as 'DemoSalesManager'
And Enter the password as 'crmsfa'
And click on Login
And click on crmsfa link
And click on leads button
And click on Find leadLink
And click on phone tab
And enter the phone number as <phoneNumber>
And click Find leads button
And click on the first element that was found
And cliik on edit button
And Update the company Name to <companyName>
And click on submit button

Examples:
|phoneNumber|companyName|firstName|lastName|
|8939299360|infosys|Arun|S|
|8939299361|CTS|uma|R|
|8939299362|TCS|nivedhitha|S|
