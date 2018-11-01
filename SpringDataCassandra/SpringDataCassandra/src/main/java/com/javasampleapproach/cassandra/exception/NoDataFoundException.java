package com.javasampleapproach.cassandra.exception;

//given param not exist in the database
public class NoDataFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoDataFoundException(String msg) {

		super(msg);
	}
}
