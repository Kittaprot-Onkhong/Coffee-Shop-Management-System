package CafeOrderSystem; 
// MenuItem.java is Interface. Polymorphism
// เป็น abstract class ไม่สามารถสร้าง object ได้โดยตรง แต่จะมีsubclass มาสืบทอด
public abstract class MenuItem {

    //เป็นตัวแปร private ใช้เก็บข้อมูลของแต่ละเมนู
    private String name; // ชื่อเมนู
    private double price; // ราคาของเมนู
    private String type; // ประเภท เช่น "Coffee" หรือ "Snack"

    public MenuItem(String name, double price ,String type) { //ตัวสร้าง (constructor) ใช้กำหนดค่าเริ่มต้นให้กับ object เมื่อลูกคลาสเรียกใช้งาน
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public abstract String getCategory(); // Polymorphism
    //ลูกคลาส เช่น Coffee หรือ Snack จะต้องเขียนเมธอดนี้ขึ้นมาใหม่ (Override)
    
    //เป็น getter สำหรับเข้าถึงค่าของ name, price, และ type จากภายนอก
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    public String getType() {
        return type;
    }
}

