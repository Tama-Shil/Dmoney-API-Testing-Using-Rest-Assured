package testRunner;

import controller.TransactionController;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;

public class TransactionTestRunner {
    @Test(priority = 1, description = "Give 2000 tk from System account to the newly created agent")
    public void sendMoneyToAgent() throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONArray userArray = Utils.readJSONData();
        JSONObject userObj = (JSONObject) userArray.get(userArray.size() - 1);
        String agentAcc = userObj.get("phone_number").toString();
        System.out.println(agentAcc);
        String systemAcc = "SYSTEM";
        double amount = 2000;
        TransactionController transactionController = new TransactionController();
        JsonPath jsonObj = transactionController.deposite(systemAcc, agentAcc, amount);
        // System.out.println(jsonObj.get().toString());
        String message = jsonObj.get("message");
        // System.out.println(message);
        Assert.assertTrue(message.contains("Deposit successful"));
    }

    @Test(priority = 2, description = "Deposit 1500 tk to a customer from the agent account")
    public void depositeToCustomer() throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONArray userArray = Utils.readJSONData();
        JSONObject userObj1 = (JSONObject) userArray.get(userArray.size() - 1);
        String agentAcc = userObj1.get("phone_number").toString();
        // System.out.println(agentAcc);
        JSONObject userObj2 = (JSONObject) userArray.get(userArray.size() - 3);
        String customerAcc = userObj2.get("phone_number").toString();
        //System.out.println(customerAcc);
        double amount = 1500;
        TransactionController transactionController = new TransactionController();
        JsonPath jsonObj = transactionController.deposite(agentAcc, customerAcc, amount);
        // System.out.println(jsonObj.get().toString());
        String message = jsonObj.get("message");
        // System.out.println(message);
        Assert.assertTrue(message.contains("Deposit successful"));

    }

    @Test(priority = 3, description = "Withdraw 500 tk by the customer to the agent")
    public void withdrawByCustomer() throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONArray userArray = Utils.readJSONData();
        JSONObject userObj1 = (JSONObject) userArray.get(userArray.size() - 1);
        String agentAcc = userObj1.get("phone_number").toString();
        JSONObject userObj2 = (JSONObject) userArray.get(userArray.size() - 3);
        String customerAcc = userObj2.get("phone_number").toString();
        double amount = 500;
        TransactionController transactionController = new TransactionController();
        JsonPath jsonObj = transactionController.withdraw(customerAcc, agentAcc, amount);
        // System.out.println(jsonObj.get().toString());
        String message = jsonObj.get("message");
        // System.out.println(message);
        Assert.assertTrue(message.contains("Withdraw successful"));

    }

    @Test(priority = 4, description = "Send money 500 tk to another customer")
    public void sendMoneyToCustomer() throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONArray userArray = Utils.readJSONData();
        JSONObject userObj1 = (JSONObject) userArray.get(userArray.size() - 2);
        String customer2Acc = userObj1.get("phone_number").toString();
        JSONObject userObj2 = (JSONObject) userArray.get(userArray.size() - 3);
        String customer1Acc = userObj2.get("phone_number").toString();

        double amount = 500;
        TransactionController transactionController = new TransactionController();
        JsonPath jsonObj = transactionController.sendMoney(customer1Acc, customer2Acc, amount);
        // System.out.println(jsonObj.get().toString());
        String message = jsonObj.get("message");
        // System.out.println(message);
        Assert.assertTrue(message.contains("Send money successful"));

    }


    @Test(priority = 5, description = "Payment 100 tk to any merchant (e.g. 01808574100) by the recipient customer")
    public void paymentByCustomer() throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONArray userArray = Utils.readJSONData();
        JSONObject userObj1 = (JSONObject) userArray.get(userArray.size() - 2);
        String customer2Acc = userObj1.get("phone_number").toString();
        String merchantAcc = "01808574100";
        double amount = 100;
        TransactionController transactionController = new TransactionController();
        JsonPath jsonObj = transactionController.payment(customer2Acc, merchantAcc, amount);
        // System.out.println(jsonObj.get().toString());
        String message = jsonObj.get("message");
        // System.out.println(message);
        Assert.assertTrue(message.contains("Payment successful"));

    }

    @Test(priority = 6, description = "Check balance of the recipient customer")
    public void checkBalanceOfCustomer() throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONArray userArray = Utils.readJSONData();
        JSONObject userObj1 = (JSONObject) userArray.get(userArray.size() - 2);
        String customerAcc = userObj1.get("phone_number").toString();

        TransactionController transactionController = new TransactionController();
        JsonPath jsonObj = transactionController.checkbalance(customerAcc);
        // System.out.println(jsonObj.get().toString());
        String message = jsonObj.get("message");
        // System.out.println(message);
        Assert.assertTrue(message.contains("User balance"));

    }


}
