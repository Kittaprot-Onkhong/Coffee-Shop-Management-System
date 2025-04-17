package CafeOrderSystem;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> orderList;

    public Order() {
        orderList = new ArrayList<>();
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
            System.out.printf("%d. %-15s %6.2f ฿\n", i++, item.getName(), item.getPrice());
            total += item.getPrice();
        }
        System.out.println("------------------------");
        System.out.printf("Total:            %.2f ฿\n", total);
        System.out.println("========================\n");
    }

    // แสดงรายการปัจจุบันในตะกร้า
    public void printCurrentOrder() {
        System.out.println("------- Current Order -------");
        double total = 0;
        int i = 1;
        for (MenuItem item : orderList) {
            System.out.printf("%d. %-15s %6.2f ฿\n", i++, item.getName(), item.getPrice());
            total += item.getPrice();
        }
        System.out.println("-----------------------------");
    }
    
    // ลบรายการในตะกร้า โดยใช้หมายเลขรายการ (ที่แสดงให้ลูกค้าเห็นเริ่มที่ 1)
    public boolean removeItem(int index){
        if (index >= 1 && index <= orderList.size()) {
            orderList.remove(index - 1);
            return true;
        }
        return false;
        
    }
    public List<MenuItem> getItems() { 
        return orderList; 
    }
}
