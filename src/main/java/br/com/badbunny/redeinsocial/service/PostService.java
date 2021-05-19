package br.com.badbunny.redeinsocial.service;

import br.com.badbunny.redeinsocial.api.dto.CreatePostRequest;
import br.com.badbunny.redeinsocial.core.dto.request.PageFilter;
import br.com.badbunny.redeinsocial.core.exception.ResultNotFoundException;
import br.com.badbunny.redeinsocial.model.Post;
import br.com.badbunny.redeinsocial.model.User;
import br.com.badbunny.redeinsocial.repository.PostRepository;
import br.com.badbunny.redeinsocial.repository.UserRepository;
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
