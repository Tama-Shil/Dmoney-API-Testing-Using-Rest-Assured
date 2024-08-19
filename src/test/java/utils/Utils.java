package utils;

import model.UserModel;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Random;

public class Utils {

    public static void setEnvVar(String key, String value) throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty(key, value);
        config.save();
    }

    public static void saveUsers(UserModel model) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String fileLocation = "./src/test/resources/users.json";
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", model.getName());
        jsonObject.put("email", model.getEmail());
        jsonObject.put("password", model.getPassword());
        jsonObject.put("phone_number", model.getPhone_number());
        jsonObject.put("nid", model.getNid());
        jsonObject.put("role", model.getRole());

        jsonArray.add(jsonObject);

        FileWriter fileWriter=new FileWriter(fileLocation);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();

    }
    public static JSONArray readJSONData() throws IOException, ParseException, org.json.simple.parser.ParseException {
        String fileLocation = "./src/test/resources/users.json";
        JSONParser parser= new JSONParser();
        JSONArray jsonArray =(JSONArray) parser.parse((new FileReader(fileLocation)));
        return jsonArray;
    }

    public static int generateRandomId(int min, int max){
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;

    }


}
