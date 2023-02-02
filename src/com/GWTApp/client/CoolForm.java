package com.GWTApp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CoolForm extends Composite {

    interface CoolFormUiBinder extends UiBinder<Widget, CoolForm> {
    }

    private static CoolFormUiBinder ourUiBinder = GWT.create(CoolFormUiBinder.class);

    public CoolForm() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}