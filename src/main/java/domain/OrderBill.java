package domain;

import java.io.Serializable;
import java.util.Date;

public class OrderBill implements Serializable{
	
	private static final long serialVersionUID = 706489891408329166L;
	private Integer orderbillid;
	private int cartid;
	private int userid;
	private double totalprice;
	private Date datecreated;
	public Integer getOrderbillid() {
		return orderbillid;
	}
	public void setOrderbillid(Integer orderbillid) {
		this.orderbillid = orderbillid;
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
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public Date getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}
	public OrderBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderBill(Integer orderbillid, int cartid, int userid, double totalprice, Date datecreated) {
		super();
		this.orderbillid = orderbillid;
		this.cartid = cartid;
		this.userid = userid;
		this.totalprice = totalprice;
		this.datecreated = datecreated;
	}

}