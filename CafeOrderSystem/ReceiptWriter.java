package CafeOrderSystem; //Write from file 

import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;


public class ReceiptWriter { //คลาสชื่อ ReceiptWriter มีหน้าที่ เขียนใบเสร็จลงไฟล์
    public static void writeToFile(Order order, String filename) { //รับ Order และ ชื่อไฟล์ ที่จะเขียน
        //try กันข้อผิดพลาด
        try {//ลอง
            FileWriter writer = new FileWriter(filename);  // เปิดไฟล์สำหรับเขียน
            writer.write("========= Coffee Shop Receipt =========\n");
            writer.write("Date: " + 
    ZonedDateTime.now(ZoneId.of("Asia/Bangkok")) //เขียนวันที่ปัจจุบันโดยใช้ ZonedDateTime
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n"); //format ให้อยู่ในรูปแบบ yyyy-MM-dd HH:mm:ss
            writer.write("----------------------------------------\n");
    
            List<MenuItem> items = order.getItems();
            double total = 0;
            
            //วนลูปรายการสินค้า และเขียนชื่อ + ราคา ลงใบเสร็จ
            for (int i = 0; i < items.size(); i++) { 
                MenuItem item = items.get(i);
                writer.write((i + 1) + ". " + item.getName() + "\t" + String.format("%.2f", item.getPrice()) + " ฿\n");
                total += item.getPrice();
            }
            
            //คำนวณและเขียนยอดรวม (Total)
            writer.write("----------------------------------------\n");
            writer.write("Total: " + String.format("%.2f", total) + " ฿\n");
            writer.write("Thank you for your order! 😊\n");//แสดงข้อความขอบคุณ
    
            writer.close();  // ปิดไฟล์หลังการเขียน
            System.out.println("Receipt saved to " + filename);  // แจ้งให้ผู้ใช้ทราบ
            System.out.println();
        } catch (IOException e) { //ถ้ามีปัญหา เช่น เขียนไฟล์ไม่ได้ จะ catch exception
            System.out.println("Error writing receipt: " + e.getMessage()); //แสดงข้อความผิดพลาด
        }
    }
}

