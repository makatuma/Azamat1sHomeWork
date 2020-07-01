Feature: Slack Future

  Scenario: Slack Scenarios

    Given send message to slack via POST request
    And verify the message via GET request

    When the user sends message to slack via POST request
    And the user verifies the message with Selenium Webdriver in UI


    When the user sends message to slack with Selenium Webdriver in UI
    Then the user verifies the message via GET request


    Given delete message from slack via POST request
    And verify the message is gone via GET request


     When the user deletes the message from slack via POST request
     Then  Verify the message is gone via Selenium Webdriver in UI
