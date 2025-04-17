package CafeOrderSystem;

public class Snack extends MenuItem {
    public Snack(String name, double price ,String type) {
        super(name, price,type);
    }

    @Override
    public String getCategory() {
        return "Snack"; // override แสดงหมวด
    }
}

