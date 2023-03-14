package com.GWTApp.client.storage;

import com.GWTApp.client.storage.entity.AuthDetails;
import com.GWTApp.client.storage.entity.Token;
import com.GWTApp.model.LoginEntity;
import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.storage.client.Storage;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;
import gwt.interop.utils.client.JSON;


import java.util.List;

public class SecurityStorage {

    public static String getAccessToken() {
        AuthDetailsFactory authDetailsFactory = GWT.create(AuthDetailsFactory.class);
        String authDetailsJson = Storage.getLocalStorageIfSupported().getItem("authDetails");
        AutoBean<AuthDetails> bean = AutoBeanCodex.decode(authDetailsFactory, AuthDetails.class, authDetailsJson);
        AuthDetails authDetails = bean.as();
        return authDetails.getAccessToken();
    }




    public static void saveAuthDetails(AuthDetails authDetails) {
        AutoBean<AuthDetails> bean = AutoBeanUtils.getAutoBean(authDetails);
        Storage.getLocalStorageIfSupported().setItem("authDetails", AutoBeanCodex.encode(bean).getPayload());
    }

    public interface AuthDetailsFactory extends AutoBeanFactory
    {
        AutoBean<AuthDetails> authDetails();
    }
}
