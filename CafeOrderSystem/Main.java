package CafeOrderSystem;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuManager menuManager = new MenuManager();
        // menuManager.loadMenu();//อันนี้คือโหลดเมนูจากไฟล์มา
    
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Shop system ===");
            System.out.println("1.Show product menu");
            System.out.println("2.Log out");
            System.out.print("Select menu: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    menuManager.showMenu();
                    break;
                case "2":
                    System.out.println("Log out...");
                    return;
                default:
                    System.out.println("Selected the wrong menu!");
            }
        }
    }
}
