package CafeOrderSystem;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {//สร้างคลาส MenuManager
    private List<MenuItem> menuList; //สร้าง menuList แบบ List เก็บอ็อบเจกต์ MenuItem 

    public MenuManager() {
        menuList = new ArrayList<>(); //Collection //สร้าง menuList ให้เป็น ArrayList ว่าง ๆ
        initSampleMenu(); //เรียกการทำงานจาก initSampleMenu()
    }

    private void initSampleMenu() {  //เพิ่มเมนูเครื่องดื่มและขนมลงใน menuList
        //แต่ละเมนูใช้คลาส Coffee หรือ Snack ซึ่งน่าจะสืบทอดจาก MenuItem
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
        System.out.println("\n<<----------|| MENU ||---------->>"); //แสดงข้อความ
        int i = 1;  
        for (MenuItem item : menuList) { //ใช้ for loop เพราะว่าจะได้แสดง MenuItem ได้ครบ 
            System.out.printf("%d. %-15s %6.2f ฿ (%s)\n", i++, item.getName(), item.getPrice(),item.getType());
            //%d = เลขลำดับ, %-15s = ชื่อเมนูเว้นช่องซ้าย, %6.2f = ราคาทศนิยม 2 ตำแหน่ง
            //ใช้ item.getName(), getPrice() และ getType() จาก MenuItem
        }
        
    }

    //เพิ่มคำสั่งซื้อลงตะกร้า
    public MenuItem getMenuItem(int index) {
        if (index >= 1 && index <= menuList.size()) { //รับ index จากผู้ใช้ (เริ่มจาก 1)
            return menuList.get(index - 1); //คืนค่ารายการเมนูตามลำดับ (ใน List เริ่มจาก 0 จึงต้องลบ 1) 
        }
        return null; //ถ้า index ไม่ถูกต้อง → คืนค่า null
    }

    //คืนค่าจำนวนเมนูทั้งหมดที่มีอยู่ใน menuList
    public int getMenuSize() {
        return menuList.size(); 
    }
}
