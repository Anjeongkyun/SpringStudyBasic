package hello.core.discount.order;

public interface OrderService {

    Order craeteOrder(Long memberId, String itemName, int itemPrice);
}
