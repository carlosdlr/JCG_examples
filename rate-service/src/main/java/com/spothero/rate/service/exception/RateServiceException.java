package com.spothero.rate.service.exception;

/**
 * 
 * @author carlosdlr
 * custom exception to handle the service errors
 *
 */
public class RateServiceException  extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7561318961634640034L;

	public RateServiceException() { super(); }
	public RateServiceException(String message) { super(message); }
	public RateServiceException(String message, Throwable cause) { super(message, cause); }
	public RateServiceException(Throwable cause) { super(cause); }

}
