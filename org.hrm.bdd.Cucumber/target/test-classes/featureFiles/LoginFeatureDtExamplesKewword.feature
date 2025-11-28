
Feature: Login feature

  Scenario Outline: 
  verify login feature is working with valid credentials or not 
  
  Given Launch the given bowser with the given URL and maximize the window
    Given Provide valid "<username>" and "<password>"
    And click on the login button
  
  
    Examples: 
      | username  | password |
      | Admin | admin123 |
      | admin | admin456 |
