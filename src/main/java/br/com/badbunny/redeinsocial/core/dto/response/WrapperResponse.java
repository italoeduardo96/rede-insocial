package br.com.badbunny.redeinsocial.core.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WrapperResponse<T> {
	
	@ApiModelProperty(value = "Informações sobre o resultado da requisição", required = true)
	private Metadata metadata;
	@ApiModelProperty(value = "Resultado da requisição", required = true)
	private T data;
	
	public static <T> WrapperResponse<T> of(T data) {
		
		final WrapperResponse<T> response = new WrapperResponse<>();
		response.setData(data);
		response.setMetadata(new Metadata());
		return response;
	}
	
	public Metadata getMetadata() {
		return metadata;
	}
	
	public void setMetadata(final Metadata metadata) {
		this.metadata = metadata;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(final T data) {
		this.data = data;
	}
}
