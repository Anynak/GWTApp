package com.GWTApp.model;

import lombok.Data;

@Data
public class UserRequest {
    private String login;
    private String name;
    private String phone;
    private String email;
    private String country;
    private String city;
}
