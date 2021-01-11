package com.mario.api.response;


import java.util.List;

public class UserResponse {

    private String userId;
    private String firstName;
    private String lastName;
    private int age;
    private List<TodoResponse> todos;


    public UserResponse() {
    }

    public UserResponse(String userId, String firstName, String lastName, int age, List<TodoResponse> todos) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.todos = todos;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<TodoResponse> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoResponse> todos) {
        this.todos = todos;
    }
}
