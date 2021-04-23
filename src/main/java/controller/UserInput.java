package controller;

import entity.User;

import java.util.ArrayList;

public class UserInput {
    private ArrayList<User> users = new ArrayList<User>();

    public String createUser(User newUser){
        users.add(newUser);
        return "\nWelcome to the library " + newUser.getUserName() + "!";
    }
    public String removeUser(int userId){
        try {
            users.remove(userId);
        }catch (Exception ex){
            return "Unable to remove user";
        }
        return "User removed successfully!\n";
    }
}
