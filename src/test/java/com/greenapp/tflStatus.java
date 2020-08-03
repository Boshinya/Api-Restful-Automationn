package com.greenapp;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class tflStatus {

    public Response getStatusOfTube() {
        RequestSpecification req = ApiHelper.getRequestSpec().param("app_id", "41deed08").param("app_key", "ecbc7f0729dd00cdaf541307fc199e2c");
        return ApiHelper.getCall("Line/Mode/tube/Status",req);
    }


}
