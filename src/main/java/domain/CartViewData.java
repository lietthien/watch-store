package domain;

import java.io.Serializable;

public class CartViewData implements Serializable{
	private static final long serialVersionUID = -6972259010862181145L;
	
	private int cartid;
	private int userid;
	private int cartitemid;
	private int productid;
	private double totalprice;
	private int price;
	private int quantity;
	private String productname;
	private String brand;
	private String symbolbrand;
	private String original;
	private String image;
	
	public CartViewData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartViewData(int cartid, int userid, int cartitemid, int productid, double totalprice, int price,
			int quantity, String productname, String brand, String symbolbrand, String original, String image) {
		super();
		this.cartid = cartid;
		this.userid = userid;
		this.cartitemid = cartitemid;
		this.productid = productid;
		this.totalprice = totalprice;
		this.price = price;
		this.quantity = quantity;
		this.productname = productname;
		this.brand = brand;
		this.symbolbrand = symbolbrand;
		this.original = original;
		this.image = image;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCartitemid() {
		return cartitemid;
	}

	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSymbolbrand() {
		return symbolbrand;
	}

	public void setSymbolbrand(String symbolbrand) {
		this.symbolbrand = symbolbrand;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "CartViewData [cartid=" + cartid + ", userid=" + userid + ", cartitemid=" + cartitemid + ", productid="
				+ productid + ", totalprice=" + totalprice + ", price=" + price + ", quantity=" + quantity
				+ ", productname=" + productname + ", brand=" + brand + ", symbolbrand=" + symbolbrand + ", original="
				+ original + ", image=" + image + "]";
	}
	
	
}
