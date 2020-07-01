Feature: Pet futures


  Scenario: Pet scenarios

    When user creates a pet with 1202, "Gresha", "available"
    Then the status code is "200";
    And pet with 1202, "Gresha", "available" is created


