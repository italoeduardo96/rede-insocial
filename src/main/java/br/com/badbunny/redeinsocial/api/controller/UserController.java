package br.com.badbunny.redeinsocial.api.controller;

import br.com.badbunny.redeinsocial.api.dto.CreatePostRequest;
import br.com.badbunny.redeinsocial.api.dto.CreateUserRequest;
import br.com.badbunny.redeinsocial.core.dto.request.PageFilter;
import br.com.badbunny.redeinsocial.core.dto.response.WrapperListResponse;
import br.com.badbunny.redeinsocial.core.dto.response.WrapperResponse;
import br.com.badbunny.redeinsocial.model.Post;
import br.com.badbunny.redeinsocial.model.User;
import br.com.badbunny.redeinsocial.service.PostService;
import br.com.badbunny.redeinsocial.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import static br.com.badbunny.redeinsocial.core.config.ApiConfig.Path.API_V1;
import static br.com.badbunny.redeinsocial.core.config.ApiConfig.Path.ClientController.POSTS;
import static br.com.badbunny.redeinsocial.core.config.ApiConfig.Path.ClientController.USERS;

@RestController
@RequestMapping(value = API_V1 + USERS, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "user", description = "API for users management")
public class UserController {
	
	private final UserService userService;
	private final PostService postService;
	
	public UserController(final UserService userService, final PostService postService) {
		this.userService = userService;
		this.postService = postService;
	}
	
	@ApiOperation(value = "Get All users")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public WrapperListResponse<User> getAll(@Valid PageFilter pageFilter) {
		return WrapperListResponse.of(userService.getByFilter(pageFilter));
	}
	
	@ApiOperation(value = "Get user by id")
	@GetMapping("{userId}")
	@ResponseStatus(HttpStatus.OK)
	public WrapperResponse<User> getByid(@PathVariable Long userId) {
		return WrapperResponse.of(userService.getUserById(userId));
	}
	
	@ApiOperation(value = "Get user by nickname")
	@GetMapping("/nickname/{nickname}")
	@ResponseStatus(HttpStatus.OK)
	public WrapperResponse<User> getByNickname(@PathVariable String nickname) {
		return WrapperResponse.of(userService.getUserByNickname(nickname));
	}
	
	@ApiOperation(value = "Create user")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public WrapperResponse<User> createUser(@Valid CreateUserRequest createUserRequest) {
		return WrapperResponse.of(userService.createUser(createUserRequest));
	}
	
	@ApiOperation(value = "Get All posts by user id")
	@GetMapping("/{userId}" + POSTS)
	@ResponseStatus(HttpStatus.OK)
	public WrapperListResponse<Post> getAllPostsByUserId(@PathVariable("userId") Long userId,
	                                                     @Valid PageFilter pageFilter) {
		return WrapperListResponse.of(postService.getAllPostsByUserId(userId, pageFilter));
	}
	
	@ApiOperation(value = "Create a user post")
	@PostMapping("/{userId}" + POSTS)
	@ResponseStatus(HttpStatus.CREATED)
	public WrapperResponse<Post> createUser(@PathVariable("userId") Long userId,
	                                        @Valid CreatePostRequest createPostRequest) {
		return WrapperResponse.of(postService.createPost(createPostRequest, userId));
	}
	
}
