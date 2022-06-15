package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Cart;
import domain.CartViewData;
import domain.OrderBill;
import repository.CartRepository;

@Service
public class CartServiceIpm implements CartService {
@Autowired
private CartRepository cartRepository;
	
	@Override
	public List<Cart> getCartByUser(int userid) {
		return cartRepository.getCartByUser(userid);
	}

	@Override
	public void createNewCart(Cart cart) {
		cartRepository.createNewCart(cart);
		
	}

	@Override
	public void updateCartTotalPrice(int cartid, double totalprice) {
		cartRepository.updateCartTotalPrice(cartid, totalprice);
		
	}

	@Override
	public List<CartViewData> getCartDetail(int userid) {
		return cartRepository.getCartDetail(userid);
	}

	@Override
	public void generateBill(OrderBill orderbill) {
		cartRepository.generateBill(orderbill);
	}

}
