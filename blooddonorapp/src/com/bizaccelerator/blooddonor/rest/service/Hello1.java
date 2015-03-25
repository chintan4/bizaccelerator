package com.bizaccelerator.blooddonor.rest.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.bizaccelerator.blooddonor.model.BagOfPrimitives;

// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/hello1")
public class Hello1 {

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    return "Hello Jersey";
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String sayXMLHello() {
	  ArrayList<BagOfPrimitives> list = new ArrayList<BagOfPrimitives>();
	  BagOfPrimitives obj1 = new BagOfPrimitives(3, "pqr");
	  BagOfPrimitives obj2 = new BagOfPrimitives(4, "xyz");
	  list.add(obj1);
	  list.add(obj2);
	  Gson gson = new Gson();
	  return gson.toJson(list);
	  
	  //return "{'employees':[{'firstName':'John', 'lastName':'Doe'},{'firstName':'Anna', 'lastName':'Smith'},{'firstName':'Peter', 'lastName':'Jones'}";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello() {
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
  }

} 