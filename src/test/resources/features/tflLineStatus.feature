Feature: Get tube Status of lines in London
    As a traveller
    I want to get status of all tube trains
    So that i plan my journey

  @test
  Scenario: Get status of all the lines
      Given I send request to get all the status
      Then I should see 200 response from the service
      And I should see status of following lines
          | jubilee  |
          | central  |
          | northern |
          | elizabeth|
