package com.javasampleapproach.cassandra.exception;

//not authentication
public class ForbiddenException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ForbiddenException(String msg) {
		super(msg);

	}

}
