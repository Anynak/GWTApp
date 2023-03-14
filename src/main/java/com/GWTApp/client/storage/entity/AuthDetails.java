package com.GWTApp.client.storage.entity;

import com.google.gwt.json.client.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AuthDetails implements Serializable {
    private String accessToken;
    private String tokenType;
    private List<String> roles = new ArrayList<>();

    public static AuthDetails fromJson(String authDetailsStr) throws Exception {
        try {
            JSONValue authDetailsJs = JSONParser.parseStrict(authDetailsStr);
            AuthDetails authDetails = new AuthDetails();
            authDetails.setAccessToken(authDetailsJs.isObject().get("accessToken").isString().stringValue());
            authDetails.setTokenType(authDetailsJs.isObject().get("tokenType").isString().stringValue());
            JSONArray rolesJs = authDetailsJs.isObject().get("roles").isArray();
            for (int i = 0; i < rolesJs.size(); i++) {
                authDetails.addRole(rolesJs.get(i).isString().stringValue());
            }

            return authDetails;
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    public static String toJson(AuthDetails authDetails) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("accessToken", new JSONString(authDetails.accessToken));
        jsonObject.put("tokenType", new JSONString(authDetails.tokenType));

        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < authDetails.roles.size(); i++) {
            jsonArray.set(i, new JSONString(authDetails.roles.get(i)));
        }
        jsonObject.put("roles", jsonArray);

        return jsonObject.toString();

    }

    public String getAccessToken() {
        return accessToken;
    }


    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void addRole(String role) {
        this.roles.add(role);
    }
}
