/*
 *
 *  * CABAL BRASIL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  * Copyright (c) 2021, Cabal Brasil and/or its affiliates. All rights reserved.
 *
 */


package com.br.redeinsocial.core.dto.request;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.Min;

import static com.br.redeinsocial.core.config.ApiConfig.Param.PAGE_DEFAULT_VALUE;
import static com.br.redeinsocial.core.config.ApiConfig.Param.PAGE_SIZE_DEFAULT_VALUE;

public class PageFilter {
	
	@Min(1)
	@ApiModelProperty(value = "Página requisitada, começando com 1", example = PAGE_DEFAULT_VALUE)
	private int page;
	@Min(1)
	@ApiModelProperty(value = "Tamanho página requisitada", example = PAGE_SIZE_DEFAULT_VALUE)
	private int pageSize;
	
	PageFilter(@Min(1) final int page, @Min(1) final int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public PageFilter() {
		this.page = Integer.parseInt(PAGE_DEFAULT_VALUE);
		this.pageSize = Integer.parseInt(PAGE_SIZE_DEFAULT_VALUE);
	}
	
	public Pageable toPageable() {
		return PageRequest.of(page - 1, pageSize);
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(final int page) {
		this.page = page;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(final int pageSize) {
		this.pageSize = pageSize;
	}
}
