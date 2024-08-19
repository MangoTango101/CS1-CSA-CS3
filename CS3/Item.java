public class Item {
    private String name;
    private double price;
    private int bulkQty;
    private double bulkPrice;
    public Item(String name, double price)
    {
        this(name,price,0,0);
    }
    public Item(String name, double price, int bulkQty, double bulkPrice)
    {
        if (bulkQty<0 || bulkPrice<0 || price<0){
            throw new IllegalArgumentException("error");
        }
        this.name=name;
        this.price=price;
        this.bulkQty=bulkQty;
        this.bulkPrice=bulkPrice;
    }
    public double priceFor(int quantity)
    {
        if (quantity<0) {
            throw new IllegalArgumentException("error");
        }
        if (quantity >= bulkQty) {
            return quantity * bulkPrice;
        } else {
            return quantity * price;
        }
    }

}
