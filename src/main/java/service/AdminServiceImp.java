package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Product;
import domain.User;
import repository.ProductRepository;
import repository.UserRepository;

@Service
public class AdminServiceImp implements AdminService{
@Autowired
private ProductRepository productRepository;
@Autowired
private UserRepository userRepository;
	@Override
	public int addProduct(Product newProduct) {
		String postSymbol="0"+newProduct.getDiameter();
		String preSymbol="";
		switch (newProduct.getBrand().toLowerCase()) {
		case "longines":
			preSymbol="L001";
			break;
		case "hamilton":
			preSymbol="H002";
			break;
		case "seiko":
			preSymbol="S003";
			break;
		case "citizen":
			preSymbol="CN004";
			break;
		case "orient":
			preSymbol="OT005";
			break;
		case "casio":
			preSymbol="CA006";
			break;
		case "calvin klein":
			preSymbol="CK007";
			break;

		default:
			preSymbol="DF000";
			break;
		}
		newProduct.setSymbolbrand(preSymbol+"."+postSymbol);
		newProduct.setDiscountprice((newProduct.getOldprice()/100)*(100-newProduct.getDiscountpercent()));
		return productRepository.addProduct(newProduct);
		
	}
	@Override
	public List<Product> getAllProduct() {
		
		return productRepository.getAllProduct();
	}
	@Override
	public Product viewProductById(int productid) {
		
		return productRepository.getProductById(productid);
	}
	@Override
	public void deleteProductById(int productid) {
		productRepository.deleteProductById(productid);
		
	}
	@Override
	public int editProduct(Product editedProduct) {
		String postSymbol="0"+editedProduct.getDiameter();
		String preSymbol="";
		switch (editedProduct.getBrand().toLowerCase()) {
		case "longines":
			preSymbol="L001";
			break;
		case "hamilton":
			preSymbol="H002";
			break;
		case "seiko":
			preSymbol="S003";
			break;
		case "citizen":
			preSymbol="CN004";
			break;
		case "orient":
			preSymbol="OT005";
			break;
		case "casio":
			preSymbol="CA006";
			break;
		case "calvin klein":
			preSymbol="CK007";
			break;

		default:
			preSymbol="DF000";
			break;
		}
		editedProduct.setSymbolbrand(preSymbol+"."+postSymbol);
		editedProduct.setDiscountprice((editedProduct.getOldprice()/100)*(100-editedProduct.getDiscountpercent()));
		return productRepository.editProduct(editedProduct);
		
	}
	@Override
	public List<User> getAllUser() {
		return userRepository.getAllUser();
	}
	@Override
	public int getTotalPage() {
		int numOfRows=productRepository.getAllProduct().size();
		return (numOfRows%50==0)?(numOfRows/50):(numOfRows/50+1);
		
	}
	@Override
	public List<Product> getProductForPage(String page) {
		return productRepository.getProductForPage(page);
	}

	

}
