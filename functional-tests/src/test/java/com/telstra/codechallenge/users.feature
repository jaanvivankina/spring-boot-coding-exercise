# See
# https://github.com/intuit/karate#syntax-guide
# for how to write feature scenarios
Feature: As an api user I want to retrieve the oldest git accounts with zero followers.

  Scenario: Get zero follower users
    Given url microserviceUrl
    And path '/users'
    When method GET
    Then status 200
    And match header Content-Type contains 'application/json'
    # see https://github.com/intuit/karate#schema-validation
    # Define the required schema
    * def userSchema = { login : '#string', id : '#number', html_url : '#string' }
    # The response should have an array of 3 repo objects
    And match response == '#[3] userSchema'