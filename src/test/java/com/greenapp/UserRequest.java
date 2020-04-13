package com.greenapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRequest extends ApiHelper{

        RequestSpecification requestSpecification =  getRequestSpec();
        Gson gson = new GsonBuilder().create();


   public Response getUserRequest() {
       return getCall(Constants.users, requestSpecification);
   }

    public int getUserRequestStatusCode() {
        return getUserRequest().getStatusCode();
    }

    public List<String> getAllUsers() throws ParseException {
        List<UsersResponse> users = new ArrayList<>();
        String json = getCall(Constants.users,requestSpecification).asString();
        JSONParser jsonParser = new JSONParser();
        JSONArray userList = (JSONArray) jsonParser.parse(json);

        for(Object obj : userList) {
            JSONObject user = (JSONObject) obj;
            users.add(gson.fromJson(user.toJSONString(), UsersResponse.class));
        }
        return users.stream().map(UsersResponse::getUsername).collect(Collectors.toList());
    }

}
