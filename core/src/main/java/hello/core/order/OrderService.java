package hello.core.order;

public interface OrderService {

    Order craeteOrder(Long memberId, String itemName, int itemPrice);
}
