package CafeOrderSystem;

// MenuManager.java
// import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private List<MenuItem> menuList = new ArrayList<>();

    public MenuManager() {
        // เพิ่มเมนูโดยตรง (ไม่ต้องใช้ไฟล์)
        menuList.add(new Coffee("Latte", 50));
        menuList.add(new Coffee("Espresso", 40));
        menuList.add(new Snack("Croissant", 30));
        menuList.add(new Snack("Cake", 45));
    }

    public void showMenu() {
        System.out.println("=== เมนูสินค้า ===");
        for (MenuItem item : menuList) {
            System.out.println(item.getName() + " - " + item.getPrice() + " บาท");
        }
    }
    
    // private final String MENU_FILE = "C:\\Users\\Escanor K\\CafeOrderSystem\\menu.txt"; // สำหรับ Windows
    // public void loadMenu() {
    //     try (BufferedReader br = new BufferedReader(new FileReader(MENU_FILE))) {
    //         String line;
    //         while ((line = br.readLine()) != null) {
    //             String[] parts = line.split(",");
    //             if (parts.length == 3) {
    //                 String type = parts[0].trim();
    //                 String name = parts[1].trim();
    //                 double price = Double.parseDouble(parts[2].trim());

    //                 if (type.equalsIgnoreCase("Coffee")) {
    //                     menuItems.add(new Coffee(name, price));
    //                 } else if (type.equalsIgnoreCase("Snack")) {
    //                     menuItems.add(new Snack(name, price));
    //                 }
    //             }
    //         }
    //     } catch (IOException e) {
    //         System.out.println("เกิดข้อผิดพลาดในการโหลดเมนู: " + e.getMessage());
    //     } 
    // }
    // public void displayMenu() {
    //     System.out.println("\n--- เมนูสินค้า ---");
    //     for (MenuItem item : menuItems) {
    //         System.out.println(item);
    //     }
    // }
    // public List<MenuItem> getMenuItems() {
    //     return menuItems;
    // }
}
