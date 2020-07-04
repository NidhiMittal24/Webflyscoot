$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Test.feature");
formatter.feature({
  "line": 1,
  "name": "Flyscoot",
  "description": "",
  "id": "flyscoot",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Make booking",
  "description": "",
  "id": "flyscoot;make-booking",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Open the browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Enter the URL",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "Enter the origin \"\u003corigin\u003e\" and  destination \"\u003cdestination\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Enter the date of booking \"\u003cdate\u003e\" and click on search",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Select the flight",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Click on next page button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Keen title \"\u003ctitle\u003e\" , first name \"\u003cfirstname\u003e\" , last name \"\u003clastname\u003e\" , DOB \"\u003cDOB\u003e\" ,nationality \"\u003cnationality\u003e\" ,",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "Click on continue payment button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Enter contact details",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Keen streetaddress \"\u003cstreetaddress\u003e\", country \"\u003ccountry\u003e\", city \"\u003ccity\u003e\", postal \"\u003cpostal\u003e\",",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Select payment method cardnumber \"\u003ccardnumber\u003e\", expirationdate \"\u003cexpirationdate\u003e\", cardholdername \"\u003ccardholdername\u003e\", ccv \"\u003cccv\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "comments": [
    {
      "line": 16,
      "value": "#Then Close the browser"
    }
  ],
  "line": 17,
  "name": "",
  "description": "",
  "id": "flyscoot;make-booking;",
  "rows": [
    {
      "cells": [
        "origin",
        "destination",
        "date",
        "title",
        "firstname",
        "lastname",
        "DOB",
        "nationality",
        "streetaddress",
        "country",
        "city",
        "postal",
        "cardnumber",
        "expirationdate",
        "cardholdername",
        "ccv"
      ],
      "line": 18,
      "id": "flyscoot;make-booking;;1"
    },
    {
      "cells": [
        "SIN",
        "KUL",
        "20 August 2020",
        "Ms",
        "Nidhi",
        "Mittal",
        "1-1-1992",
        "India",
        "test address",
        "India",
        "Karnataka",
        "Karnataka",
        "5149000000000001",
        "01-21",
        "Test",
        "123"
      ],
      "line": 19,
      "id": "flyscoot;make-booking;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 19,
  "name": "Make booking",
  "description": "",
  "id": "flyscoot;make-booking;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Open the browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Enter the URL",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "Enter the origin \"SIN\" and  destination \"KUL\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Enter the date of booking \"20 August 2020\" and click on search",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Select the flight",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Click on next page button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Keen title \"Ms\" , first name \"Nidhi\" , last name \"Mittal\" , DOB \"1-1-1992\" ,nationality \"India\" ,",
  "matchedColumns": [
    3,
    4,
    5,
    6,
    7
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "Click on continue payment button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Enter contact details",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Keen streetaddress \"test address\", country \"India\", city \"Karnataka\", postal \"Karnataka\",",
  "matchedColumns": [
    8,
    9,
    10,
    11
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Select payment method cardnumber \"5149000000000001\", expirationdate \"01-21\", cardholdername \"Test\", ccv \"123\"",
  "matchedColumns": [
    12,
    13,
    14,
    15
  ],
  "keyword": "And "
});
formatter.match({
  "location": "Steps.open_the_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps.enter_the_URL()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "SIN",
      "offset": 18
    },
    {
      "val": "KUL",
      "offset": 41
    }
  ],
  "location": "Steps.enter_the_origin_and_destination(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "20 August 2020",
      "offset": 27
    }
  ],
  "location": "Steps.enter_the_date_of_booking_and_click_on_search(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps.select_the_flight()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps.click_on_next_page_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Ms",
      "offset": 12
    },
    {
      "val": "Nidhi",
      "offset": 30
    },
    {
      "val": "Mittal",
      "offset": 50
    },
    {
      "val": "1-1-1992",
      "offset": 65
    },
    {
      "val": "India",
      "offset": 89
    }
  ],
  "location": "Steps.keen_title_first_name_last_name_DOB_nationality(String,String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps.click_on_continue_payment_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps.enter_contact_details()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "test address",
      "offset": 20
    },
    {
      "val": "India",
      "offset": 44
    },
    {
      "val": "Karnataka",
      "offset": 58
    },
    {
      "val": "Karnataka",
      "offset": 78
    }
  ],
  "location": "Steps.keen_streetaddress_country_city_postal(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "5149000000000001",
      "offset": 34
    },
    {
      "val": "01-21",
      "offset": 69
    },
    {
      "val": "Test",
      "offset": 93
    },
    {
      "val": "123",
      "offset": 105
    }
  ],
  "location": "Steps.select_payment_method_cardnumber_expirationdate_cardholdername_ccv(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
});