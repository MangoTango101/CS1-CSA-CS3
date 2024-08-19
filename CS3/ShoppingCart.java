import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<ItemOrder> orders;

    public ShoppingCart() {
        orders = new ArrayList<ItemOrder>();
    }

    public void add(ItemOrder newOrder) {
        // Check if an order for the same item already exists
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getItem().equals(newOrder.getItem())) {
                orders.set(i, newOrder); // Replace the existing order
                return;
            }
        }

        // If no existing order found, add the new order
        orders.add(newOrder);
    }

    public double getTotal() {
        double totalCost = 0.0;
        for (ItemOrder order : orders) {
            totalCost += order.getPrice();
        }
        return totalCost;
    }
}

