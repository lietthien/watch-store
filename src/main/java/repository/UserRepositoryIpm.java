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

import domain.User;

@Repository
public class UserRepositoryIpm implements UserRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	public void addUser(User user) {
		String sql = "INSERT INTO user (firstname, lastname, phonenumber, email, password, address) "
				+ "VALUES (:firstname, :lastname, :phonenumber, :email, :password, :address)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("firstname", user.getFirstname());
		paramMap.put("lastname", user.getLastname());
		paramMap.put("phonenumber", user.getPhonenumber());
		paramMap.put("email", user.getEmail());
		paramMap.put("password", user.getPassword());
		paramMap.put("address", user.getAddress());
		template.update(sql, paramMap);
	}

	@Override
	public List<User> getUserByPhoneOrEmail(String phoneNumber, String email) {
		String sql="select*from user where phonenumber=:phoneNumber or email=:email";
		Map<String, Object> paramMap =new HashMap<String, Object>();
		paramMap.put("phoneNumber", phoneNumber);
		paramMap.put("email", email);
		return template.query(sql, paramMap, new UserMapper());
	}

	@Override
	public List<User> isValidAccount(String email, String password) {
		String sql="select*from user where email=:email and password=:password";
		Map<String, Object> paramMap =new HashMap<String, Object>();
		paramMap.put("email", email);
		paramMap.put("password", password);
		return template.query(sql, paramMap, new UserMapper());
	}
	private static final class UserMapper implements RowMapper<User>{
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user= new User();
			user.setUserid(rs.getInt("userid"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setPhonenumber(rs.getString("phonenumber"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setAddress(rs.getString("address"));
			user.setRole(rs.getString("role"));
			return user;
		}
	}
	@Override
	public List<User> getAllUser() {
		String sql="select * from user";
		Map<String, Object> paramMap = new HashMap<>();
		return template.query(sql, paramMap, new UserMapper());
	}

	
}
