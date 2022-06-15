package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Product;
import repository.ProductRepository;
@Service
public class ProductServiceIpm implements ProductService {
	@Autowired
	ProductRepository productRepository;

	public List<Product> getProductForHome(String status,String gendertype) {
		return productRepository.getProductForHome(status, gendertype);
	}

	public Product getProductById(int productid) {
		return productRepository.getProductById(productid);
	}



	public List<Product> getProductsByStatusAndGender(String status, String gendertype) {
		return productRepository.getProductsByStatusAndGender(status,gendertype);
	}

	public List<Product> getProductByBrand(String brand) {
		return productRepository.getProductByBrand(brand);
	}

	public List<Product> getSwitzerlandProduct(String original) {
		return productRepository.getSwitzerlandProduct(original);
	}

	public List<Product> filterProductByBrand(String gendertype, String brand) {
		return productRepository.filterProductByBrand(gendertype,brand);
	}

	public List<Product> filterProductListByPrice(String gendertype, int minprice, int maxprice) {
		return productRepository.filterProductListByPrice(gendertype, minprice, maxprice);
	}

	public List<Product> getProductByGender(String gendertype) {
		return productRepository.getProductByGender(gendertype);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.getAllProduct();
	}
	

}
