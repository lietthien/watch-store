package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import repository.UserRepository;

@Service
public class RegisterServiceIpm implements RegisterService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void addUser(User user) {
		userRepository.addUser(user);
	}

	@Override
	public List<User> getUserByPhoneOrEmail(String phoneNumber, String email) {

		return userRepository.getUserByPhoneOrEmail(phoneNumber, email);
	}

}
