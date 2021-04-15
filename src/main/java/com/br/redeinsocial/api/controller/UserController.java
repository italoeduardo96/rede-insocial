package com.br.redeinsocial.api.controller;

import com.br.redeinsocial.core.dto.request.PageFilter;
import com.br.redeinsocial.core.dto.response.WrapperListResponse;
import com.br.redeinsocial.model.User;
import com.br.redeinsocial.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	
	@ApiOperation(value = "Get users")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public WrapperListResponse<User> getAll(@Valid PageFilter pageFilter) {
		return WrapperListResponse.of(userService.getByFilter(pageFilter));
	}
	
}
