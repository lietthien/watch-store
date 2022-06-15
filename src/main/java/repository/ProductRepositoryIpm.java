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

import domain.Product;

@Repository
public class ProductRepositoryIpm implements ProductRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	public List<Product> getProductForHome(String status, String gendertype) {
		String sql = "SELECT * FROM watchstore.product WHERE status = :status and gendertype=:gendertype ORDER BY RAND() LIMIT 8";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", status);
		paramMap.put("gendertype", gendertype);
		return template.query(sql, paramMap, new ProductMapper());
	}

	public Product getProductById(int productid) {
		String sql = "SELECT * FROM watchstore.product WHERE productid = :productid";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("productid", productid);
		return template.queryForObject(sql, paramMap, new ProductMapper());
	}

	public List<Product> getProductsByStatusAndGender(String status, String gendertype) {
		String sql = "SELECT * FROM watchstore.product WHERE status = :status and gendertype= :gendertype ORDER BY RAND()";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", status);
		paramMap.put("gendertype", gendertype);
		return template.query(sql, paramMap, new ProductMapper());
	}

	public List<Product> getProductByBrand(String brand) {
		String sql = "SELECT * FROM watchstore.product WHERE brand = :brand ORDER BY RAND()";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("brand", brand);
		return template.query(sql, paramMap, new ProductMapper());
	}
	
	public List<Product> getSwitzerlandProduct(String original) {
		String sql= "SELECT * FROM watchstore.product where original= :original ORDER BY RAND()";
		Map<String, Object> paramMap =new HashMap<String, Object>();
		paramMap.put("original", original);
		return template.query(sql, paramMap, new ProductMapper());
	}
	
	public List<Product> filterProductByBrand(String gendertype, String brand) {
		String sql="SELECT * FROM watchstore.product WHERE gendertype =:gendertype and brand = :brand ORDER BY RAND()";
		Map<String, Object> paramMap =new HashMap<String, Object>();
		paramMap.put("gendertype", gendertype);
		paramMap.put("brand", brand);
		return template.query(sql, paramMap, new ProductMapper());
	}
	
	public List<Product> filterProductListByPrice(String gendertype, int minprice, int maxprice) {
		String sql= "SELECT * FROM watchstore.product where gendertype=:gendertype and discountprice between :minprice and :maxprice ORDER BY RAND()";
		Map<String, Object> paramMap =new HashMap<String, Object>();
		paramMap.put("gendertype",gendertype);
		paramMap.put("minprice", minprice);
		paramMap.put("maxprice", maxprice);
		return template.query(sql, paramMap, new ProductMapper());
	}


	public List<Product> getProductByGender(String gendertype) {
	String sql ="SELECT * FROM watchstore.product where gendertype=:gendertype ORDER BY RAND()";
	Map<String, Object> paramMap =new HashMap<String, Object>();
	paramMap.put("gendertype",gendertype);
	return template.query(sql, paramMap, new ProductMapper());
	}

	
	

	private static final class ProductMapper implements RowMapper<Product> {

		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product p = new Product();
			p.setProductid(rs.getInt("productid"));
			p.setProductname(rs.getString("productname"));
			p.setBrand(rs.getString("brand"));
			p.setSymbolbrand(rs.getString("symbolbrand"));
			p.setGendertype(rs.getString("gendertype"));
			p.setMachinetype(rs.getString("machinetype"));
			p.setDiameter(rs.getByte("diameter"));
			p.setStatus(rs.getString("status"));
			p.setDiscountpercent(rs.getByte("discountpercent"));
			p.setDiscountprice(rs.getInt("discountprice"));
			p.setOldprice(rs.getInt("oldprice"));
			p.setGlass(rs.getString("glass"));
			p.setMaterial(rs.getString("material"));
			p.setOriginal(rs.getString("original"));
			p.setImage(rs.getString("image"));
			return p;
		}

	}




	@Override
	public int addProduct(Product newProduct) {
		String sql="INSERT INTO product "
				+ "(brand, symbolbrand, gendertype, machinetype, diameter, "
				+ "status, discountpercent, discountprice, oldprice, glass, material, original, image) "
				+ "VALUES (:brand, :symbolbrand, :gendertype, :machinetype, :diameter, :status, "
				+ ":discountpercent, :discountprice, :oldprice, :glass, :material, :original, :image);";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("brand", newProduct.getBrand());
		paramMap.put("symbolbrand", newProduct.getSymbolbrand());
		paramMap.put("gendertype", newProduct.getGendertype());
		paramMap.put("machinetype", newProduct.getMachinetype());
		paramMap.put("diameter", newProduct.getDiameter());
		paramMap.put("status", newProduct.getStatus());
		paramMap.put("discountpercent", newProduct.getDiscountpercent());
		paramMap.put("discountprice", newProduct.getDiscountprice());
		paramMap.put("oldprice", newProduct.getOldprice());
		paramMap.put("glass", newProduct.getGlass());
		paramMap.put("material", newProduct.getMaterial());
		paramMap.put("original", newProduct.getOriginal());
		paramMap.put("image", newProduct.getImage());
		return template.update(sql, paramMap);
	}

	@Override
	public List<Product> getAllProduct() {
		String sql ="select * from product ORDER BY RAND()";
		Map<String, Object> paramMap = new HashMap<>();
		return template.query(sql, paramMap, new ProductMapper());
	}

	
	@Override
	public List<Product> getProductForPage(String page) {
		int rowOffset = (Integer.parseInt(page)-1)*50;
		String sql ="select * from product limit 50 offset :rowOffset";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("rowOffset", rowOffset);
		return template.query(sql, paramMap, new ProductMapper());
	}

	@Override
	public void deleteProductById(int productid) {
		String sql ="DELETE FROM product WHERE (productid = :productid);";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("productid", productid);
		template.update(sql, paramMap);
			
		
	}

	@Override
	public int editProduct(Product editedProduct) {
		String sql ="UPDATE product SET brand = :brand, symbolbrand = :symbolbrand, "
				+ "gendertype = :gendertype, machinetype = :machinetype, diameter = :diameter, "
				+ "status = :status, discountpercent = :discountpercent, "
				+ "discountprice = :discountprice, oldprice = :oldprice, glass = :glass, "
				+ "material = :material, original = :original, image = :image WHERE productid = :productid;";
		Map<String, Object> paramMap =new HashMap<>();
		paramMap.put("brand", editedProduct.getBrand());
		paramMap.put("symbolbrand", editedProduct.getSymbolbrand());
		paramMap.put("gendertype", editedProduct.getGendertype());
		paramMap.put("machinetype", editedProduct.getMachinetype());
		paramMap.put("diameter", editedProduct.getDiameter());
		paramMap.put("status", editedProduct.getStatus());
		paramMap.put("discountpercent", editedProduct.getDiscountpercent());
		paramMap.put("discountprice", editedProduct.getDiscountprice());
		paramMap.put("oldprice", editedProduct.getOldprice());
		paramMap.put("glass", editedProduct.getGlass());
		paramMap.put("material", editedProduct.getMaterial());
		paramMap.put("original", editedProduct.getOriginal());
		paramMap.put("image", editedProduct.getImage());
		paramMap.put("productid", editedProduct.getProductid());
		return template.update(sql, paramMap);
	}
}
