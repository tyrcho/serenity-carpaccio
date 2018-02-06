package carpaccio;

public class Order {
    private int items;
    private float price;
    private float taxRate = 0.0685F;

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

    public String taxRateFormatted() {
        return String.format("%.2f%%", taxRate * 100).replace(",", ".");
    }

    public String priceWithTaxFormatted() {
        return formatPrice(priceWithTax());
    }

    public String taxAmountFormatted() {
        return formatPrice(taxAmount());
    }

    float taxAmount() {
        return basicPrice() * taxRate;
    }

    float basicPrice() {
        return items * price;
    }

    float priceWithTax() {
        return basicPrice() + taxAmount();
    }


    float parsePrice(String price) {
        return Float.parseFloat(price.replaceAll("\\$", ""));
    }

    String formatPrice(float price) {
        return String.format("%.2f$", price).replace(",", ".");
    }


}
