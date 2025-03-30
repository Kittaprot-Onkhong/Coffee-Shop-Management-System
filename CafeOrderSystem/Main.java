package CafeOrderSystem;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuManager menuManager = new MenuManager();
        // menuManager.loadMenu();//อันนี้คือโหลดเมนูจากไฟล์มา
    
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Shop system ===");
            System.out.println("1. แสดงเมนูสินค้า / Show product menu");
            System.out.println("2. ออกจากระบบ / Log out");
            System.out.println("เลือกเมนู / Select menu:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    menuManager.showMenu();
                    break;
                case 2:
                    System.out.println("ออกจากระบบ / Log out...");
                    return;
                default:
                    System.out.println("เลือกเมนูไม่ถูกต้อง / Selected the wrong menu!");
            }
        }
    }
}
