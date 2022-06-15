package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import domain.Product;
import service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

//display product detail
	@GetMapping("/product/detail/{productid}")
	public String productDetail(@PathVariable("productid") int productid, Model model) {
		Product product = productService.getProductById(productid);
		model.addAttribute("productdetail", product);
		return "productdetail";
	}

//	display product list by status(hot or new) and gender(man or woman or couple)
	@GetMapping("/product/{status}/{gendertype}")
	public String displayProductListByStatusAndGender(@PathVariable("status") String status,
			@PathVariable("gendertype") String gendertype, Model model) {
		List<Product> productList = productService.getProductsByStatusAndGender(status, gendertype);
		model.addAttribute("productList", productList);
		return "productlist";
	}

//	display product list by brand
	@GetMapping("/product/brandspecificate")
	public String displayProductlistByBrand(@RequestParam("brand") String brand, Model model) {
		List<Product> productList = productService.getProductByBrand(brand);
		model.addAttribute("productList", productList);
		return "productlist";
	}

//	display switzerland watch
	@GetMapping("/product")
	public String displaySwitzerlandWatchList(
			@RequestParam(value = "original", defaultValue = "switzerland", required = false) String original,
			Model model) {
		List<Product> productList = productService.getSwitzerlandProduct(original);
		model.addAttribute("productList", productList);
		return "productlist";
	}

//	filter product by brand
	@GetMapping("/product/{gendertype}/brandspecificate")
	public String displayBrandProductList(@PathVariable("gendertype") String gendertype,
			@RequestParam("brand") String brand, Model model) {
		List<Product> productList = productService.filterProductByBrand(gendertype, brand);
		model.addAttribute("productList", productList);
		return "productlist";
	}

//	filter by price
	@GetMapping("/product/{gendertype}/pricerange")
	public String displayPriceProductList(@PathVariable("gendertype") String gendertype,
			@RequestParam(value = "minprice", required = false, defaultValue = "0") int minprice,
			@RequestParam(value = "maxprice", required = false, defaultValue = "100000000") int maxprice, Model model) {
		List<Product> productList = productService.filterProductListByPrice(gendertype, minprice, maxprice);
		model.addAttribute("productList", productList);
		for (Product product : productList) {
			System.out.println(product);
		}
		return "productlist";
	}

//	display product by gendertype
	@GetMapping("/product/gender")
	public String displayGenderProductList(
			@RequestParam(value = "gendertype", required = false, defaultValue = "man") String gendertype,
			Model model) {
		List<Product> productList = productService.getProductByGender(gendertype);
		model.addAttribute("productList", productList);
		return "productlist";
	}

//	get all product for continue purchase
	@GetMapping("/allproducts")
	public String allProducts(Model model) {
		List<Product> productList = productService.getAllProduct();
		model.addAttribute("productList", productList);
		return "productlist";
	}
//	display other product
	@GetMapping("/other")
	public String displayOtherProduct() {
		return "pagenotupdate";
	}
	

}
