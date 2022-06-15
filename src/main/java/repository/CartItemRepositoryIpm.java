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

import domain.CartItem;

@Repository
public class CartItemRepositoryIpm implements CartItemRepository{
@Autowired
	private NamedParameterJdbcTemplate template;

@Override
public void addProductToCartItem(int quantity, Integer discountprice, int productid, int cartid) {
	String sql="INSERT INTO cartitem (price, quantity, productid, cartid) VALUES (:price, :quantity, :productid, :cartid)";
	Map<String, Object> param = new HashMap<>();
	param.put("price", discountprice);
	param.put("quantity", quantity);
	param.put("productid", productid);
	param.put("cartid", cartid);
	template.update(sql, param);
}

@Override
public int getProductInCartItem(int productid, int cartid) {
	String sql = "select count(*) from cartitem where cartid =:cartid and productid =:productid";
	Map<String, Object> param = new HashMap<>();
	param.put("cartid", cartid);
	param.put("productid", productid);
	return template.queryForObject(sql, param, Integer.class);
}

@Override
public void moreQuantityProductInCartItem(int cartid, int productid) {
	String sql ="update cartitem set quantity = quantity +1 where cartid =:cartid and productid =:productid";
	Map<String, Object> param = new HashMap<>();
	param.put("cartid", cartid);
	param.put("productid", productid);
	template.update(sql, param);
}

@Override
public List<CartItem> getListItemByCartId(int cartid) {
	String sql="SELECT * FROM cartitem where cartid=:cartid";
	Map<String, Object> param = new HashMap<>();
	param.put("cartid", cartid);
	return template.query(sql, param, new CartItemMapper());
}
private static final class CartItemMapper implements RowMapper<CartItem>{

	@Override
	public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartItem cartItem = new CartItem();
		cartItem.setCartitemid(rs.getInt("cartitemid"));
		cartItem.setCartid(rs.getInt("cartid"));
		cartItem.setProductid(rs.getInt("productid"));
		cartItem.setPrice(rs.getDouble("price"));
		cartItem.setQuantity(rs.getInt("quantity"));
		return cartItem;
	}
	
}

@Override
public int getQuantityProductInCartIem(int cartid, int productid) {
	String sql ="select quantity from cartitem where cartid=:cartid and productid=:productid;";
	Map<String, Object> param = new HashMap<>();
	param.put("cartid", cartid);
	param.put("productid", productid);
	return template.queryForObject(sql, param, Integer.class);
}

@Override
public void subQuantityProductInCartItem(int cartid, int productid) {
	String sql ="update cartitem set quantity = quantity -1 where cartid =:cartid and productid =:productid";
	Map<String, Object> param = new HashMap<>();
	param.put("cartid", cartid);
	param.put("productid", productid);
	template.update(sql, param);
	
}

@Override
public void deleteProductInCartItem(int cartid, int productid) {
	String sql="delete from cartitem where cartid=:cartid and productid=:productid";
	Map<String, Object> param = new HashMap<>();
	param.put("cartid", cartid);
	param.put("productid", productid);
	template.update(sql, param);
}

@Override
public void deleteAllProductInCart(int cartid) {
	String sql="delete from cartitem where cartid=:cartid";
	Map<String, Object> param = new HashMap<>();
	param.put("cartid", cartid);
	template.update(sql, param);
}

@Override
public Integer getTotalQuantity(int cartid) {
	String sql ="select sum(quantity) from cartitem where cartid =:cartid";
	Map<String, Object> param = new HashMap<>();
	param.put("cartid", cartid);
	return template.queryForObject(sql, param, Integer.class);
}


}
