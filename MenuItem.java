package CafeOrderSystem;

public abstract class MenuItem {
    protected String name;
    protected double price;

    public MenuItem (String name, double price){
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }   
    public double getPrice(){
        return price;
    }
    public abstract String getType();

    @Override
    public String toString(){
        return getType() + ": " + name + " - " + price + " ฿ ";
    }
}