package com.greenapp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUser {
    private String title;
    private String body;
    private int userId;
}
