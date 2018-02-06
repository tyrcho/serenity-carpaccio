package carpaccio;

public class Order {
    private int items;
    private float price;

    public Order setItems(int items) {
        this.items = items;
        return this;
    }

    public Order setPrice(String price) {
        this.price = parsePrice(price);
        return this;
    }

    public String basicPriceFormatted() {
        return formatPrice(basicPrice());
    }

    private float basicPrice() {
        return items * price;
    }

    public float priceWithTax() {
        return basicPrice() * 1.0685F;
    }


    private float parsePrice(String price) {
        return Float.parseFloat(price.replaceAll("\\$", ""));
    }

    private String formatPrice(float price){
        return String.format("%.2f$", price);
    }

}
