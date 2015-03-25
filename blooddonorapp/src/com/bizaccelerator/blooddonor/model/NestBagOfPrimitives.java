package com.bizaccelerator.blooddonor.model;

public class NestBagOfPrimitives {
	private int value1 = 2;
	private String value2 = "nestedabc";
	private transient int value3 = 3;
	private String[] address = {"pqr", "xyz"};

	public NestBagOfPrimitives() {
		// no-args constructor
	}
}
