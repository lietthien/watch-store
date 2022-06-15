package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.CartItem;
import domain.User;
import service.CartItemService;
import service.CartService;

@Controller

public class CartItemController {
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private CartService cartService;
	
	@GetMapping("/user/modifyquantity/plusone/{productid}")
	public String plusProductQuantity(@PathVariable("productid") int productid,HttpSession session, RedirectAttributes redirectAttributes) {
		User user = (User)session.getAttribute("userAccount");
		if(user==null) {
			redirectAttributes.addFlashAttribute("loginFirst", "You have to login first");
			return "redirect:/user/login";
		}
		else {
		double totalprice=0;
		int cartid = cartService.getCartByUser(user.getUserid()).get(0).getCartid();
		cartItemService.moreQuantityProductInCartItem(cartid, productid);
		List<CartItem> cartItemList = cartItemService.getListItemByCartId(cartid);
		for (CartItem cartItem : cartItemList) {
			totalprice = totalprice + (cartItem.getQuantity()*cartItem.getPrice()); 
		}
		cartService.updateCartTotalPrice(cartid, totalprice);
		//tổng product có trong giỏ hàng
		Integer totalQuantity= cartItemService.getTotalQuantity(cartid);
		session.setAttribute("totalQuantity", totalQuantity);
		return "redirect:/user/viewcart";
		}
	}
	
	@GetMapping("/user/modifyquantity/substractone/{productid}")
	public String subProductQuantity(@PathVariable("productid") int productid,HttpSession session, RedirectAttributes redirectAttributes) {
		User user = (User)session.getAttribute("userAccount");
		if(user==null) {
			redirectAttributes.addFlashAttribute("loginFirst", "You have to login first");
			return "redirect:/user/login";
		}
		else {
		double totalprice=0;
		int cartid = cartService.getCartByUser(user.getUserid()).get(0).getCartid();
		cartItemService.subQuantityProductInCartItem(cartid, productid);
		List<CartItem> cartItemList = cartItemService.getListItemByCartId(cartid);
		for (CartItem cartItem : cartItemList) {
			totalprice = totalprice + (cartItem.getQuantity()*cartItem.getPrice()); 
		}
		cartService.updateCartTotalPrice(cartid, totalprice);
		//tổng product có trong giỏ hàng
		Integer totalQuantity= cartItemService.getTotalQuantity(cartid);
		session.setAttribute("totalQuantity", totalQuantity);
		return "redirect:/user/viewcart";
		}
	}
	@GetMapping("/user/deleteproductincart/{productid}")
	public String delelteProducInCart(@PathVariable("productid") int productid,HttpSession session, RedirectAttributes redirectAttributes) {
		User user = (User)session.getAttribute("userAccount");
		if(user==null) {
			redirectAttributes.addFlashAttribute("loginFirst", "You have to login first");
			return "redirect:/user/login";
		}
		else {
		double totalprice=0;
		int cartid = cartService.getCartByUser(user.getUserid()).get(0).getCartid();
		cartItemService.deleteProductInCartItem(cartid, productid);
		List<CartItem> cartItemList = cartItemService.getListItemByCartId(cartid);
		for (CartItem cartItem : cartItemList) {
			totalprice = totalprice + (cartItem.getQuantity()*cartItem.getPrice()); 
		}
		cartService.updateCartTotalPrice(cartid, totalprice);
		//tổng product có trong giỏ hàng
		Integer totalQuantity= cartItemService.getTotalQuantity(cartid);
		session.setAttribute("totalQuantity", totalQuantity);
		return "redirect:/user/viewcart";
		}
		
	}
	
	@GetMapping("/user/deleteallproductincart")
	public String delelteProducInCart(HttpSession session, RedirectAttributes redirectAttributes) {
		User user = (User)session.getAttribute("userAccount");
		if(user==null) {
			redirectAttributes.addFlashAttribute("loginFirst", "You have to login first");
			return "redirect:/user/login";
		}
		else {
			int cartid = cartService.getCartByUser(user.getUserid()).get(0).getCartid();
			cartItemService.deleteAllProductInCart(cartid);
			cartService.updateCartTotalPrice(cartid, 0);
			//tổng product có trong giỏ hàng
			Integer totalQuantity= cartItemService.getTotalQuantity(cartid);
			session.setAttribute("totalQuantity", totalQuantity);
			return "redirect:/user/viewcart";
		}
		}
	
}
