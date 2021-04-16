package com.br.redeinsocial.service;

import com.br.redeinsocial.api.dto.CreatePostRequest;
import com.br.redeinsocial.core.dto.request.PageFilter;
import com.br.redeinsocial.core.exception.ResultNotFoundException;
import com.br.redeinsocial.model.Post;
import com.br.redeinsocial.model.User;
import com.br.redeinsocial.repository.PostRepository;
import com.br.redeinsocial.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
	
	private final PostRepository postRepository;
	private final UserRepository userRepository;
	
	public PostService(final PostRepository postRepository,
	                   final UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}
	
	public Page<Post> getAllPostsByUserId(Long userId, PageFilter pageFilter) {
		
		final Optional<User> userOptional = userRepository.findById(userId);
		if (!userOptional.isPresent()) {
			throw new ResultNotFoundException(User.class, "userId", userId.toString());
		}
		
		return postRepository.findAllByUser_UserIdOrderByDtCreateDesc(userId, pageFilter.toPageable());
	}
	
	public Post createPost(final CreatePostRequest createPostRequest, Long userId) {
		
		final Optional<User> userOptional = userRepository.findById(userId);
		if (!userOptional.isPresent()) {
			throw new ResultNotFoundException(User.class, "userId", userId.toString());
		}
		
		return postRepository.save(new Post(userOptional.get(), createPostRequest.getDescription()));
	}
}
