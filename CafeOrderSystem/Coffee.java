package CafeOrderSystem; // Coffee.java is Inheritance Polymorphism

//สร้าง คลาส Coffee ซึ่งเป็น subclass ที่สืบทอด (extends) มาจาก MenuItem superclass
public class Coffee extends MenuItem {

    //หมายความว่า Coffee จะมีคุณสมบัติ (fields) และพฤติกรรม (methods) ที่ MenuItem มีอยู่แล้ว
    public Coffee(String name, double price ,String type) { //ใช้คำสั่ง superเพื่อเรียก constructor ของคลาส MenuItem 
        super(name, price, type );// แล้วส่งค่า name, price, type ไปกำหนดใน MenuItem
    }

    @Override //ใช้คำสั่ง @Override เพื่อระบุว่าเรากำลัง เขียนทับเมธอด getCategory() ที่อยู่ในคลาส MenuItem
    public String getCategory() { //ถูกเรียกจาก MenuItem
        return "Coffee"; // คืนค่า Coffee 
    }
}

