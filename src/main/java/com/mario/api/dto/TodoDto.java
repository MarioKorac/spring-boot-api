package com.mario.api.dto;


import com.mario.api.entity.User;


public class TodoDto {


    private String todoName;
    private String isDone;
    private User user;

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


}
