package com.br.redeinsocial.api.dto;

import org.mapstruct.Mapper;

@Mapper
public interface TesteMapper {
	
	DumyTest toResponseDto(Test test);
	
	
}
