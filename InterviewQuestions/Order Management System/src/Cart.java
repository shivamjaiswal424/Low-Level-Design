import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Integer,Integer> productCategoryIdVsCountMap;
    Cart(){
        productCategoryIdVsCountMap=new HashMap<>();
    }
    public void addItemToCart(int productCategoryId,int quantity){
        if(productCategoryIdVsCountMap.containsKey(productCategoryId)){
            int noOfItemsInCart=productCategoryIdVsCountMap.get(productCategoryId);
            productCategoryIdVsCountMap.put(productCategoryId,quantity+noOfItemsInCart);
        }
        else{
            productCategoryIdVsCountMap.put(productCategoryId,quantity);
        }
    }
    public void removeItemFromCart(int productCategoryId,int quantity){
        if(productCategoryIdVsCountMap.containsKey(productCategoryId)) {
            int noOfItemsInCart=productCategoryIdVsCountMap.get(productCategoryId);
            if(quantity<=noOfItemsInCart){
                productCategoryIdVsCountMap.put(productCategoryId,quantity-noOfItemsInCart);
                if (quantity==0){
                    productCategoryIdVsCountMap.remove(productCategoryId);
                }
            }
        }
    }
    public void emptyCart(){
        productCategoryIdVsCountMap.clear();
    }
    public Map<Integer,Integer> getCartItems() {
        return productCategoryIdVsCountMap;
    }
}
