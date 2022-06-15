package domain;

import java.io.Serializable;

public class CartItem implements Serializable{
	
	private static final long serialVersionUID = 3594990907254541050L;
	private int cartitemid;
	private int quantity;
	private double price;
	private int productid;
	private int cartid;
	public CartItem() {
		
	}
	public CartItem(int cartitemid, int quantity, double price, int productid, int cartid) {
		super();
		this.cartitemid = cartitemid;
		this.quantity = quantity;
		this.price = price;
		this.productid = productid;
		this.cartid = cartid;
	}
	public int getCartitemid() {
		return cartitemid;
	}
	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	@Override
	public String toString() {
		return "CartItem [cartitemid=" + cartitemid + ", quantity=" + quantity + ", price=" + price + ", productid="
				+ productid + ", cartid=" + cartid + "]";
	}
	
	
	
}
