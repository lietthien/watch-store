package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.Cart;
import domain.CartItem;
import domain.CartViewData;
import domain.OrderBill;
import domain.Product;
import domain.User;
import service.CartItemService;
import service.CartService;
import service.ProductService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private ProductService productService;

	@GetMapping("/user/viewcart")
	public String cartView(HttpSession session, RedirectAttributes redirectAttributes, Model model) {
		User user = (User) session.getAttribute("userAccount");
		if (user == null) {
			redirectAttributes.addFlashAttribute("loginFirst", "You have to login first");
			return "redirect:/user/login";
		} else {
			List<Cart> listCart = cartService.getCartByUser(user.getUserid());
			List<CartViewData> cartViewDataList = cartService.getCartDetail(user.getUserid());
			if (listCart.size() == 0 || cartViewDataList.size() == 0) {
				model.addAttribute("emptycart", "Yon don't have any product in your cart");
				return "cart";
			} else {
				model.addAttribute("cartViewDataList", cartViewDataList);
				return "cart";
			}
		}
	}

	@GetMapping("/user/addtocart/{productid}")
	public String addProductToCart(@PathVariable("productid") int productid, HttpSession session,
			RedirectAttributes redirectAttributes) {
		User user = (User) session.getAttribute("userAccount");
		if (user == null) {
			redirectAttributes.addFlashAttribute("loginFirst", "You have to login first");
			return "redirect:/user/login";
		} else {
			// check if user have a cart?(have not add any product into cart)
			List<Cart> listCart = cartService.getCartByUser(user.getUserid());
			Product product = productService.getProductById(productid);
			if (listCart.size() == 0) {
				Cart cart = new Cart();
				cart.setUserid(user.getUserid());
				cartService.createNewCart(cart);
				Cart cartOfUser = cartService.getCartByUser(user.getUserid()).get(0);
				cartItemService.addProductToCartItem(1, product.getDiscountprice(), productid, cartOfUser.getCartid());
				cartService.updateCartTotalPrice(cartOfUser.getCartid(), product.getDiscountprice());
				//tổng product có trong giỏ hàng
				Integer totalQuantity= cartItemService.getTotalQuantity(cartOfUser.getCartid());
				session.setAttribute("totalQuantity", totalQuantity);
				return "redirect:/product/detail/" + productid;
			} else {
				// check if product has exist in cart?
				// if not=>add new
				// if already exist=>increase the quantity
				Cart cart = listCart.get(0);
				boolean isProductInCartItem = cartItemService.isProductInCartItem(productid, cart.getCartid());
				double totalprice = 0;
				// product is in cart
				if (isProductInCartItem == true) {
					cartItemService.moreQuantityProductInCartItem(cart.getCartid(), productid);
					List<CartItem> cartItemList = cartItemService.getListItemByCartId(cart.getCartid());
					for (CartItem cartItem : cartItemList) {
						totalprice = totalprice + (cartItem.getQuantity() * cartItem.getPrice());
					}
					cartService.updateCartTotalPrice(cart.getCartid(), totalprice);
					//tổng product có trong giỏ hàng
					Integer totalQuantity= cartItemService.getTotalQuantity(cart.getCartid());
					session.setAttribute("totalQuantity", totalQuantity);
					return "redirect:/product/detail/" + productid;

				} else {
					cartItemService.addProductToCartItem(1, product.getDiscountprice(), productid, cart.getCartid());
					List<CartItem> cartItemList = cartItemService.getListItemByCartId(cart.getCartid());
					for (CartItem cartItem : cartItemList) {
						totalprice = totalprice + (cartItem.getQuantity() * cartItem.getPrice());
					}
					cartService.updateCartTotalPrice(cart.getCartid(), totalprice);
					//tổng product có trong giỏ hàng
					Integer totalQuantity= cartItemService.getTotalQuantity(cart.getCartid());
					session.setAttribute("totalQuantity", totalQuantity);
					return "redirect:/product/detail/" + productid;
				}
			}
		}
	}

	@GetMapping("/user/cart/checkout")
	public String checkout(@RequestParam("cartid") int cartid, HttpSession session, RedirectAttributes redirectAttributes) {
		User user = (User) session.getAttribute("userAccount");
		if (user == null) {
			redirectAttributes.addFlashAttribute("loginFirst", "You have to login first");
			return "redirect:/user/login";
		} else {
			List<CartViewData> cartViewDataList = cartService.getCartDetail(user.getUserid());
			Date date = new Date();
			OrderBill orderbill = new OrderBill(null, cartid, user.getUserid(), cartViewDataList.get(0).getTotalprice(), date);
			cartService.generateBill(orderbill);
			cartItemService.deleteAllProductInCart(cartid);
			//tổng product có trong giỏ hàng
			Integer totalQuantity= cartItemService.getTotalQuantity(cartViewDataList.get(0).getCartid());
			session.setAttribute("totalQuantity", totalQuantity);
			return "thanks";	
		}
	}

	
}
