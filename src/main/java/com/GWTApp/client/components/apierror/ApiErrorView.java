package com.GWTApp.client.components.apierror;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import org.fusesource.restygwt.client.Method;


public class ApiErrorView extends Composite {

    @UiField
    HTML errorText;

    private Method method;

    interface ApiErrorViewUiBinder extends UiBinder<HTML, ApiErrorView> {
    }

    private static final ApiErrorViewUiBinder ourUiBinder = GWT.create(ApiErrorViewUiBinder.class);

    public ApiErrorView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }


    public void setMethod(Method method) {
        this.method = method;
    }

    public void show() {

        String errorMessage = this.method.getResponse().getText();
//
        try {
            JSONValue apiError = JSONParser.parseStrict(errorMessage);
            JSONArray errors = apiError.isArray();
            StringBuilder errorMessages = new StringBuilder();
            for (int i = 0; i < errors.size(); i++) {
                errorMessages.append(errors.get(i).isObject().get("userMessage").toString().replace("\"", ""));
                errorMessages.append("<br />");
            }
            errorText.setHTML(errorMessages.toString());
//
        } catch (Exception e) {
            errorText.setText(errorMessage);
        }
    }


}