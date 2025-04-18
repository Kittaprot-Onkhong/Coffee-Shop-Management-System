package CafeOrderSystem; //Write from file 

import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;


public class ReceiptWriter { 
    public static void writeToFile(Order order, String filename) { 
        try {
            FileWriter writer = new FileWriter(filename);  // เปิดไฟล์สำหรับเขียน
            writer.write("========= Coffee Shop Receipt =========\n");
            writer.write("Date: " + 
    ZonedDateTime.now(ZoneId.of("Asia/Bangkok"))
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("----------------------------------------\n");
    
            List<MenuItem> items = order.getItems();
            double total = 0;
    
            for (int i = 0; i < items.size(); i++) {
                MenuItem item = items.get(i);
                writer.write((i + 1) + ". " + item.getName() + "\t" + String.format("%.2f", item.getPrice()) + " ฿\n");
                total += item.getPrice();
            }
    
            writer.write("----------------------------------------\n");
            writer.write("Total: " + String.format("%.2f", total) + " ฿\n");
            writer.write("Thank you for your order! 😊\n");
    
            writer.close();  // ปิดไฟล์หลังการเขียน
            System.out.println("Receipt saved to " + filename);  // แจ้งให้ผู้ใช้ทราบ
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }
}

