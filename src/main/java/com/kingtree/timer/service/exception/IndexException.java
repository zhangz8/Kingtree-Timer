package com.kingtree.timer.service.exception;

public class IndexException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -735556310318641027L;

	public IndexException() {
		super("kingtree index exception");
	}

	public IndexException(String msg) {
		super(msg);
	}

}
