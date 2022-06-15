package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.Cart;
import domain.User;
import service.CartItemService;
import service.CartService;
import service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private CartService cartService;
	@Autowired
	private CartItemService cartItemService;

	@GetMapping("/user/login")
	public String getLoginForm(HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) {
		if (session.getAttribute("userAccount") != null) {
			redirectAttributes.addFlashAttribute("loginedMessage", "You have already logined!!!");
			return "redirect:/home";
		}
		return "login";

	}

	@PostMapping("/user/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			RedirectAttributes redirectAttributes, HttpServletRequest request,HttpSession session) {
		List<User> validUser = loginService.isValidAccount(email.trim(), password.trim());
		if (validUser.size() != 0) {
			User user = validUser.get(0);
			HttpSession userSession = request.getSession();
			userSession.setAttribute("userAccount", user);
			userSession.setMaxInactiveInterval(60 * 60*24);
			List<Cart> listCart = cartService.getCartByUser(user.getUserid());
			if (listCart.size() == 0) {
				session.setAttribute("totalQuantity", 0);
				return "redirect:/home";
			} else {
				//tổng product có trong giỏ hàng
				Integer totalQuantity= cartItemService.getTotalQuantity(listCart.get(0).getCartid());
				session.setAttribute("totalQuantity", totalQuantity);
				return "redirect:/home";
			}
		} else {
			redirectAttributes.addFlashAttribute("loginFailedMessage",
					"Your Email or Password is incorrect - Please try again!!!");
			return "redirect:/user/login";
		}

	}
}