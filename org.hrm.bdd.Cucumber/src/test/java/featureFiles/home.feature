
Feature: Home page 

Background:
	Given username and password and perform login operation 
 
 	@smoke
   Scenario: verify the home page is visible or not 
   Given 	Dashboard name should be displayed 
   
   @smoke @regression
   Scenario: verify user is able to click on admin option  
   When  	click on admin 
   
   @regression
   Scenario: verify user is able to click on Pim option 
   When 	click on Pim
   
   
   