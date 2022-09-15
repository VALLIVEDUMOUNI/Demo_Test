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

public class Get_single_resource_notfound {
  @Test
  public void GET() throws BiffException, IOException {
	  
	  excel e = new excel();
	  e.open("C:\\Users\\Vallivedu Mounika\\eclipse-workspace\\Api\\src\\test\\java\\TestData.xls");
	  String baseURI = e.readexcel(1, 18);
	    RestAssured.baseURI = baseURI;
	    String endpoint = e.readexcel(6,6);
		  Response response = RestAssured.get(endpoint);
		String responseBody = response.getBody().prettyPrint();
//		System.out.println("Response Body is =>  " + responseBody);
		int responseStatusCode = response.getStatusCode();
		System.out.println("************************************************");
		System.out.println("Status Code => "+ responseStatusCode);
		System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));	
        System.out.println("GET-Single resource not found - successful");
        if(responseStatusCode==404)
        {
            e.writexcel("TestCase",  13, 6, "Passed");

        }
        else
        {
            e.writexcel("TestCase",  13, 6, "Failed");

        }

  }
}
