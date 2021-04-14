package com.br.redeinsocial.api.controller;

import com.br.redeinsocial.api.dto.Test;
import com.br.redeinsocial.api.dto.TesteMapper;
import com.br.redeinsocial.core.dto.response.WrapperResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.br.redeinsocial.core.config.ApiConfig.Path.API_V1;
import static com.br.redeinsocial.core.config.ApiConfig.Path.ClientController.CUSTOMERS;

@RestController
@RequestMapping(value = API_V1 + CUSTOMERS, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "customer", description = "API for customer management")
public class TesteController {
	
	private final TesteMapper testeMapper;
	
	@Autowired
	public TesteController(final TesteMapper testeMapper) {
		this.testeMapper = testeMapper;
	}
	
	@ApiOperation(value = "Add new customer")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public WrapperResponse<String> teste(Test teste) {
		return WrapperResponse.of(testeMapper.toResponseDto(teste).getTeste());
	}
	
}
