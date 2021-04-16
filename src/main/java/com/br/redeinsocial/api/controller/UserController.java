package com.br.redeinsocial.api.controller;

import com.br.redeinsocial.api.dto.CreateUserRequest;
import com.br.redeinsocial.core.dto.request.PageFilter;
import com.br.redeinsocial.core.dto.response.WrapperListResponse;
import com.br.redeinsocial.core.dto.response.WrapperResponse;
import com.br.redeinsocial.model.User;
import com.br.redeinsocial.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.br.redeinsocial.core.config.ApiConfig.Path.API_V1;
import static com.br.redeinsocial.core.config.ApiConfig.Path.ClientController.USERS;

@RestController
@RequestMapping(value = API_V1 + USERS, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "user", description = "API for users management")
public class UserController {
	
	private final UserService userService;
	
	public UserController(final UserService userService) {
		this.userService = userService;
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
	
}
