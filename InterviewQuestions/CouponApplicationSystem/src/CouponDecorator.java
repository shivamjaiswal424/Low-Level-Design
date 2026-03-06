public abstract class CouponDecorator extends Product{
   Product product;
   int discountPercent;
   public CouponDecorator(Product product, int discountPercent) {
       super(product.getName(), product.getOriginalPrice(), product.getProductType());
       this.product = product;
       this.discountPercent = discountPercent;
   }

    @Override
    public double getPrice() {
        return 0;
    }
}
