package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import repository.UserRepository;

@Service
public class LoginServiceImp implements LoginService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> isValidAccount(String email, String password) {
		return userRepository.isValidAccount(email,password);
	}

}
