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
        return formatPercent(taxRate());
    }

    public String priceWithTaxFormatted() {
        return formatPrice(priceWithTax());
    }

    public String taxAmountFormatted() {
        return formatPrice(taxAmount());
    }

    public String discountRateFormatted() {
        return formatPercent(discountRate());
    }

    public String discountAmountFormatted() {
        return formatPrice(discountAmount());
    }


    public String discountedPriceFormatted() {
        return formatPrice(discountedPrice());
    }

    float discountedPrice() {
        return basicPrice() - discountAmount();
    }

    float discountRate() {
        if (basicPrice() < 1000) return 0;
        else if (basicPrice() < 5000) return 0.03F;
        else if (basicPrice() < 7000) return 0.05F;
        else if (basicPrice() < 10000) return 0.07F;
        else if (basicPrice() < 50000) return 0.10F;
        else return 0.15F;
    }

    float discountAmount() {
        return discountRate() * basicPrice();
    }

    float taxRate() {
        switch (state) {
            case "UT":
                return 0.0685F;
            case "NV":
                return 0.08F;
            case "TX":
                return 0.0625F;
            case "AL":
                return 0.04F;
            case "CA":
                return 0.0825F;
            default:
                throw new IllegalArgumentException("Unknown state: " + state);
        }
    }

    float taxAmount() {
        return discountedPrice() * taxRate();
    }

    float basicPrice() {
        return items * price;
    }

    float priceWithTax() {
        return discountedPrice() + taxAmount();
    }


    float parsePrice(String price) {
        return Float.parseFloat(price.replaceAll("\\$", ""));
    }

    String formatPrice(float price) {
        float rounded = Math.round(price * 100) / 100F;
        return String.format("%.2f$", rounded).replace(",", ".");
    }


    private String formatPercent(float rate) {
        return String.format("%.2f%%", rate * 100).replace(",", ".");
    }

}
