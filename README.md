# Dmoney API Testing Using Rest Assured
This project automates key functions of the Dmoney API using Rest Assured. Comprehensive test suites are executed with TestNG, and detailed reports are generated with Allure, providing clear insights into the API's performance and reliability
## Problem scenario 
Do following steps from Dmoney API collection

1. Do Login by admin
2. Create 2 new customers and a agent
3. Give 2000 tk from System account to the newly created agent
4. Deposit 1500 tk to a customer from the agent account
5. Withdraw 500 tk by the customer to the agent
6. Send money 500 tk to another customer
7. Payment 100 tk to any merchant (e.g. 01686606905) by the recipient customer
8. Check balance of the recipient customer

## Technology used:
- Java
- Intellij idea

## Framework used:
  - TestNG
  - Rest Assured
  - Allure


## How to Run the Project
1. Clone this project
2. Open cmd in the root folder.
3. Give the following command:  _````gradle clean test````_

## To generate Allure Report:
1. Open cmd in the root folder.
2. Give the following commands:
   
  *  _````allure generate allure-reports --clean -output````_
  *  _````allure serve allure-results````_
   
## Allure Report
![image](https://github.com/user-attachments/assets/47d1d545-3e9e-4973-a129-4da94ca2939e)

![image](https://github.com/user-attachments/assets/1ce13bec-fa9f-44db-87e0-c91127010edb)

