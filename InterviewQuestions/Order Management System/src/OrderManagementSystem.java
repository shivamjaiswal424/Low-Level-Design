import java.util.List;

public class OrderManagementSystem {
    UserController userController;
    OrderController orderController;
    WarehouseController warehouseController;

    OrderManagementSystem(List<User> userList,List<Warehouse> warehouseList){
        userController = new UserController(userList);
        warehouseController=new WarehouseController(warehouseList,new NearestWarehouseSelectionStrategy());
        orderController=new OrderController();
    }
    public User getUser(int userId){
        return userController.getUser(userId);
    }
    public Warehouse getWarehouse(WarehouseSelectionStrategy selectionStrategy){
        return warehouseController.selectWarehouse(selectionStrategy);
    }
    public Inventory getInventory(Warehouse warehouse){
        return warehouse.inventory;
    }
    public void addProductToCart(User user,ProductCategory productCategory,int count){
        Cart cart =user.getUserCart();
        cart.addItemToCart(productCategory.categoryId,count);

    }
    public Order placeOrder(User user,Warehouse warehouse){
        return orderController.createNewOrder(user,warehouse);

    }
    public void checkout(Order order){
        order.checkOut();
    }
}
