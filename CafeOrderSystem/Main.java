package CafeOrderSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuManager menuManager = new MenuManager();
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Coffee Shop!");

        // แสดงเมนูรอบแรก
        menuManager.showMenu();
        System.out.println("<<------------------------------->>");

        // ถามลูกค้าว่าจะเริ่มสั่งไหม
        String answer = "";
        while (!answer.equals("y") && !answer.equals("n")) {
            System.out.print("Would you like to order something? (y/n): ");
            answer = scanner.nextLine().trim().toLowerCase();
        if (!answer.equals("y") && !answer.equals("n")) {
            System.out.println("Please enter only 'y' or 'n'.");
            System.out.println();
            }
        }

        if (!answer.equals("y")) {
            System.out.println("Thank you! Have a nice day :)");
            return;
        }

        boolean ordering = true;
        while (ordering) {
            // แสดงเมนูใหม่ทุกครั้ง
            System.out.println();
            menuManager.showMenu();
            System.out.println("0. Finish");
            System.out.println("11. Edit Order");
            System.out.println("<<------------------------------>>");

            System.out.print("Enter menu number to order: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (choice == 0) {
                // จบการสั่งซื้อ
                break;
            } else if (choice == 11) {
                // เข้าโหมดแก้ไขออเดอร์
                if (order.isEmpty()) {
                    System.out.println("Your order is empty.");
                    continue;
                }
                boolean editing = true;
                while (editing) {
                    System.out.println("\nCurrent Order:");
                    order.printCurrentOrder();
                    System.out.print("Enter the order number to remove (or 0 to stop): ");
                    int removeChoice;
                    try {
                        removeChoice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        continue;
                    }
                    if (removeChoice == 0) {
                        break;
                    }
                    if (order.removeItem(removeChoice)) {
                        System.out.println("Item removed.");
                    } else {
                        System.out.println("Invalid item number.");
                    }
                }
                continue; // กลับไปเลือกเมนูใหม่
            }

            // กรณีเลือกเมนูปกติ
            MenuItem selected = menuManager.getMenuItem(choice);
            if (selected != null) {
                order.addItem(selected);
                System.out.println("Added: " + selected.getName());
                System.out.println("\nCurrent Order:");
                order.printCurrentOrder();
            } else {
                System.out.println("Invalid menu number.");
                continue;
            }

            // ถามว่าจะเพิ่มเมนูอีกไหม
            System.out.print("Do you want to order more? (y/n): ");
            String more = scanner.nextLine().trim().toLowerCase();
            if (!more.equals("y")) {
                ordering = false;
            }
        }

        // แสดงใบเสร็จ
        if (order.isEmpty()) {
            System.out.println("No order placed. Thank you!");
        } else {
            order.printReceipt();
            System.out.println("Thank you for your order!");
        }
    }
}
