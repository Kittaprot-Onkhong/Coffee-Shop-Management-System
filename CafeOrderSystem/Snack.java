package CafeOrderSystem;

public class Snack extends MenuItem{
    public Snack(String name, double price) {
        super(name, price);
    }
    
    @Override
    public String getType(){
        return "Candy";
    }
}
