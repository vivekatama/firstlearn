
Feature: Login feature

  Scenario Outline: 
  verify login feature is working with valid credentials or not 
  
  Given Launch the given bowser with the given URL and maximize the window
  Given Provide valid username and password  
  
   | username | password |
  		| Admin | admin1234|
      | Admin | admin123 |
    And click on the login button
  
  
      