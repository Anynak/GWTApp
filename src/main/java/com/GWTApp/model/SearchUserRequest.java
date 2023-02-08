package com.GWTApp.model;

import lombok.Data;

@Data
public class SearchUserRequest {
    private String country = "";
    private String city = "";
}
