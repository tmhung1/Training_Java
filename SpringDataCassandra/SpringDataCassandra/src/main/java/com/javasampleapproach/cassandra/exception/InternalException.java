package com.javasampleapproach.cassandra.exception;

//exception that occurred somewhere in the code
public class InternalException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public InternalException(String msg) {
		super(msg);

	}
}
