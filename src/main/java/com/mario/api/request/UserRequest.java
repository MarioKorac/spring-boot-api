package com.mario.api.request;


import java.util.List;

public class UserRequest {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int age;
    private List<TodoRequest> todos;

    public UserRequest(String firstName, String lastName,String password, String email, int age,List<TodoRequest> todos) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.age = age;
        this.todos = todos;
    }

    public UserRequest() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TodoRequest> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoRequest> todos) {
        this.todos = todos;
    }
}
