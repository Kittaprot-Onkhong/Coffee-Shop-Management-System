package CafeOrderSystem; //Snack.java is Inheritance Polymorphism

public class Snack extends MenuItem {
    public Snack(String name, double price ,String type) {
        super(name, price,type);
    }

    @Override
    public String getCategory() { //มาถูกเรียกจาก MenuManger
        return "Snack"; // override แสดงหมวด
    }
}
//เหมือนกันกลับ Coffee
