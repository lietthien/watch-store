package repository;

import java.util.List;

import domain.User;

public interface UserRepository {
	void addUser(User user);

	List<User> getUserByPhoneOrEmail(String phoneNumber, String email);

	List<User> isValidAccount(String email, String password);

	List<User> getAllUser();
}
