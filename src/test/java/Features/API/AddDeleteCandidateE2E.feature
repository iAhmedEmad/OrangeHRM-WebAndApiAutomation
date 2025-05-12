Feature: Add & Delete Candidate E2E


Scenario Outline: Add and delete a candidate successfully
    Given "<user>" login successfully
    When user send request to add new candidate
   Then api should success with response code 200
   When  user send request to delete new candidate
   Then api should success with response code 200
    Examples:
      | user  |
      | Admin |