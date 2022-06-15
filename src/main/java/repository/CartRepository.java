package repository;

import java.util.List;

import domain.Cart;
import domain.CartViewData;
import domain.OrderBill;

public interface CartRepository {

	List<Cart> getCartByUser(int userid);

	void createNewCart(Cart cart);

	void updateCartTotalPrice(int cartid, double totalprice);

	List<CartViewData> getCartDetail(int userid);

	void generateBill(OrderBill orderbill);

}
