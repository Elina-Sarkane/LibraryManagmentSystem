package controller;

import entity.User;

import java.util.ArrayList;

public class UserInput {
    private ArrayList<User> users = new ArrayList<User>();

    public String createUser(User newUser){
        users.add(newUser);
        return "\nWelcome to the library " + newUser.getUserName() + "!\n";
    }

}
