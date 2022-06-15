package service;

import java.util.List;

import domain.User;

public interface RegisterService {
	void addUser(User user);
	List<User> getUserByPhoneOrEmail(String phoneNumber, String email);
}
