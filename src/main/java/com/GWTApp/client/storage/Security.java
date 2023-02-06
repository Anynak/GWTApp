package com.GWTApp.client.storage;

import com.GWTApp.client.storage.entity.Token;
import com.google.gwt.storage.client.Storage;

public class Security {

    public void setAccessToken(Token token) {
        Storage.getLocalStorageIfSupported().setItem("accessToken", token.getAccessToken());

    }
}
