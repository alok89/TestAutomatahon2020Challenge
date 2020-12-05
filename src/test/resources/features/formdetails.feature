@challenge3
Feature: Test FormDetails

Background:
Given User is on Form Details Page

Scenario: Submit a successfull submission
When User enter all the details
Then Form should be submitted successfully

Scenario: Unable to submit by leaving a mandatory field blank
When User enter the details
And leave mobileNo as blank
Then Form should not get submitted with a message "This field is required."

Scenario: Unable to submit by entering wrong details into a mandatory field
When User enter the details
And enter wrong emailId as "hjjhbj"
Then Form should not get submitted with a message "Please enter a valid email address."