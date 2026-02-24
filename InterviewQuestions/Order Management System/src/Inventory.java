import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
    List<ProductCategory> productCategoryList;
    Inventory(){
        productCategoryList=new ArrayList<ProductCategory>();
    }
    public void addCategory(int categoryId,String categoryName,int price){
        ProductCategory productCategory=new ProductCategory(categoryId,categoryName,price);
        productCategoryList.add(productCategory);

    }
    public void addProduct(Product product,int productCategoryId){
        ProductCategory productCategory=null;
        for(ProductCategory pc:productCategoryList){
            if (pc.categoryId==productCategoryId){
                productCategory=pc;
            }
        }
        if(productCategory!=null){
            productCategory.addProduct(product);
        }
    }
    public void removeItems(Map<Integer,Integer> ProductCategoryAndCountMap){
        for(Map.Entry<Integer,Integer> entry:ProductCategoryAndCountMap.entrySet()){
            ProductCategory productCategory=getProductCategoryFromId(entry.getKey());
            productCategory.removeProduct(entry.getValue());
        }
    }
    public ProductCategory getProductCategoryFromId(int productCategoryId){
        for(ProductCategory productCategory:productCategoryList){
            if(productCategory.categoryId==productCategoryId){
                return productCategory;
            }
        }
        return null;
    }
}
