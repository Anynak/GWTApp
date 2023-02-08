package com.GWTApp.client.storage;

import com.GWTApp.client.storage.entity.Token;
import com.google.gwt.storage.client.Storage;

public class SecurityStorage {

    public static String getAccessToken() {
        return Storage.getLocalStorageIfSupported().getItem("Authorization");
    }

    public static void setAccessToken(Token token) {
        Storage.getLocalStorageIfSupported().setItem("Authorization", "Bearer " + token.getAccessToken());

    }
}
