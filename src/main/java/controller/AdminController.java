package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.Product;
import domain.User;
import service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;

	@GetMapping("/admin/addproduct")
	public String addProductForm(HttpSession userSession, RedirectAttributes redirectAttributes, Model model) {
		User user = (User) userSession.getAttribute("userAccount");
		if (user == null) {
			redirectAttributes.addFlashAttribute("loginFirst", "You have to login first");
			return "redirect:/user/login";
		} else if (user.getRole().equalsIgnoreCase("administrator")) {
			Product newProduct = new Product();
			model.addAttribute("newProduct", newProduct);
			return "addproduct";
		} else {
			redirectAttributes.addFlashAttribute("denyMessage", "Sorry, You don't have permission to do this action!");
			return "redirect:/home";
		}
	}

	@PostMapping("/admin/addproduct")
	public String addProduct(@ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result,
			HttpServletRequest request, RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return "addproduct";
		} else {
			MultipartFile temimg = newProduct.getTemporarysaveimg();
			String root = request.getSession().getServletContext().getRealPath("/");
			String imgtodb = temimg.getOriginalFilename();
			newProduct.setImage(imgtodb);
			if (temimg != null && temimg.isEmpty() == false) {

				try {
					temimg.transferTo(new File(root + "resources\\images\\products\\" + imgtodb));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				model.addAttribute("emptyImg", "Image has not been choosen!");
				return "addproduct";
			}
			int recordinserted = adminService.addProduct(newProduct);
			if (recordinserted != 0) {
				redirectAttributes.addFlashAttribute("updateSucessed", "Adding new product successfully!");
				return "redirect:/admin/product/manage";
			} else {
				redirectAttributes.addFlashAttribute("updateFailed", "Adding new product failed-Try again!");
				return "redirect:/admin/addproduct";
			}
		}

	}

//show product table list
	@GetMapping("/admin/product/manage")
	public String getProductManagePage(@RequestParam(name = "page", required = false,defaultValue = "1" ) String page, Model model,HttpSession userSession,
			RedirectAttributes redirectAttributes) {
		User user = (User) userSession.getAttribute("userAccount");
		if (user == null) {
			redirectAttributes.addFlashAttribute("loginFirst", "You have to login first");
			return "redirect:/user/login";
		} else if (user.getRole().equalsIgnoreCase("administrator")) {
			int totalPage = adminService.getTotalPage();
			model.addAttribute("totalPage", totalPage);
			List<Product> ProductForPage = adminService.getProductForPage(page);			
			model.addAttribute("ProductForPage", ProductForPage);
			String activePage=page;
			model.addAttribute("activePage", activePage);
			return "manageproduct";
		} else {
			redirectAttributes.addFlashAttribute("denyMessage", "Sorry, You don't have permission to do this action!");
			return "redirect:/home";
		}
	}

	/*
	 * @GetMapping("/admin/view/product/{productid}") public String
	 * viewProductById(@PathVariable("productid") int productid, Model model,
	 * RedirectAttributes redirectAttributes, HttpSession userSession) { User user =
	 * (User) userSession.getAttribute("userAccount"); if (user == null) {
	 * redirectAttributes.addFlashAttribute("loginFirst",
	 * "You have to login first"); return "redirect:/user/login"; } else if
	 * (user.getRole().equalsIgnoreCase("administrator")) { Product product =
	 * adminService.viewProductById(productid); model.addAttribute("product",
	 * product); return "productinfo"; } else {
	 * redirectAttributes.addFlashAttribute("denyMessage",
	 * "Sorry, You don't have permission to do this action!"); return
	 * "redirect:/home"; }
	 * 
	 * }
	 */

//delete product from the list
	@GetMapping("/admin/delete/product/{productid}")
	public String deleteProductById(@PathVariable("productid") int productid, 
			RedirectAttributes redirectAttributes, HttpSession userSession) {
		User user = (User) userSession.getAttribute("userAccount");
		if (user == null) {
			redirectAttributes.addFlashAttribute("loginFirst", "You have to login first");
			return "redirect:/user/login";
		} else if (user.getRole().equalsIgnoreCase("administrator")) {
			adminService.deleteProductById(productid);
			redirectAttributes.addFlashAttribute("deleteSuccess", "Deleted the product successfully");
			return "redirect:/admin/product/manage";
		} else {
			redirectAttributes.addFlashAttribute("denyMessage", "Sorry, You don't have permission to do this action!");
			return "redirect:/home";
		}
		
	}

//edit product
	@GetMapping("/admin/edit/product/{productid}")
	public String getFormEdit(@PathVariable("productid") int productid, Model model,
			RedirectAttributes redirectAttributes, HttpSession userSession) {
		User user = (User) userSession.getAttribute("userAccount");
		if (user == null) {
			redirectAttributes.addFlashAttribute("loginFirst", "You have to login first");
			return "redirect:/user/login";
		} else if (user.getRole().equalsIgnoreCase("administrator")) {
			Product ProductWillEdit = adminService.viewProductById(productid);
			model.addAttribute("ProductWillEdit", ProductWillEdit);
			Product editedProduct = new Product();
			model.addAttribute("editedProduct", editedProduct);
			return "editproduct";
		} else {
			redirectAttributes.addFlashAttribute("denyMessage", "Sorry, You don't have permission to do this action!");
			return "redirect:/home";
		}

	}

	@PostMapping("/admin/edit/product/{productid}")
	public String updateProduct(@PathVariable("productid") int productid,
			@ModelAttribute("editedProduct") Product editedProduct, BindingResult result, HttpServletRequest request,
			RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return "editproduct";
		} else {
			MultipartFile temimg = editedProduct.getTemporarysaveimg();
			String root = request.getSession().getServletContext().getRealPath("/");
			String imgtodb = temimg.getOriginalFilename();
			editedProduct.setImage(imgtodb);
			if (temimg != null && temimg.isEmpty() == false) {

				try {
					temimg.transferTo(new File(root + "resources\\images\\products\\" + imgtodb));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else {
				model.addAttribute("emptyImg", "Image has not been choosen!");
				return "editproduct";
			}
			int recordinserted = adminService.editProduct(editedProduct);
			if (recordinserted != 0) {
				redirectAttributes.addFlashAttribute("editSucessed", "Updated the product successfully!");
				return "redirect:/admin/product/manage";
			} else {
				redirectAttributes.addFlashAttribute("editFailed", "Updated the product failed-Try again!");
				return "editproduct";
			}
		}

	}
//	list user
	@GetMapping("/admin/userlist")
	public String viewListUser(HttpSession userSession, RedirectAttributes redirectAttributes, Model model) {
		User user = (User) userSession.getAttribute("userAccount");
		if (user == null) {
			redirectAttributes.addFlashAttribute("loginFirst", "You have to login first");
			return "redirect:/user/login";
		} else if (user.getRole().equalsIgnoreCase("administrator")) {
			List<User> allUser = adminService.getAllUser();
			model.addAttribute("allUser", allUser);
			return "listuser";
		} else {
			redirectAttributes.addFlashAttribute("denyMessage", "Sorry, You don't have permission to do this action!");
			return "redirect:/home";
		}
	}

}
