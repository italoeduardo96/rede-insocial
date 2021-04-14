/*
 *  CABAL BRASIL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  Copyright (c) 2021, Cabal Brasil and/or its affiliates. All rights reserved.
 */

package com.br.redeinsocial.core.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class ValidationRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 7775411077730666416L;
	
	public ValidationRequestException(String message) {
		super(message);
	}
	
}
