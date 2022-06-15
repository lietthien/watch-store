package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import domain.Product;
import service.ProductService;

@Controller
public class HomeController {
	@Autowired
	private ProductService productservice;
	@GetMapping(value = {"/","/home"})
	public String homePage(Model model){
		List<Product> hotManProducts = productservice.getProductForHome("hot","man");
		List<Product> hotWomanProducts = productservice.getProductForHome("hot","woman");
		List<Product> hotCoupleProducts = productservice.getProductForHome("hot","couple");
		model.addAttribute("hotManProducts", hotManProducts);
		model.addAttribute("hotWomanProducts", hotWomanProducts);
		model.addAttribute("hotCoupleProducts", hotCoupleProducts);
		
		List<Product> newManProducts = productservice.getProductForHome("new","man");
		List<Product> newWomanProducts = productservice.getProductForHome("new","woman");
		List<Product> newCoupleProducts = productservice.getProductForHome("new","couple");
		model.addAttribute("newManProducts", newManProducts);
		model.addAttribute("newWomanProducts", newWomanProducts);
		model.addAttribute("newCoupleProducts", newCoupleProducts);
		
		
//		for (Product product : newManProducts) {
//			System.out.println(product);
//		}
		return "home";
	}
}
