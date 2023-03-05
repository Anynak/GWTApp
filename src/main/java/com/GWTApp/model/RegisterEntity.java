package com.GWTApp.model;

public class RegisterEntity {
    private String login;
    private String name;
    private String phone;
    private String email;
    private String country;
    private String city;
    private String password;
    private String repeatPassword;

    public RegisterEntity(String login, String name, String phone, String email, String country, String city, String password, String repeatPassword) {
        this.login = login;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.city = city;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    public RegisterEntity() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
