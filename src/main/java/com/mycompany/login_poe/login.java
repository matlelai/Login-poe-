/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login_poe;

//import java.util.regex.Pattern;

/**
 *
 * @author matle
 */
  
public class login {

    private String registeredUsername;
    private String registeredPassword;
    private String userFirstName;
    private String userLastName;

    public boolean checkUserName(String username) {
        boolean hasUnderscore = false;
        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == '_') {
                hasUnderscore = true;
                break;
            }
        }
        return hasUnderscore && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) return false;

        boolean hasCaps = false;
        boolean hasNum = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) hasCaps = true;
            else if (Character.isDigit(c)) hasNum = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasCaps && hasNum && hasSpecial;
    }

    // Updated to accept and save your First and Last name
    public void registerUser(String username, String password, String firstName, String lastName) {
        this.registeredUsername = username;
        this.registeredPassword = password;
        this.userFirstName = firstName;
        this.userLastName = lastName;
    }

    public boolean loginUser(String username, String password) {
        if (registeredUsername == null) return false;
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }

    // Now uses the names you entered during registration
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + userFirstName + ", " + userLastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}