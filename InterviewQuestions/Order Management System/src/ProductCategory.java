import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    int categoryId;
    String categoryName;
    List<Product> productList=new ArrayList<>();
    double price;

    public ProductCategory(int categoryId, String categoryName,int price) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.price=price;

    }
    public void addProduct(Product product){
        productList.add(product);

    }
    public void removeProduct(int count){
        for(int i=0;i<count;i++){
            productList.remove(0);
        }
    }
}
