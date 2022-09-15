package TestCases;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.excel;

public class Delete_user {
  @Test
  public void delete() throws BiffException, IOException {
	  excel e = new excel();
	  e.open("C:\\Users\\Vallivedu Mounika\\eclipse-workspace\\Api\\src\\test\\java\\TestData.xls");
	  String baseURI = e.readexcel(1, 18);
	  RestAssured.baseURI = baseURI;
	  String endpoint = e.readexcel(6,10);
	  Response response = RestAssured.get(endpoint);
	  RequestSpecification requestSpecification= RestAssured.given();
	  requestSpecification.contentType(ContentType.JSON);
	  Response response1 = requestSpecification.delete(endpoint);
	  System.out.println(response1.getStatusCode());
	  String responsestring = response1.asPrettyString();
	  System.out.println(responsestring);
	  System.out.println("Delete - successful");
	  
	  if(response1.getStatusCode()==204)
      {
          e.writexcel("TestCase",  13, 10, "Passed");

      }
      else
      {
          e.writexcel("TestCase",  13, 10, "Failed");
      }
	  if(response1.getStatusCode()==200)
      {
          e.writexcel("TestCase",  13, 11, "Passed");

      }
      else
      {
          e.writexcel("TestCase",  13, 11, "Failed");
      }
  }
}

