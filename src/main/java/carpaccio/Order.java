package carpaccio;

public class Order {
    private int items;
    private float price;
    private String state = "UT";

    public Order setItems(int items) {
        this.items = items;
        return this;
    }

    public Order setPrice(String price) {
        this.price = parsePrice(price);
        return this;
    }

    public Order setState(String state) {
        this.state = state;
        return this;
    }

    public String basicPriceFormatted() {
        return formatPrice(basicPrice());
    }

    public String taxRateFormatted() {
        return String.format("%.2f%%", taxRate() * 100).replace(",", ".");
    }

    public String priceWithTaxFormatted() {
        return formatPrice(priceWithTax());
    }

    public String taxAmountFormatted() {
        return formatPrice(taxAmount());
    }

    float taxRate() {
        switch (state) {
            case "UT":
                return 0.0685F;
            case "NV":
                return 0.08F;
            default:
                throw new IllegalArgumentException("Unknown state: " + state);
        }
    }

    float taxAmount() {
        return basicPrice() * taxRate();
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
