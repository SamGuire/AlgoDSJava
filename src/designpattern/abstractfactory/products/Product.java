package designpattern.abstractfactory.products;

public class Product {
    private String productName;
    private int price;

    public Product(String productName,int price) {
        this.productName = productName;
        this.price = price;
    }
    @Override
    public String toString() {
        return String.format("Product: %s\nPrice: %d\n",this.productName,this.price);
    }
}
