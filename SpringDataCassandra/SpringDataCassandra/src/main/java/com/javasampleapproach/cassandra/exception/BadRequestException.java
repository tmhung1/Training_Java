package com.javasampleapproach.cassandra.exception;

//given param is not matched to controller
public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BadRequestException(String msg) {
		super(msg);

	}

}
