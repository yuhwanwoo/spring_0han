package hello.core.order;

public interface OrderService {
    Order createOrder(Long memwberId, String itemName, int itemPrice);
}
