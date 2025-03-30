package CafeOrderSystem;

public class Coffee extends MenuItem {
    public Coffee(String name, double price){
        super(name, price);
    }
     
    @Override
    public String getType(){
        return "Coffee";
    }
}
