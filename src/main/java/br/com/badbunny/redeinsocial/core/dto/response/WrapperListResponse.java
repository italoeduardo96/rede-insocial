/*
 *
 *  * CABAL BRASIL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  * Copyright (c) 2021, Cabal Brasil and/or its affiliates. All rights reserved.
 *
 */

package br.com.badbunny.redeinsocial.core.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WrapperListResponse<T> {
	
	@ApiModelProperty(value = "Informações sobre o resultado da requisição", required = true)
	private Metadata metadata;
	@ApiModelProperty(value = "Lista dos resultados da requisição", required = true)
	private List<T> data;
	
	public WrapperListResponse() {
	
	}
	
	public WrapperListResponse(final List<T> data) {
		this.data = data;
	}
	
	public WrapperListResponse(final Metadata metadata, final List<T> data) {
		this.metadata = metadata;
		this.data = data;
	}
	
	public static <T> WrapperListResponse<T> of(List<T> data) {
		return new WrapperListResponse<>(data);
	}
	
	public static <T> WrapperListResponse<T> of(List<T> data, Metadata metadata) {
		return new WrapperListResponse<>(metadata, data);
	}
	
	public static <T> WrapperListResponse<T> of(Page<T> page) {
		return new WrapperListResponse<>(new Metadata(page), page.getContent());
	}
	
	public Metadata getMetadata() {
		return metadata;
	}
	
	public void setMetadata(final Metadata metadata) {
		this.metadata = metadata;
	}
	
	public List<T> getData() {
		return data;
	}
	
	public void setData(final List<T> data) {
		this.data = data;
	}
}
