package com.greenapp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    public static RequestSpecification getRequestSpec() {
        RestAssured.useRelaxedHTTPSValidation();
        RequestSpecification reqSpec = given().urlEncodingEnabled(false).contentType(ContentType.JSON);
        reqSpec.log().all();
        return reqSpec;
    }

    public static Response getCall(String context, RequestSpecification reqSpec) {
        return logResponse(reqSpec.get(context));
    }

    public static Response postCall(String context, RequestSpecification reqSpec, Object body) {
        return logResponse(reqSpec.body(body).post(context));
    }

    public static Response deleteCall(String context, RequestSpecification reqSpec) {
        return logResponse(reqSpec.delete(context));
    }

    private static Response logResponse(Response response) {
        return response.then().log().all().extract().response();
    }

}
