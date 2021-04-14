/*
 *
 *  * CABAL BRASIL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  * Copyright (c) 2021, Cabal Brasil and/or its affiliates. All rights reserved.
 *
 */

package com.br.redeinsocial.core.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@ApiModelProperty(value = "Dados sobre a paginação do resultado da requisição")
	private Pagination pagination;
	
	Metadata() {
	
	}
	
	public Metadata(final Pagination pagination) {
		this.pagination = pagination;
	}
	
	public Metadata(final Page<?> pagination) {
		this.pagination = new Pagination(pagination);
	}
	
	public Pagination getPagination() {
		return pagination;
	}
	
	public void setPagination(final Pagination pagination) {
		this.pagination = pagination;
	}
}
