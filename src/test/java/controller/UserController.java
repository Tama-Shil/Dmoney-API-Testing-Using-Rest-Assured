package controller;

import model.UserModel;
import setup.Setup;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import utils.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class UserController extends Setup {
    public UserController() throws IOException {
        initConfig();
    }


    public void doLogin(String email, String password) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("baseUrl");
        UserModel model = new UserModel();
        model.setEmail(email);
        model.setPassword(password);
        Response res = given().contentType("application/json").body(model).
                post("/user/login/");
        JsonPath jsonPath = res.jsonPath();
        String token = jsonPath.get("token");
        Utils.setEnvVar("token", token);
    }

    public JsonPath createUser(UserModel model) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("baseUrl");

        Response res = given().contentType("application/json").body(model).
                header("Authorization", prop.getProperty("token")).
                header("X-AUTH-SECRET-KEY", prop.getProperty("partnerkey")).
                when().post("/user/create");

        return res.jsonPath();
    }
}
