Feature: Add & Delete User E2E

Scenario Outline: FE || E2E || validate the "Records Found" value updates correctly when adding & deleting a user

  Given "<user>" login successfully
  And user navigate to admin tab
  And user get the number of records found
  When user click on add user button
  And user fill "<new user>" data
  And user click on save button
  Then the number of records should be increased by 1
  When user search with the just created username
  And user delete the just created user
  And user reset the search
  Then the number of records should be decreased by 1
  Examples:
    | user  | new user |
    | Admin | newUser  |
