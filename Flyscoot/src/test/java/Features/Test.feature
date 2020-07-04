Feature: Flyscoot

  Scenario Outline: Make booking
    Given Open the browser
    And Enter the URL
    And Select the flight details "<flighttype>"
    When Enter the origin "<origin>" and  destination "<destination>"
    And Enter the date of booking "<date>" 
    And Select number of travellers adult "<adult>", child "<child>", infant "<infant>"
    And click on search
    And Select the flight
    And Click on next page button
    Then Keen title "<title>" , first name "<firstname>" , last name "<lastname>" , DOB "<DOB>" ,nationality "<nationality>" ,
    And Click on continue payment button
    And Enter contact details
    And Keen streetaddress "<streetaddress>", country "<country>", city "<city>", postal "<postal>",
    And Select payment method cardnumber "<cardnumber>", expirationdate "<expirationdate>", cardholdername "<cardholdername>", ccv "<ccv>"

    #Then Close the browser
    Examples: 
      | origin | destination | date           | title | firstname | lastname | DOB      | nationality | streetaddress | country | city      | postal    | cardnumber       | expirationdate | cardholdername | ccv |
      | SIN    | KUL         | 20 August 2020 | Ms    | Nidhi     | Mittal   | 1-1-1992 | India       | test address  | India   | Karnataka | Karnataka | 5149000000000001 | 01-21          | Test           | 123 |

      
  Scenario Outline: Make new booking with multiple passengers
  Given Open the browser
  And Enter the URL
  When Enter the origin "<origin>" and  destination "<destination>" click on search
  
  