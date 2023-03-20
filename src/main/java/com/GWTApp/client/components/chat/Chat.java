package com.GWTApp.client.components.chat;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Chat extends Composite {

    private static final ChatUiBinder ourUiBinder = GWT.create(ChatUiBinder.class);

    public Chat() {
        initWidget(ourUiBinder.createAndBindUi(this));
        ScriptInjector.fromUrl("chat/js/sockjs-0.3.4.js").setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromUrl("chat/js/stomp.js").setWindow(ScriptInjector.TOP_WINDOW).inject();
        ScriptInjector.fromUrl("chat/js/chat.js").setWindow(ScriptInjector.TOP_WINDOW).inject();
    }

    interface ChatUiBinder extends UiBinder<HTMLPanel, Chat> {
    }
}