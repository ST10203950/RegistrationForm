//St10203950 Siphesihle Nkambule//
package registraion.form;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegistrationForm {
    public static Map<String, String[]> accounts = new HashMap<>(); // store account info for login

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter a username (must contain an underscore and be no more than 5 characters long): ");
        String username = input.nextLine();
        while (!checkUsername(username)) {
            System.out.print("Enter a valid username (must contain an underscore and be no more than 5 characters long): ");
            username = input.nextLine();
        }
        System.out.print("Enter a password (must be at least 8 characters long, contain a capital letter, a number, and a special character): ");
        String password = input.nextLine();
        while (!checkPasswordComplexity(password)) {
            System.out.print("Enter a valid password (must be at least 8 characters long, contain a capital letter, a number, and a special character): ");
            password = input.nextLine();
        }

        accounts.put(username, new String[]{firstName, lastName, password}); // save account info for login
        System.out.println("Registration successful.");

        // ask user if they want to log in
        System.out.print("Do you want to log in? (y/n): ");
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            System.out.print("Enter your username: ");
            String loginUsername = input.nextLine();
            while (!accounts.containsKey(loginUsername)) {
                System.out.print("Username does not exist. Please enter a valid username: ");
                loginUsername = input.nextLine();
            }
            System.out.print("Enter your password: ");
            String loginPassword = input.nextLine();
            if (authenticate(loginUsername, loginPassword)) {
                String[] userInfo = accounts.get(loginUsername);
                System.out.println("Welcome " + userInfo[0] + " " + userInfo[1] + ", it is great to see you again.");
            } else {
                System.out.println("Username or password incorrect, please try again.");
            }
        }
    }

    public static boolean checkUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            System.out.println("Username successfully captured.");
            return true;
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return false;
        }
    }

    public static boolean checkPasswordComplexity(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        if (password.matches(passwordRegex)) {
            System.out.println("Password successfully captured.");
            return true;
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            return false;
        }
    }

    public static boolean authenticate(String username, String password) {
        if (accounts.containsKey(username) && accounts.get(username)[2].equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
