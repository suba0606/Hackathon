Feature: Testing zigwheels Website

  Scenario: Testing Identify New Bikes Module in Chrome Browser
    Given user is on zigWheels.com website
    Then navigate to upcoming bikes
    Then information of upcoming bikes

  Scenario: Testing Popular models of Cars
    Given used cars and chennai is on the page
    Then show popular models
    
    Scenario: UnSucessfull login
    Given click on login and google
    Then enter the value of email
    Then click on next page 
   
    
