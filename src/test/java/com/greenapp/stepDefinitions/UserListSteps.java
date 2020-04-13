package com.greenapp.stepDefinitions;

import com.greenapp.UserCreation;
import com.greenapp.UserRequest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.MatcherAssert;
import org.json.simple.parser.ParseException;

import java.util.List;

import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

public class UserListSteps {

    UserRequest request = new UserRequest();

    UserCreation createUser = new UserCreation();

    Response response;


    @Given("^I send GET request to the Server$")
    public void i_send_GET_request_to_the_Server() {
        response = request.getUserRequest();
    }

    @Then("^I should see (\\d+) response from the Server$")
    public void i_should_see_response_from_the_Server(int statusCode) {
        if(statusCode == 200) {
            MatcherAssert.assertThat("Response should be 200", request.getUserRequestStatusCode(), is(HttpStatus.SC_OK));
        } else if(statusCode ==201) {
            MatcherAssert.assertThat("Response should be 200", response.getStatusCode(), is(HttpStatus.SC_CREATED));
        }
    }

    @Then("^I should receive all the user information$")
    public void i_should_receive_all_the_user_information() throws ParseException {
        String json = response.asString();
        List<String> userName = from(json).getList("userName");
        MatcherAssert.assertThat("Number of Users should be 10", userName.size(), is(10));
    }

    @And("^I should see an User with name \"([^\"]*)\"$")
    public void iShouldSeeAnUserWithName(String userName) throws ParseException {
        List<String> actualuserName = request.getAllUsers();
        MatcherAssert.assertThat("UserName should match", actualuserName,hasItem(userName));
    }

    @Given("^I create a new User$")
    public void iCreateANewUser() {
        response = createUser.createNewuser();
        response.then().body("id",equalTo(101));
    }
}
