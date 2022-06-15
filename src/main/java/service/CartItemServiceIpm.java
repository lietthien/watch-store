package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.CartItem;
import repository.CartItemRepository;

@Service
public class CartItemServiceIpm implements CartItemService{
@Autowired
private CartItemRepository cartItemRepository;

@Override
public void addProductToCartItem(int quantity, Integer discountprice, int productid, int cartid) {
	
	cartItemRepository.addProductToCartItem(quantity, discountprice, productid, cartid);
	
}

@Override
public boolean isProductInCartItem(int productid, int cartid) {
	int row=cartItemRepository.getProductInCartItem(productid, cartid);
	if (row!=0) {
		return true;
	} else {
		return false;
	}
}

@Override
public void moreQuantityProductInCartItem(int cartid, int productid) {
	cartItemRepository.moreQuantityProductInCartItem(cartid, productid);
	
}

@Override
public List<CartItem> getListItemByCartId(int cartid) {
	return cartItemRepository.getListItemByCartId(cartid);
}

@Override
public int getQuantityProductInCartIem(int cartid, int productid) {
	return cartItemRepository.getQuantityProductInCartIem(cartid, productid);
}

@Override
public void subQuantityProductInCartItem(int cartid, int productid) {
	cartItemRepository.subQuantityProductInCartItem(cartid, productid);
	int quantity = cartItemRepository.getQuantityProductInCartIem(cartid, productid);
	if(quantity==0) {
		deleteProductInCartItem(cartid, productid);
	}
	
}

@Override
public void deleteProductInCartItem(int cartid, int productid) {
	cartItemRepository.deleteProductInCartItem(cartid, productid);
	
}

@Override
public void deleteAllProductInCart(int cartid) {
	cartItemRepository.deleteAllProductInCart(cartid);
	
}

@Override
public Integer getTotalQuantity(int cartid) {
	return cartItemRepository.getTotalQuantity(cartid);
}


}
