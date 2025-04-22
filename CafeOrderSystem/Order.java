package CafeOrderSystem;

import java.util.ArrayList;
import java.util.List;

public class Order { //สร้างคลาส Order
    private List<MenuItem> orderList; //สร้าง orderList แบบ List เก็บอ็อบเจกต์ MenuItem

    public Order() {
        orderList = new ArrayList<>(); //สร้าง menuList ให้เป็น ArrayList ว่าง ๆ
    }

    //เพิ่มของ
    public void addItem(MenuItem item) {
        orderList.add(item);
    }

    //เช็คค่าว่างไหม
    public boolean isEmpty() {
        return orderList.isEmpty();
    }

     // แสดงใบเสร็จ 
    public void printReceipt() {
        System.out.println("\n======= RECEIPT =======");
        double total = 0;
        int i = 1;
        for (MenuItem item : orderList) {
            System.out.printf("%d. %-15s %6.2f ฿\n", i++, item.getName(), item.getPrice());//สิ่นค้าที่เลือก
            //%d = เลขลำดับ, %-15s = ชื่อเมนูเว้นช่องซ้าย, %6.2f = ราคาทศนิยม 2 ตำแหน่ง
            //ใช้ item.getName()และ grtPrice() จาก Menuitem
            total += item.getPrice(); //คำนวนผลรวม ของ item.getPrice() ให้เป็น total
        }
        System.out.println("------------------------");
        System.out.printf("Total:            %.2f ฿\n", total);//แสดงค่าใช้จ่ายทั้งหมด
        System.out.println("========================\n");
    }

    // แสดงรายการปัจจุบันในตะกร้า
    public void printCurrentOrder() {
        System.out.println("------- Current Order -------");
        double total = 0;
        int i = 1;
        for (MenuItem item : orderList) {
            System.out.printf("%d. %-15s %6.2f ฿\n", i++, item.getName(), item.getPrice());
           //%d = เลขลำดับ, %-15s = ชื่อเมนูเว้นช่องซ้าย, %6.2f = ราคาทศนิยม 2 ตำแหน่ง
            //ใช้ item.getName()และ grtPrice() จาก Menuitem
            total += item.getPrice(); //คำนวนผลรวม ของ item.getPrice() ให้เป็น total
        }
        System.out.println("-----------------------------");
    }
    
    // ลบรายการในตะกร้า โดยใช้หมายเลขรายการ (ที่แสดงให้ลูกค้าเห็นเริ่มที่ 1)
    public boolean removeItem(int index){
        if (index >= 1 && index <= orderList.size()) { //ถ้า index อยู่ในช่วง มากกว่าหรือเท่ากับ 1 และไม่เกินขนาดของรายการ(orderList.size)
            orderList.remove(index - 1); //ถ้าอยู่ในช่วงที่ถูกต้อง ก็ลบรายการ (index - 1) เพราะ list เริ่มจาก 0
            return true;//คืนค่า true ถ้าลบสำเร็จ
        }
        return false; //false ถ้าไม่สำเร็จ
        
    }
    public List<MenuItem> getItems() { //ใช้คืนค่ารายการสินค้า (MenuItem) ทั้งหมดในออเดอร์ 
        return orderList; //เป็น List<MenuItem>
    }
}
