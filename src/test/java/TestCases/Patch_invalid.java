package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.read.biff.BiffException;
import utilities.excel;

public class Patch_invalid {
  @Test
  public void patch_invalid() throws BiffException, IOException {
	  excel e = new excel();
	  e.open("C:\\Users\\Vallivedu Mounika\\eclipse-workspace\\Api\\src\\test\\java\\TestData.xls");
	  String baseURI = e.readexcel(1, 14);
	  RestAssured.baseURI = baseURI;
	  String endpoint = e.readexcel(6, 7);
	  String name = e.readexcel(1,7);
//	  String job = e.readexcel(2,7);

	  String j = "{\n"
              + "    \"name\": \""+ name + "\"\n"
              + "}";
	  RequestSpecification requestSpecification= RestAssured.given();
      requestSpecification.contentType(ContentType.JSON);
      requestSpecification.body(j);
      Response response = requestSpecification.post(endpoint);
      String responsestring = response.asPrettyString();
      System.out.println(responsestring);
	  int responseStatusCode = response.getStatusCode();
	  System.out.println("************************************************");
	  System.out.println("Status Code => "+ responseStatusCode);
	  System.out.println("Updation Successful");
	  if(responseStatusCode==200)
      {
          e.writexcel("TestCase",  13, 9, "Passed");

      }
      else
      {
          e.writexcel("TestCase",  13, 9, "Failed");

      }
	  
  }
  }
