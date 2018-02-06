package carpaccio;

public class Order {
    private int items;
    private int price;

    public Order setItems(int items) {
        this.items = items;
        return this;
    }

    public Order setPrice(int price) {
        this.price = price;
        return this;
    }

    public int basicPrice() {
        return items * price;
    }
}
