package controller;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.TransactionModel;
import setup.Setup;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class TransactionController extends Setup {
    public TransactionController() throws IOException {
        initConfig();
    }

    public JsonPath deposite(String fromAccount, String toAccount, double amount) {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        TransactionModel tmodel = new TransactionModel(fromAccount, toAccount, amount);
        Response res = given().contentType("application/json").body(tmodel).
                header("Authorization", prop.getProperty("token")).
                header("X-AUTH-SECRET-KEY", prop.getProperty("partnerkey")).
                when().post("/transaction/deposit");
        return res.jsonPath();
    }

    public JsonPath withdraw(String fromAccount, String toAccount, double amount) {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        TransactionModel tmodel = new TransactionModel(fromAccount, toAccount, amount);
        Response res = given().contentType("application/json").body(tmodel).
                header("Authorization", prop.getProperty("token")).
                header("X-AUTH-SECRET-KEY", prop.getProperty("partnerkey")).
                when().post("/transaction/withdraw");
        return res.jsonPath();
    }

    public JsonPath sendMoney(String fromAccount, String toAccount, double amount) {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        TransactionModel tmodel = new TransactionModel(fromAccount, toAccount, amount);
        Response res = given().contentType("application/json").body(tmodel).
                header("Authorization", prop.getProperty("token")).
                header("X-AUTH-SECRET-KEY", prop.getProperty("partnerkey")).
                when().post("/transaction/sendmoney");
        return res.jsonPath();
    }

    public JsonPath payment(String fromAccount, String toAccount, double amount) {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        TransactionModel tmodel = new TransactionModel(fromAccount, toAccount, amount);
        Response res = given().contentType("application/json").body(tmodel).
                header("Authorization", prop.getProperty("token")).
                header("X-AUTH-SECRET-KEY", prop.getProperty("partnerkey")).
                when().post("/transaction/payment");
        return res.jsonPath();
    }

    public JsonPath checkbalance(String accountNo) {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        //TransactionModel tmodel = new TransactionModel(fromAccount, toAccount, amount);
        Response res = given().contentType("application/json").
                header("Authorization", prop.getProperty("token")).
                header("X-AUTH-SECRET-KEY", prop.getProperty("partnerkey")).
                when().get("/transaction/balance/" + accountNo);
        return res.jsonPath();
    }

}
