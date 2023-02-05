package com.GWTApp.client;

import com.GWTApp.client.service.UserService;
import com.GWTApp.client.views.LoginForm;
import com.GWTApp.client.views.UserRequestView;
import com.GWTApp.model.UserRequest;
import com.google.gwt.core.client.EntryPoint;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.fusesource.restygwt.client.Defaults;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class GWTApp implements EntryPoint {
    //private CoolForm coolForm = new CoolForm();
    //private final VerticalPanel verticalPanel = new VerticalPanel();
    private final FlexTable flexTable = new FlexTable();
    private final UserRequestView userRequestView = new UserRequestView();

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

        Defaults.setServiceRoot("http://127.0.0.1:8080/");


        UserService userService =GWT.create(UserService.class);
        userService.getUsers(new MethodCallback<List<UserRequest>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                System.out.println("ffffffff");
            }
//
            @Override
            public void onSuccess(Method method, List<UserRequest> userRequests) {
                System.out.println(userRequests);
                userRequestView.setUsers(userRequests);
                System.out.println(users);
                //users.addAll(userRequests);
            }
        });


        TabPanel tp = new TabPanel();
        tp.add(new HTML("Foo"), "foo");
        tp.add(new HTML("Bar"), "bar");
        tp.add(new HTML("Baz"), "baz");

        // Show the 'bar' tab initially.
        tp.selectTab(1);
        //verticalPanel.add(tp);
        flexTable.setWidget(0,0,tp);

        Label label = new Label("Users");
        //verticalPanel.add(label);
        flexTable.setWidget(1,0,label);




        //UserRequestView userRequestView = new UserRequestView();
        //userRequestView.setUsers(users);
        //verticalPanel.add(userRequestView);
        flexTable.setWidget(2,0,userRequestView);

        LoginForm loginForm = new LoginForm();
        //verticalPanel.add(loginForm);
        flexTable.setWidget(3,0,loginForm);


        final Button button = new Button("Click me");



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


        //RootPanel.get("content").add(verticalPanel);
        RootPanel.get("content").add(flexTable);



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
