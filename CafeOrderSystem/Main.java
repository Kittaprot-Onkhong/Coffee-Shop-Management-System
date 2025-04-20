package CafeOrderSystem;

import java.util.Scanner;

public class Main { //โปรแกรมหลัก
    public static void main(String[] args) {
        MenuManager menuManager = new MenuManager();
        Order order = new Order();
        Scanner scanner = new Scanner(System.in); // Input from keyboard, คำสั่งเปิดรับข้อความ

        System.out.println("Welcome to the Coffee Shop!"); //แสดงข้อคาวม 

        // แสดงเมนูรอบแรก
        menuManager.showMenu(); //เรียกการทำงานจาก .showMenu()ในไฟล์ MenuManager.java
        System.out.println("<<------------------------------->>");

        // ถามผู้ใช้ว่าจะเริ่มสั่งไหม
        String answer = ""; //ประกาศ String answer
        while (!answer.equals("y") && !answer.equals("n")&& !answer.equals("yes") && !answer.equals("no")) { // while loop เพื่อต้องการให้ผู้ใช้ตอบ y/n/yes/no ถ้าตอบนอกจากนี้ระบบก็จะถามซ้ำ
            System.out.print("Would you like to order something? (y/n): "); // แสดงข้อความ
            answer = scanner.nextLine().trim().toLowerCase(); //รับข้อความจากคีย์บอร์ด .trim() คิดกว่าช่องว่างไม่มีอยู่ .toLowerCase() รับตัวพิมใหญ่เปลี่ยนเป็นตัวเล็ก
        if (!answer.equals("y") && !answer.equals("n")&& !answer.equals("yes") && !answer.equals("no")) { //ใช้ if เพื่อดูว่า answer ไม่ใช่ y/n/yes/no รึเปล่า
            System.out.println("Please enter only 'y' or 'n'."); //ถ้าไม่ใช่จะแสดงข้าความและกลับไปใน while loop 
            System.out.println(); // ถ้าเป็น y/n/yes/no จะไปต่อ
            }
        }    
        if (answer.equals("n")||answer.equals("no")) { // if ดูว่าคำตอบเป็น n/no รึเปล่า
            System.out.println("Thank you! Have a nice day :)");// ถ้าใช่ แสดงข้อความ
            return; //จบโปรแกรม
        }

        boolean ordering = true; //ประกาศ boolean ordering เพื่อใช้ใน while loop
        while (ordering) { // while 
            // แสดงเมนูใหม่ทุกครั้ง
            System.out.println(); 
            menuManager.showMenu(); //เรียกการทำงานจาก .showMenu()ในไฟล์ MenuManager.java
            System.out.println("0. Finish");
            System.out.println("11. Edit Order");
            System.out.println("<<------------------------------>>");

            System.out.print("Enter menu number to order: "); //แสดงข้อความถามผู้ใช้
            int choice; //ประกาศ int choice 

            //Exception try catch ใช้ดักจับข้อพิดพลาด 
            try { //ลอง
                choice = Integer.parseInt(scanner.nextLine());//รับค่า int จากคีย์บอร์ด เป็น choice
            } catch (NumberFormatException e) { //ถ้า choice ไม่ได้เป็น 0-11
                System.out.println();
                System.out.println("Invalid input. Please enter a number."); //แสดงข้อความให้เลือก 0-11
                continue; //กลับไปที่ while loop
            }
            
            if (choice == 0) { //ถ้า choice เป็น 0
                // จบการสั่งซื้อ
                break; //หยุด while loop
            } else if (choice == 11) { //ถ้า choice เป็น 11
                // เข้าโหมดแก้ไขออเดอร์
                if (order.isEmpty()) { //ถ้าคำสั่งซื้อว่างเปล่า
                    System.out.println("Your order is empty."); //แสดงข้อความ
                    continue; //กลับไปที่ while loop ให้ตอบ 0-11
                }
                boolean editing = true; //ประกาศ boolean editing
                while (editing) { //while loop editing
                    System.out.println();
                    order.printCurrentOrder();//เรียกการทำงานจาก .printCurrentOrder()ในไฟล์ Order.java
                    System.out.print("Enter the order number to remove (or 0 to stop): ");//แสดงข้อความ
                    int removeChoice; //ประกาศ int removeChoice
                    //Exception try catch ใช้ดักจับข้อพิดพลาด 
                    try {
                        removeChoice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        continue;
                    }
                    if (removeChoice == 0) {
                        break;
                    }
                    if (order.removeItem(removeChoice)) {
                        System.out.println("Item removed.");
                    } else {
                        System.out.println("Invalid item number."); // ใส่เลขเพิ่ม
                    }
                }
                continue; // กลับไปเลือกเมนูใหม่
            }

            // กรณีเลือกเมนูปกติ
            MenuItem selected = menuManager.getMenuItem(choice);
            if (selected != null) {
                order.addItem(selected);
                System.out.println("Added: " + selected.getName());
                System.out.println();
                order.printCurrentOrder();
            } else {
                System.out.println("Invalid menu number.");
                continue;
            }

            // ถามว่าจะเพิ่มเมนูอีกไหม
            System.out.print("Do you want to order more? (y/n): ");
            String more = scanner.nextLine().trim().toLowerCase();
            if (more.equals("y")|| more.equals("yes")) {
                ordering = true;
            } else if (more.equals("n")|| more.equals("no")){
                ordering = false;
            } else {
                System.out.println();
                System.out.println("Please enter only 'y' or 'n'.");
            }
        }

        // แสดงใบเสร็จ
        if (order.isEmpty()) { //ดูคำสำซื้อว่าว่างรึเปล่า
            System.out.println("No order placed. Thank you!"); //ถ้าว่าง 
        } else { 
            order.printReceipt(); // แสดงใบเสร็จบนหน้าจอ 

            // หลังจากแสดงใบเสร็จแล้ว
            ReceiptWriter.writeToFile(order, "receipt.txt");  // ตรวจสอบว่ามีการเรียกฟังก์ชันนี้
        }
    }
}
