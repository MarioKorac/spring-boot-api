package com.mario.api.entity;


import javax.persistence.*;

@Entity(name = "todos")
public class Todo {

    @Id
    @GeneratedValue
    private int id;
    private String todoId;
    private String todoName;
    private String isDone;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Todo() {
    }

    public Todo(String todoId, String todoName, String isDone, User user) {
        this.todoId = todoId;
        this.todoName = todoName;
        this.isDone = isDone;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public String getIsDone() {
        return isDone;
    }

    public void setIsDone(String isDone) {
        this.isDone = isDone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}