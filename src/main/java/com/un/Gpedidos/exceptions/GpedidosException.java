package com.un.Gpedidos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class GpedidosException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2963694263507933695L;
	
	public GpedidosException(String message){
		super(message);
	}

}
