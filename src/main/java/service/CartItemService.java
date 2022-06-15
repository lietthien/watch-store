package service;

import java.util.List;

import domain.CartItem;

public interface CartItemService {

	void addProductToCartItem(int quantity, Integer discountprice, int productid, int cartid);

	boolean isProductInCartItem(int productid, int cartid);

	void moreQuantityProductInCartItem(int cartid, int productid);

	List<CartItem> getListItemByCartId(int cartid);

	void subQuantityProductInCartItem(int cartid, int productid);
	
	int getQuantityProductInCartIem(int cartid, int productid);
	
	void deleteProductInCartItem(int cartid, int productid);

	void deleteAllProductInCart(int cartid);

	Integer getTotalQuantity(int cartid);

}
