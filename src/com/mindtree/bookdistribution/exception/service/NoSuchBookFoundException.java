package com.mindtree.bookdistribution.exception.service;

import com.mindtree.bookdistribution.exception.ServiceException;

public class NoSuchBookFoundException extends ServiceException{

	public NoSuchBookFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoSuchBookFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoSuchBookFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoSuchBookFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoSuchBookFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
