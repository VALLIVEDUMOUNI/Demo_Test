package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

public class Put_update_user_Patch {
  @Test
  public void PUT() throws BiffException, IOException {
	  excel e = new excel();
	  e.open("C:\\Users\\Vallivedu Mounika\\eclipse-workspace\\Api\\src\\test\\java\\TestData.xls");
	  String baseURI = e.readexcel(1, 18);
	  RestAssured.baseURI = baseURI;
	  String endpoint = e.readexcel(6,8);
	  String name = e.readexcel(1,8);
	  String job = e.readexcel(2,8);

	  String j = "{\n"
              + "    \"name\": \""+ name +"\",\n"
              + "    \"job\": \""+ job + "\"\n"
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
	  if(responseStatusCode==201)
      {
          e.writexcel("TestCase",  13, 8, "Passed");

      }
      else
      {
          e.writexcel("TestCase",  13, 8, "Failed");

      }
	  if(responseStatusCode==204)
      {
          e.writexcel("TestCase",  13, 9, "Passed");

      }
      else
      {
          e.writexcel("TestCase",  13, 9, "Failed");

      }
	  
  }
}
