package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.read.biff.BiffException;
import utilities.excel;

public class Delete_Invalid {
  @Test
  public void delete_invalid() throws BiffException, IOException {
//	  public void delete_invalid() throws BiffException, IOException {
		  excel e = new excel();
		  e.open("C:\\Users\\Vallivedu Mounika\\eclipse-workspace\\Api\\src\\test\\java\\TestData.xls");
		  String baseURI = e.readexcel(1, 14);
		  RestAssured.baseURI = baseURI;
		  String endpoint = e.readexcel(6, 26);
		  Response response = RestAssured.get(endpoint);
		  RequestSpecification requestSpecification= RestAssured.given();
		  requestSpecification.contentType(ContentType.JSON);
		  Response response1 = requestSpecification.delete(endpoint);
		  System.out.println(response1.getStatusCode());
		  String responsestring = response1.asPrettyString();
		  System.out.println(responsestring);
		  System.out.println("Delete - Unsuccessful");
	
		  if(response1.getStatusCode()==204)
	      {
	          e.writexcel("TestCase",  13, 11, "Defect");

	      }
	      else
	      {
	          e.writexcel("TestCase",  13, 11, "Failed");
	      }
	  }
  }
