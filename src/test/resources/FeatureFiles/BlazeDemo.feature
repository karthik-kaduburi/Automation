@BlazeDemo-Feature
Feature: Acceptance testing to validate the flight booking process on BlazeDemo page with form fields entry and
the response of the page based on appropriate inputs
  

  @flight-booking
  Scenario Outline: Enter required form fields and verify the confirmation id
    Given I am on the Home Page "<url>" of "BlazeDemo" Website
    When I enter the "departure and destination city" on "<page>"
      | depCity				|<depCity>		|
      | desCity				|<desCity>		|
   When clicked on "findFlights" link
   Then I choose the "flightWithDetails" on "<page>"
      | airlineName		|<airlineName>|
      | flightId  		|<flightId>		|
   And I enter the "details" on "<page>"
      | name					|mickey				|
      | address				|H No 2/21		|
      | city					|Portland			|
      | state					|NA						|
      | zipCode				|90001				|
      | cardType			|American Express|
      | credCardNo		|12323212233	|
      | month					|12						|
      | year					|2022					|
      | nameOnCard		|Mickey				|   
    When clicked on "purchaseFlight" link
    Then verify the "info" displayed on "confirmationPage"
    	| id						|notNull			 |
    	| status				|PendingCapture|
    Examples:
    |url									 |page			|depCity	|desCity|airlineName		|flightId|
    |https://blazedemo.com/|BlazeDemo |Portland	|Berlin |Virgin America |43|
  
  