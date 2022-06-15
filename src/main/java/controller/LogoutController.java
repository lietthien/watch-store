package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
@GetMapping("/user/logout")
	public String userLogout(HttpSession session) {
		session.getAttribute("userAccount");
		System.out.println(session.getAttribute("userAccount"));
		session.invalidate();
		return "redirect:/home";
	}
}
