package com.lld.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> userList;
    public UserController() {
        userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }
    public void addUser(User user) {
        userList.add(user);
    }
    public void removeUser(User user) {
        userList.remove(user);
    }
    public User getUser(String userId){
        for(User user:userList){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}

