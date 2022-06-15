package service;

import java.util.List;

import domain.Product;
import domain.User;

public interface AdminService {

int addProduct(Product newProduct);

List<Product> getAllProduct();

Product viewProductById(int productid);

void deleteProductById(int productid);

int editProduct(Product editedProduct);

List<User> getAllUser();

int getTotalPage();

List<Product> getProductForPage(String page);
}
