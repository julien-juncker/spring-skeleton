Feature: Petstore

  Background:
    * url baseUrl
    * def petstorePath = '/api/v1/petstore/pet'
    * configure headers = {'Content-Type':'application/json'}

    * table addressToCreate
      | number | street              | city     | state  | zip        |
      | 25     | "Baker street road" | "London" | null   | "EC1A 1AE" |
      | 13     | "Rue des peupliers" | "Lille"  | "Nord" | "59000"    |

    * table ownerToCreate
      | firstName | lastName | address            |
      | "Peter"   | "Parker" | addressToCreate[0] |
      | "John"    | "Doe"    | addressToCreate[1] |

    * table petsToCreate
      | name     | owner            | petType | breed    |
      | "Helios" | ownerToCreate[0] | "CAT"   | "BENGAL" |
      | "Pluto"  | ownerToCreate[1] | "DOG"   | "BEAGLE" |

    * def petStoreToCreate = {"name": "Pet store 1"}

  Scenario:
    Given path petstorePath
    And request {pet: "#(petsToCreate[0])", "petStore": "#(petStoreToCreate)"}
    When method POST
    Then status 200
    And match response.pet contains deep petsToCreate[0]
    And match response.petStore contains petStoreToCreate

    Given path petstorePath
    And request {pet: "#(petsToCreate[1])", "petStore": "#(petStoreToCreate)"}
    When method POST
    Then status 200
    And match response.pet contains deep petsToCreate[1]
    And match response.petStore contains petStoreToCreate