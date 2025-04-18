package CafeOrderSystem; // MenuItem.java is Interface. Polymorphism

public abstract class MenuItem {
    private String name;
    private double price;
    private String type;

    public MenuItem(String name, double price ,String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public abstract String getCategory(); // Polymorphism

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

