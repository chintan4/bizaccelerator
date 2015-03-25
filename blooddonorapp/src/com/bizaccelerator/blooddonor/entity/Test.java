package com.bizaccelerator.blooddonor.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Test implements Serializable {
//@Id @GeneratedValue private int id;
@Id @GeneratedValue private int id;
@Basic private String val1;
@Basic private String val2;
@Basic private String val3;
@Basic private String val4;

public Test() {}
public Test(String value1, String value2, String value3, String value4) {
     val1 = value1;
     val2 = value2;
     val3 = value3;
     val4 = value4;
}

public String toString() {
     return "Value1=" + val1 + ", Value2=" + val2 + ", Value3=" + val3 + ", Value4=" + val4;
}
}