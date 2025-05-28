Feature: Survey

  Background:
    * url baseUrl
    * def surveyPath = '/api/v1/survey'
    * configure headers = {'Content-Type':'application/json'}

    * table surveyToCreate
    | name       | description        | status     | question                   | options                                                                                           | votes |
    | "Survey A" | "some description" | "ACCEPTED" | "Did you enjoy the trip ?" | {"type": "opinionScale","opinionScale":["ABSOLUTELY_YES", "YES", "MAYBE", "NO", "ABSOLUTELY_NO"]} | null  |
    | "Survey B" | "some description" | "ACCEPTED" | "Did you enjoy the trip ?" | {"type": "graduation","graduation":[0,1,2,3,4]}                                                   | null  |

  Scenario:
    # That will only create survey for enterprise A
    Given path surveyPath
    And request surveyToCreate[0]
    When method POST
    Then status 200
    And match response == {"name":"Survey A","description":"some description","status":"ACCEPTED","question":"Did you enjoy the trip ?","options":{"type":"opinionScale","opinionScale":["ABSOLUTELY_YES","YES","MAYBE","NO","ABSOLUTELY_NO"]}}

    # That will create survey for enterprise A and B
    Given path surveyPath
    And request surveyToCreate[1]
    When method POST
    Then status 200
    And match response == {"name":"Survey B","description":"some description","status":"ACCEPTED","question":"Did you enjoy the trip ?","options":{"type":"graduation","graduation":[0,1,2,3,4]}}

    Given path surveyPath
    When method GET
    Then status 200
    And match response[*].enterpriseName == ["Enterprise A", "Enterprise A", "Enterprise B"]
    # Survey A has not been created for enterprise B
    And match response[*].name == ["Survey A", "Survey B", "Survey B"]