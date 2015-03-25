package com.bizaccelerator.blooddonor.model;

import java.util.ArrayList;

import javassist.bytecode.SignatureAttribute.NestedClassType;

public class BagOfPrimitives {
	private int value1;
	private String value2 = "abc";
	//private transient int value3 = 3;
	//private String[] address = {"abc", "def"};
	//private ArrayList <NestBagOfPrimitives> list = new ArrayList<NestBagOfPrimitives>(); 
	
	public BagOfPrimitives(int int1, String str) {
		/*final NestBagOfPrimitives nestedObj1 = new NestBagOfPrimitives();
		final NestBagOfPrimitives nestedObj2 = new NestBagOfPrimitives();
		list.add(nestedObj1);
		list.add(nestedObj2);*/
		this.value1 = int1;
		this.value2 = str;
	}
}