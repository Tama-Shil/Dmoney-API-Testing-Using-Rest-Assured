package testRunner;

import controller.UserController;
import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import model.UserModel;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;

public class UserTestRunner {
    @Test(priority = 1, description = "Admin Login")
    public void adminLogin() throws IOException, ConfigurationException {
        UserController userController = new UserController();
        userController.doLogin("admin@roadtocareer.net", "1234");
    }

    @Test(priority = 2, description = "Create 1st customer")
    public void createCustomer1() throws IOException, ConfigurationException, ParseException, org.json.simple.parser.ParseException {
        UserController userController = new UserController();
        Faker faker = new Faker();
        UserModel model = new UserModel();
        model.setName(faker.name().fullName());
        model.setEmail(faker.internet().emailAddress().toLowerCase());
        model.setPassword(String.valueOf(Utils.generateRandomId(1000, 9999)));
        model.setPhone_number("019" + Utils.generateRandomId(1000, 9999) + Utils.generateRandomId(1000, 9999));
        model.setNid(String.valueOf(Utils.generateRandomId(1000000, 9999999)));
        model.setRole("Customer");
        JsonPath jsonObj = userController.createUser(model);
        Utils.saveUsers(model);
        String actualmessage = jsonObj.get("message");
        Assert.assertTrue(actualmessage.contains("User created"));

    }

    @Test(priority = 3, description = "Create 2nd Customer")
    public void createCustomer2() throws IOException, ConfigurationException, ParseException, org.json.simple.parser.ParseException {
        UserController userController = new UserController();
        Faker faker = new Faker();
        UserModel model = new UserModel();
        model.setName(faker.name().fullName());
        model.setEmail(faker.internet().emailAddress().toLowerCase());
        model.setPassword(String.valueOf(Utils.generateRandomId(1000, 9999)));
        model.setPhone_number("019" + Utils.generateRandomId(1000, 9999) + Utils.generateRandomId(1000, 9999));
        model.setNid(String.valueOf(Utils.generateRandomId(1000000, 9999999)));
        model.setRole("Customer");
        JsonPath jsonObj = userController.createUser(model);
        Utils.saveUsers(model);
        String actualmessage = jsonObj.get("message");
        Assert.assertTrue(actualmessage.contains("User created"));
    }

    @Test(priority = 4, description = "Create an agent")
    public void createAgent() throws IOException, ConfigurationException, ParseException, org.json.simple.parser.ParseException {
        UserController userController = new UserController();
        Faker faker = new Faker();
        UserModel model = new UserModel();
        model.setName(faker.name().fullName());
        model.setEmail(faker.internet().emailAddress().toLowerCase());
        model.setPassword(String.valueOf(Utils.generateRandomId(1000, 9999)));
        model.setPhone_number("019" + Utils.generateRandomId(1000, 9999) + Utils.generateRandomId(1000, 9999));
        model.setNid(String.valueOf(Utils.generateRandomId(1000000, 9999999)));
        model.setRole("Agent");
        JsonPath jsonObj = userController.createUser(model);
        Utils.saveUsers(model);
        String actualmessage = jsonObj.get("message");
        Assert.assertTrue(actualmessage.contains("User created"));
    }


}
