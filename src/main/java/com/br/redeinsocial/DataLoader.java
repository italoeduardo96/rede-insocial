package com.br.redeinsocial;

import com.br.redeinsocial.model.User;
import com.br.redeinsocial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
	
	private final UserRepository userRepository;
	
	@Autowired
	public DataLoader(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void run(ApplicationArguments args) {
		this.userRepository.save(User.builder().id(12331L).nickname("Nokia447x").build());
	}
	
}
