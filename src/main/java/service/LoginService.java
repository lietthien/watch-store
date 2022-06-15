package service;

import java.util.List;

import domain.User;

public interface LoginService {
	List<User> isValidAccount(String email, String password);
}
