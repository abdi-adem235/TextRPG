package project.packages.textrpg.game;

import java.util.Map;
import java.util.Scanner;

import project.packages.textrpg.utilities.ValidateUser;

public class StartGame {
    private ValidateUser validateUser;
    private Scanner scanner;

    public StartGame() {
        validateUser = new ValidateUser();
        validateUser.loadUsers();
        scanner = new Scanner(System.in);
    }

    public void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (validateUser.validateUser(username, password)) {
            System.out.println("Login successful! Welcome, " + username + "!");
            // Proceed with the game...
        } else {
            System.out.println("Invalid username or password. Please try again.");
            login(); // Retry login
        }
    }
    
    public Map<String, String> getUserMap() {
        return ValidateUser.getUserMap(); // Return the userMap
    }

    public static void main(String[] args) {
        StartGame game = new StartGame();
        game.login();
    }
}
