package com.epam.factory_method.business_objects;


public class User {

    private String password;
    private String login;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return login != null ? login.equals(user.login) : user.login == null;

    }

    @Override
    public int hashCode() {
        int result = password != null ? password.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }


}
