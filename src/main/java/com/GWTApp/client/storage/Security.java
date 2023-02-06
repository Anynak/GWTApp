package com.GWTApp.client.storage;

import com.google.gwt.storage.client.Storage;

public class Security {

    public void setAccessToken(String token) {
        Storage.getLocalStorageIfSupported().setItem("accessToken", token);

    }
}
