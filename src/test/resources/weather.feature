Feature: Weather forecast

  Scenario: Weather for specific city
    Given city id is 524901

    When we are requesting weather data

    Then coordinates are:
      | lon | 145.77 |
      | lat | -16.92 |

    And weather is:
      | id          | 802              |
      | main        | Clouds           |
      | description | scattered clouds |
      | icon        | 03n              |

    And base is "stations"

#    And .....

#    And main info is:
#      | temp     | 300.15 |
#      | pressure | 1007   |
#      | humidity | 74     |
#      | temp_min | 300.15 |
#      | temp_max | 300.15 |

#    And temp is 300.15
#    And pressure is 1007
#    And humidity 74
#    And min temp 300.15
#    And max temp 300.15

#    And ...