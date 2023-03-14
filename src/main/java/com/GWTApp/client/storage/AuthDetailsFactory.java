package com.GWTApp.client.storage;

import com.GWTApp.client.storage.entity.AuthDetails;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

public interface AuthDetailsFactory extends AutoBeanFactory {
    AutoBean<AuthDetails> authDetails();
}
