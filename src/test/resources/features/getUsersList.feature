Feature: Get all the available users list
    As a customer
    I want to get list of all the users list
    So that i get all the information about users

  Scenario: Get UserLists
      Given I send GET request to the Server
      Then I should see 200 response from the Server
      And I should receive all the user information
      And I should see an User with name "Maxime_Nienow"


  Scenario: create NewUser
      Given I create a new User
      Then I should see 201 response from the Server
      
