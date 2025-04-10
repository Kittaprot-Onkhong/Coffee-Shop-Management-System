package CafeOrderSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuManager menuManager = new MenuManager();
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Coffee Shop!");
        menuManager.showMenu();

        System.out.print("Would you like to order something? (y/n): ");
        String answer = scanner.nextLine().trim().toLowerCase();

        if (!answer.equals("y")) {
            System.out.println("Thank you! Have a nice day :)");
            return;
        }

        while (true) {
            menuManager.showMenu();
            System.out.print("Enter menu number to order (0 to finish): ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (choice == 0) break;

            MenuItem selected = menuManager.getMenuItem(choice);
            if (selected != null) {
                order.addItem(selected);
                System.out.println("Added: " + selected.getName());
            } else {
                System.out.println("Invalid menu number.");
            }
        }

        if (order.isEmpty()) {
            System.out.println("No order placed. Thank you!");
        } else {
            order.printReceipt();
            System.out.println("Thank you for your order!");
        }
    }
}
