Feature: DP Login Feature

Scenario Outline: DP Negative Login Test Scenario

Given User is on dp home page
When title of home page is Dynamic Planner
Then user moves to login page and click to try it now button
Then user login with "<username>" and "<pasword>"
Then user get verification
Then close browser

Examples:
 | username       | password |
| test  | 123   |