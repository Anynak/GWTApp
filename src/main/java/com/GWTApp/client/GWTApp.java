package com.GWTApp.client;

import com.GWTApp.client.presenters.Presenter;
import com.GWTApp.client.presenters.UserRequestPresenter;
import com.GWTApp.client.presenters.DisplayUserRequest;
import com.GWTApp.client.views.UserRequestView;
import com.GWTApp.model.UserRequest;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.http.client.Request;
import java.util.ArrayList;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class GWTApp implements EntryPoint {
    private CoolForm coolForm = new CoolForm();

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        UserRequest userRequest = new UserRequest();
        userRequest.setName("Masha");
        userRequest.setEmail("qwert@mail.com");
        userRequest.setPhone("+12351458761");
        userRequest.setCity("Vitebsk");
        userRequest.setCountry("Belarus");

        UserRequest userRequest1 = new UserRequest();
        userRequest1.setName("Sasha");
        userRequest1.setEmail("qwertSasha@mail.com");
        userRequest1.setPhone("+111158761");
        userRequest1.setCity("Minsk");
        userRequest1.setCountry("Belarus");

        List<UserRequest> users = new ArrayList<>();
        users.add(userRequest);
        users.add(userRequest1);

        Label testLabel = new Label("testLabel");





        DisplayUserRequest view = new UserRequestView();
        Presenter presenter = new UserRequestPresenter(users,view);
        presenter.go(RootPanel.get("content"));


        final Button button = new Button("Click me");

        final Label label = new Label();

        final Button button1 = new Button("0");


        button.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {


                if (label.getText().equals("")) {
                    GWTAppService.App.getInstance().getMessage("Hello, World!", new MyAsyncCallback(label));
                } else {
                    label.setText("");
                }
            }
        });

        button1.addClickHandler(new ClickHandler() {
            double i = 1;
            @Override
            public void onClick(ClickEvent event) {




                i = i + 1;
                if(i >= Double.MAX_VALUE){
                    button1.setText("MAX");
                }else {
                    button1.setText(""+i+"$");
                }



            }
        });


        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("content").add(button);
        RootPanel.get("content").add(label);

        RootPanel.get("content").add(button1);
        RootPanel.get("content").add(coolForm);
        RootPanel.get("content").add(testLabel);


    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
