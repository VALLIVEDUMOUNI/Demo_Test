package TestCases;
import utilities.excel;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;;

public class Get_list_users {
  @Test
  public void GET() throws BiffException, IOException {
	  excel e = new excel();
	  e.open("C:\\Users\\Vallivedu Mounika\\eclipse-workspace\\Api\\src\\test\\java\\TestData.xls");
	  String baseURI = e.readexcel(1, 18);
	    RestAssured.baseURI = baseURI;
	    String endpoint = e.readexcel(6,1);

	    Response response = RestAssured.get(endpoint);
	    String responseBody = response.getBody().prettyPrint();
	    //		  System.out.println("Response Body is =>  " + responseBody);
	    int responseStatusCode = response.getStatusCode();
	    System.out.println("************************************************");
	    System.out.println("Status Code => "+ responseStatusCode);
	    System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));
        System.out.println("GET-List Users Successful");
        if(responseStatusCode==200)
        {
            e.writexcel("TestCase",  13, 1, "Passed");

        }
        else
        {
            e.writexcel("TestCase",  13, 1, "Failed");

        }

  }
}

