package com.greenapp.stepDefinitions;

import com.greenapp.tflStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class tflLineStatusStepDefs {

    tflStatus tflStatus = new tflStatus();

    Response response;

    @Given("^I send request to get all the status$")
    public void i_send_request_to_get_all_the_status() {
        response = tflStatus.getStatusOfTube();
    }

    @Then("^I should see (\\d+) response from the service$")
    public void i_should_see_response_from_the_service(int arg1) {
        assertThat("Status code should be 200",response.getStatusCode(),is(HttpStatus.SC_OK));

    }

    @Then("^I should see status of following lines$")
    public void i_should_see_status_of_following_lines(List<String> lines) {
        List<String> line = response.then().extract().path("name");
        assertThat("Status should contain",line, contains(lines));
    }

}
