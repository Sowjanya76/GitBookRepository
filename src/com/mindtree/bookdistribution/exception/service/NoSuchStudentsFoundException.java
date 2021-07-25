package com.mindtree.bookdistribution.exception.service;

import com.mindtree.bookdistribution.exception.ServiceException;

public class NoSuchStudentsFoundException extends ServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchStudentsFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoSuchStudentsFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoSuchStudentsFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoSuchStudentsFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoSuchStudentsFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
