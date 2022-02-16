Feature: Tickets booking system

  Scenario: API reservation check
    Given airports "RIX" and "SVO"

    And personal info is:
      | first_name | Dmtrijs    |
      | last_name  | Tester     |
      | discount   | none       |
      | adults     | 2          |
      | kids       | 2          |
      | bags       | 1          |
      | flight     | 14-05-2018 |

    And home page opened

    When we are selecting airports
    And pressing GoGoGo button

    Then selected airports appears

    When we are filling in personal info