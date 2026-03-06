import java.util.ArrayList;
import java.util.List;

public class TypeCouponDecorator extends CouponDecorator{
    static List<ProductType> eligibleTypes = new ArrayList<ProductType>();
    static {
        eligibleTypes.add(ProductType.FURNITURE);
        eligibleTypes.add(ProductType.ELECTRONICS);
    }
    public TypeCouponDecorator(Product product, int discountPercent) {
        super(product, discountPercent);
    }
    @Override
    public double getPrice(){
        double price = this.product.getPrice();
        if (eligibleTypes.contains(this.product.getProductType())) {
            double priceAfterDiscount = price - (price * discountPercent) / 100;
            System.out.println("Applying specific product type coupon of " + discountPercent + "% on " + product.getName() + ", original price : " + price + ", price after discount : " + priceAfterDiscount);
            return priceAfterDiscount;
        }
        return price;

    }
}
