package repository;

import java.util.List;

import domain.Product;

public interface ProductRepository {
	List<Product> getProductForHome(String status, String gendertype);
	Product getProductById(int productid);
	List<Product> getProductsByStatusAndGender(String status, String gendertype);
	List<Product> getProductByBrand(String brand);
	List<Product> getSwitzerlandProduct(String original);
	List<Product> filterProductByBrand(String gendertype, String brand);
	List<Product> filterProductListByPrice(String gendertype, int minprice, int maxprice);
	List<Product> getProductByGender(String gendertype);
	
	int addProduct(Product newProduct);
	List<Product> getAllProduct();
	void deleteProductById(int productid);
	int editProduct(Product editedProduct);
	List<Product> getProductForPage(String page);
}
