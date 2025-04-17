package CafeOrderSystem;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private List<MenuItem> menuList;

    public MenuManager() {
        menuList = new ArrayList<>();
        initSampleMenu();
    }

    private void initSampleMenu() {
        // เครื่องดื่ม
        menuList.add(new Coffee("Latte", 50,"Coffee"));
        menuList.add(new Coffee("Espresso", 45,"Coffee"));
        menuList.add(new Coffee("Cappuccino", 55,"Coffee"));
        menuList.add(new Coffee("Americano", 40,"Coffee"));
        menuList.add(new Coffee("Mocha", 60,"Coffee"));

        // ขนม
        menuList.add(new Snack("Brownie", 40,"Snack"));
        menuList.add(new Snack("Croissant", 35,"Snack"));
        menuList.add(new Snack("Muffin", 30,"Snack"));
        menuList.add(new Snack("Cookie", 25,"Snack"));
        menuList.add(new Snack("Donut", 20,"Snack"));
    }
    //แสดงเมนู
    public void showMenu() {
        System.out.println("\n<<----------|| MENU ||---------->>");
        int i = 1;
        for (MenuItem item : menuList) {
            System.out.printf("%d. %-15s %6.2f ฿ (%s)\n", i++, item.getName(), item.getPrice(),item.getType());
        }
        
    }

    public MenuItem getMenuItem(int index) {
        if (index >= 1 && index <= menuList.size()) {
            return menuList.get(index - 1);
        }
        return null;
    }

    public int getMenuSize() {
        return menuList.size();
    }
}
