package CafeOrderSystem; // Coffee.java is Inheritance Polymorphism

public class Coffee extends MenuItem {
    public Coffee(String name, double price ,String type) {
        super(name, price, type );
    }

    @Override
    public String getCategory() {
        return "Coffee"; // override แสดงหมวด
    }
}

