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

        // แสดงเมนูแค่ครั้งเดียว
            menuManager.showMenu();
            System.out.println("<<----------|----+----|-------->>");
            System.out.println("           | 0. Finish |           ");
            System.out.println("<<----------|----+----|--------->>");

        while (true) {

            // ข้อความที่ให้ลูกค้าเลือกเมนู
            System.out.print("Enter menu number to order : ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (choice == 0) break; // เมื่อเลือก 0 จะออกจากลูป

            MenuItem selected = menuManager.getMenuItem(choice);
            if (selected != null) {
                order.addItem(selected);
                System.out.println("Added: " + selected.getName());
                System.out.println("\nCurrent Order:");
                order.printCurrentOrder(); // ตะกร้าสินค้า
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
