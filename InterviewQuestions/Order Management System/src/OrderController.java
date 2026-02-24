import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {
    List<Order> orderList;
    Map<Integer,List<Order>> userIdsVsOrders;
    public OrderController(){
        orderList=new ArrayList<>();
        userIdsVsOrders=new HashMap<>();

    }
    public Order createNewOrder(User user,Warehouse warehouse){
        Order order=new Order(user,warehouse);
        orderList.add(order);
        if(userIdsVsOrders.containsKey(user.orderIds)){
            List<Order> userOrders=userIdsVsOrders.get(user.orderIds);
            userOrders.add(order);
            userIdsVsOrders.put(user.userID,userOrders);
        }
        else{
            List<Order> userOrders=new ArrayList<>();
            userOrders.add(order);
            userIdsVsOrders.put(user.userID,userOrders);
        }
        return order;
    }
    public void removeOrder(Order order){
        orderList.remove(order);

    }
    public List<Order> getOrderByCustomerId(int userId){
        return null;
    }
    public Order getOrderByOrderId(int orderId){
        return null;
    }
}
