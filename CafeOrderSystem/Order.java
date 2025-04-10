package CafeOrderSystem;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> orderList;

    public Order() {
        orderList = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        orderList.add(item);
    }

    public boolean isEmpty() {
        return orderList.isEmpty();
    }

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
}
