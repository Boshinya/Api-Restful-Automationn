package com.greenapp;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserCreation extends ApiHelper{

    RequestSpecification reqSpec = getRequestSpec();


    public Response createNewuser() {
        return postCall(Constants.posts,reqSpec, CreateUser.builder().title("testing").body("foooo").userId(1000).build());
    }
}
