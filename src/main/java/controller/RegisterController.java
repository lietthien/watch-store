package controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.User;
import service.RegisterService;

@Controller
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	@GetMapping("/user/register")
	public String getRegisterForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	@PostMapping("/user/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			return "register";
		} else if ((registerService.getUserByPhoneOrEmail(user.getPhonenumber(), user.getEmail())).size() == 0) {
			registerService.addUser(user);
			redirectAttributes.addFlashAttribute("successMessage","Register Successfully - Please using your Email & Password to login");
			return "redirect:/user/login";
		} else {
			redirectAttributes.addFlashAttribute("duplicatedInfo","Phone Number or Email have already existed - Please try something else!!!");
			return "redirect:/user/register";
		}
	}
}
