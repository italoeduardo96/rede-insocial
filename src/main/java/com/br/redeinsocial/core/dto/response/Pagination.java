/*
 *
 *  * CABAL BRASIL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  * Copyright (c) 2021, Cabal Brasil and/or its affiliates. All rights reserved.
 *
 */

package com.br.redeinsocial.core.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pagination {
	
	@ApiModelProperty(value = "Tamanho da página", required = true, example = "10")
	private final int pageSize;
	@ApiModelProperty(value = "Página atual", required = true, example = "1")
	private final int currentPage;
	@ApiModelProperty(value = "Número total de elementos de todas as páginas", required = true, example = "100")
	private final long totalCount;
	@ApiModelProperty(value = "Número total de página", required = true, example = "10")
	private final int totalPages;
	@ApiModelProperty(value = "Número de elemento na página", required = true, example = "10")
	private final int number;
	@ApiModelProperty(value = "Flag indicando se esta página é a primeira", required = true, example = "true")
	private final boolean first;
	@ApiModelProperty(value = "Flag indicando se esta página é a ultima", required = true, example = "false")
	private final boolean last;
	
	public Pagination(final int pageSize, final int currentPage, final long totalCount, final int totalPages, final int number,
	           final boolean first, final boolean last) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.totalPages = totalPages;
		this.number = number;
		this.first = first;
		this.last = last;
	}
	
	public Pagination() {
		this.pageSize = 0;
		this.currentPage = 1;
		this.totalCount = 0;
		this.totalPages = 1;
		this.number = 0;
		this.first = true;
		this.last = false;
	}
	
	public Pagination(Page<?> page) {
		this.pageSize = page.getPageable().getPageSize();
		this.currentPage = page.getPageable().getPageNumber() + 1;
		this.totalCount = page.getTotalElements();
		this.totalPages = page.getTotalPages();
		this.number = page.getNumberOfElements();
		this.first = page.isFirst();
		this.last = page.isLast();
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public long getTotalCount() {
		return totalCount;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public int getNumber() {
		return number;
	}
	
	public boolean isFirst() {
		return first;
	}
	
	public boolean isLast() {
		return last;
	}
}
