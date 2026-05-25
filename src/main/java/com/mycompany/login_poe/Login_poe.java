/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login_poe;

/**
 *
 * @author matle
 */
import java.util.Scanner;



public class Login_poe {
    static Message app = new Message();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        login authSystem = new login();

        System.out.println("--- WELCOME TO SYSTEM REGISTRATION ---");

        //Capture names from user input
        System.out.print("Enter First Name: ");
        String fName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lName = input.nextLine();
        System.out.print ("enter your South African phone number :");
        //Reprompting Username Loop
        String user = "";
        boolean isUserValid = false;
        while (!isUserValid) {
            System.out.print("\nCreate a Username: ");
            user = input.nextLine();
            
            if (authSystem.checkUserName(user)) {
                System.out.println("Username successfully captured.");
                isUserValid = true;
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }

        //Reprompting Password Loop
        String pass = "";
        boolean isPassValid = false;
        while (!isPassValid) {
            System.out.print("\nCreate a Password: ");
            pass = input.nextLine();
            
            if (authSystem.checkPasswordComplexity(pass)) {
                System.out.println("Password successfully captured.");
                isPassValid = true;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        // Send all info (including your names) to the Login class
        authSystem.registerUser(user, pass, fName, lName);

        //Login Phase
        System.out.println("\n--- LOGIN TO YOUR ACCOUNT ---");
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter Username: ");
            String loginUser = input.nextLine();

            System.out.print("Enter Password: ");
            String loginPass = input.nextLine();

            boolean check = authSystem.loginUser(loginUser, loginPass);
            
            // This will now print "Welcome [Your Name], [Your Last Name]..."
            System.out.println(authSystem.returnLoginStatus(check));
            
            if (check) {
                loggedIn = true; 
                app.run();
            }
        }
        
        input.close();
    }
}