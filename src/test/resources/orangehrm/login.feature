@smoke @tags
Feature: Login feature for OrangeHRM site
  As a Admin
  I want to see login page
  So that I can login successfully

  #happy path scenario
  @login @smoke
  Scenario: Admin can able to login successfully with valid credentials
    Given Admin is on login page
    When Admin enters username as "admin" and password as "Xwq3qYaY"
    And Admin selects login
    Then Admin should login successfully
    And Admin should see welcome message as "Welcome Adminsdfdsf"

    #un-happy path scenario
  @login1
  Scenario Outline: Admin cannot login successfully with in-valid credentials
    Given Admin is in login page
    When Admin enters username as "<username>" and password as "<password>"
    And Admin select login
    Then Admin should not login successfully
    And Admin should see message as "<Message>"
    Examples:
      | username | password | Message                            |
      |          |          | Please enter username and password |
      | dgffdgfd | fdfddjjj | Please enter valid username        |
      | dsfdsfsf |          | Please enter password              |

