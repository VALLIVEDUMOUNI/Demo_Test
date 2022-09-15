package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.excel;

public class Get_single_resource {
  @Test
  public void GET() throws BiffException, IOException {
	  excel e = new excel();
	  e.open("C:\\Users\\Vallivedu Mounika\\eclipse-workspace\\Api\\src\\test\\java\\TestData.xls");
	  String baseURI = e.readexcel(1, 18);
	  RestAssured.baseURI = baseURI;
	  String endpoint = e.readexcel(6,5);
	  Response response = RestAssured.get(endpoint);
	  String responseBody = response.getBody().prettyPrint();
	  int responseStatusCode = response.getStatusCode();
	  System.out.println("************************************************");
	  System.out.println("Status Code => "+ responseStatusCode);
	  System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));	
      System.out.println("GET-Single resource - successful");
      if(responseStatusCode==200)
      {
          e.writexcel("TestCase",  13, 5, "Passed");

      }
      else
      {
          e.writexcel("TestCase",  13, 5, "Failed");

      }

  }
}
