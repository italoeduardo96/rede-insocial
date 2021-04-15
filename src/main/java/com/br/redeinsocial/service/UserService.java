package com.br.redeinsocial.service;

import com.br.redeinsocial.core.dto.request.PageFilter;
import com.br.redeinsocial.model.User;
import com.br.redeinsocial.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Page<User> getByFilter(PageFilter pageFilter) {
		return userRepository.findAll(pageFilter.toPageable());
	}
}
