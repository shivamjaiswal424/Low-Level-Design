public abstract class Product {
    String name;
    double originalPrice;
    ProductType productType;
    public Product(String name, double originalPrice, ProductType productType) {
        this.name = name;
        this.originalPrice = originalPrice;
        this.productType = productType;
    }
    public abstract double getPrice();
    public ProductType getProductType() {
        return productType;
    }
    public String getName() {
        return name;
    }
    public double getOriginalPrice() {
        return originalPrice;
    }
}
