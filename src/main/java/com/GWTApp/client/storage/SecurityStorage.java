package com.GWTApp.client.storage;

import com.GWTApp.client.storage.entity.AuthDetails;
import com.google.gwt.storage.client.Storage;


public class SecurityStorage {

    private SecurityStorage() {
    }

    public static String getAccessToken() {

        String authDetailsJson = Storage.getLocalStorageIfSupported().getItem("authDetails");
        try {
            AuthDetails authDetails = AuthDetails.fromJson(authDetailsJson);
            return authDetails.getAccessToken();
        } catch (Exception e) {

            return null;
        }


    }

    public static AuthDetails getAuthDetails() {
        String authDetailsJson = Storage.getLocalStorageIfSupported().getItem("authDetails");
        try {
            return AuthDetails.fromJson(authDetailsJson);
        } catch (Exception e) {

            return null;
        }
    }

    public static void saveAuthDetails(AuthDetails authDetails) {
        authDetails.setAccessToken("Bearer "+authDetails.getAccessToken());
        Storage.getLocalStorageIfSupported().setItem("authDetails", AuthDetails.toJson(authDetails));
    }


}
