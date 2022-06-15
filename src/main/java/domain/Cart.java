package domain;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable{
	private static final long serialVersionUID = -4917861185800804629L;
	private int cartid;
	private int userid;
	private List<CartItem> cartitem;
	private double totalprice;
	public Cart() {
	}
	public Cart(int cartid, int userid, List<CartItem> cartitem, double totalprice) {
		super();
		this.cartid = cartid;
		this.userid = userid;
		this.cartitem = cartitem;
		this.totalprice = totalprice;
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
	public List<CartItem> getCartitem() {
		return cartitem;
	}
	public void setCartitem(List<CartItem> cartitem) {
		this.cartitem = cartitem;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", userid=" + userid + ", cartitem=" + cartitem + ", totalprice=" + totalprice
				+ "]";
	}

}
