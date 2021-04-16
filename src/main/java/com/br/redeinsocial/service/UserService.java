package com.br.redeinsocial.service;

import com.br.redeinsocial.api.dto.CreateUserRequest;
import com.br.redeinsocial.core.dto.request.PageFilter;
import com.br.redeinsocial.core.exception.ResultNotFoundException;
import com.br.redeinsocial.model.User;
import com.br.redeinsocial.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Page<User> getByFilter(PageFilter pageFilter) {
		return userRepository.findAll(pageFilter.toPageable());
	}
	
	public User createUser(final CreateUserRequest createUserRequest) {
		return userRepository.save(new User(createUserRequest.getNickname()));
	}
	
	public User getUserByNickname(final String nickname) {
		
		final User user = userRepository.findByNicknameLikeIgnoreCase(nickname);
		if (Objects.isNull(user)) {
			throw new ResultNotFoundException(User.class, "nickname", nickname);
		}
		return user;
	}
	
	public User getUserById(final Long userId) {
		final Optional<User> userOptional = userRepository.findById(userId);
		if (!userOptional.isPresent()) {
			throw new ResultNotFoundException(User.class, "nickname", userId.toString());
		}
		return userOptional.get();
	}
}
