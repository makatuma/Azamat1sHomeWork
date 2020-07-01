Feature: Validation of headers

  Scenario: Validation of new order headers
    Given the demoUser enters username "Tester"
    When the demoUser enters password "test"
    Then the user goes to the new order page
    And the user validate the product headers
      | Product:* 		|
      | Quantity:* 		|
      | Price per unit: |
      | Discount: 		|
      | Total: 			|
  * the user validate the address headers
      |Customer name:*|
      |Street:*       |
      |City:*         |
      |State:         |
      |Zip:*          |
    # Task using datatable validate the header for address information
    # Create new step for this scenario and validate the headers for address