package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import domain.Cart;
import domain.CartViewData;
import domain.OrderBill;

@Repository
public class CartRepositoryIpm implements CartRepository{
@Autowired
private NamedParameterJdbcTemplate template;
	@Override
	public List<Cart> getCartByUser(int userid) {
		String sql = "select * from cart where userid=:userid";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userid", userid);
		return template.query(sql, paramMap, new CartMapper());
	}
	
	private static final class CartMapper implements RowMapper<Cart>{

		@Override
		public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cart cart = new Cart();
			cart.setCartid(rs.getInt("cartid"));
			cart.setUserid(rs.getInt("userid"));
			cart.setTotalprice(rs.getDouble("totalprice"));
			return cart;
		}
		
	}

	@Override
	public void createNewCart(Cart cart) {
		String sql="INSERT INTO cart (userid) VALUES (:userid);";
		Map<String, Object> param = new HashMap<>();
		param.put("userid", cart.getUserid());
		template.update(sql, param);
	}

	@Override
	public void updateCartTotalPrice(int cartid, double totalprice) {
		String sql="update cart set totalprice = :totalprice where cartid = :cartid;";
		Map<String, Object> param = new HashMap<>();
		param.put("totalprice", totalprice);
		param.put("cartid", cartid);
		template.update(sql, param);
	}

	@Override
	public List<CartViewData> getCartDetail(int userid) {
		String sql = "SELECT cart.cartid, cart.totalprice, cart.userid, cartitem.cartitemid, cartitem.price, "
				+ "cartitem.quantity, cartitem.productid, product.productname, product.brand, product.symbolbrand, "
				+ "product.original, product.image FROM cart "
				+ " inner join cartitem on cart.cartid=cartitem.cartid "
				+ "inner join product on cartitem.productid=product.productid "
				+ "where userid=:userid;";
		Map<String, Object> param = new HashMap<>();
		param.put("userid", userid);
		return template.query(sql, param, new CartViewDataMapper());
	}
private static final class CartViewDataMapper implements RowMapper<CartViewData>{

	@Override
	public CartViewData mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartViewData cartViewData = new CartViewData();
		cartViewData.setCartid(rs.getInt("cartid"));
		cartViewData.setUserid(rs.getInt("userid"));
		cartViewData.setCartitemid(rs.getInt("cartitemid"));
		cartViewData.setProductid(rs.getInt("productid"));
		cartViewData.setPrice(rs.getInt("price"));
		cartViewData.setTotalprice(rs.getDouble("totalprice"));
		cartViewData.setQuantity(rs.getInt("quantity"));
		cartViewData.setProductname(rs.getString("productname"));
		cartViewData.setBrand(rs.getString("brand"));
		cartViewData.setSymbolbrand(rs.getString("symbolbrand"));
		cartViewData.setOriginal(rs.getString("original"));
		cartViewData.setImage(rs.getString("image"));
		return cartViewData;
	}
	
}

@Override
public void generateBill(OrderBill orderbill) {
	String sql="INSERT INTO orderbill (cartid, userid, totalprice, datecreated) "
			+ "VALUES (:cartid, :userid, :totalprice, :datecreated);";
	Map<String, Object> param = new HashMap<>();
	param.put("cartid", orderbill.getCartid());
	param.put("userid", orderbill.getUserid());
	param.put("totalprice", orderbill.getTotalprice());
	param.put("datecreated", orderbill.getDatecreated());
	template.update(sql, param);	
	
}
}
