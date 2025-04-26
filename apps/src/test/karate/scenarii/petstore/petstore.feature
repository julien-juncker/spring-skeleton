Feature: Petstore

  Background:
    * url baseUrl
    * def petsPath = '/api/v1/pets'

  Scenario:
    Given path petsPath
    When method GET
    Then status 200
    And match response == [{"name":"Helios","type":"Cat","age":3},{"name":"Fluffy","type":"Dog","age":4}]