package com.bizaccelerator.blooddonor.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bizaccelerator.blooddonor.entity.util.BloodDonorDBUtil;
import com.bizaccelerator.blooddonor.model.Requestdetail;
import com.bizaccelerator.blooddonor.model.custom.TrimmedRequestDetail;
import com.google.gson.Gson;

// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/retrieveBloodRequets")
public class RetrieveBloodRequests {

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
	  try {
		/*ArrayList<BagOfPrimitives> list = new ArrayList<BagOfPrimitives>();
		  BagOfPrimitives obj1 = new BagOfPrimitives(1, "abc");
		  BagOfPrimitives obj2 = new BagOfPrimitives(2, "def");
		  list.add(obj1);
		  list.add(obj2);
		  Gson gson = new Gson();
		  TestUtil testUtil = new TestUtil();
		  List testList = testUtil.readTest("test34");
		  
		  Gson gson = new Gson();
		  return gson.toJson(testList);*/
		BloodDonorDBUtil bDUtil = new BloodDonorDBUtil();
		List<TrimmedRequestDetail> bloodRequestList = bDUtil.getBloodRequests();
		Gson gson = new Gson();
		return gson.toJson(bloodRequestList);
		//return "{'employees':[{'firstName':'John', 'lastName':'Doe'},{'firstName':'Anna', 'lastName':'Smith'},{'firstName':'Peter', 'lastName':'Jones'}";
	} catch (Exception e) {
		e.printStackTrace();
	}
	  return "";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello() {
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
  }

} 