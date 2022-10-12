package serenityswag;

public class CartItem {

    public String title;
    public String description;
    public double price;

    CartItem(String title, String description, Double price){
        this.title = title;
        this.description = description;
        this.price = price;
    }
}
