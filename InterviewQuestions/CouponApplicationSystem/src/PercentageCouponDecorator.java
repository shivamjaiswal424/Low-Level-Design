public class PercentageCouponDecorator extends CouponDecorator{
    public PercentageCouponDecorator(Product product, int discountPercent) {
        super(product, discountPercent);
    }
    @Override
    public double getPrice(){
        double price=this.product.getOriginalPrice();
        double priceAfterDiscount=price - (price * discountPercent) / 100;
        System.out.println("Applying percentage coupon of " + discountPercent + "% on " + product.getName() + ", original price : " + price + ", price after discount : " + priceAfterDiscount);
        return priceAfterDiscount;
    }
}
