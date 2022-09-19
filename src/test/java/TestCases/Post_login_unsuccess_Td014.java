package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.read.biff.BiffException;
import utilities.excel;

public class Post_login_unsuccess_Td014 {
  @Test
  public void Td014() throws BiffException, IOException {
	  excel e = new excel();
	  e.open("C:\\Users\\Vallivedu Mounika\\eclipse-workspace\\Api\\src\\test\\java\\TestData.xls");
	  String baseURI = e.readexcel(1, 14);
	  RestAssured.baseURI = baseURI;
	  String endpoint = e.readexcel(6,19);
	  String email = e.readexcel(3,19);
	  String password = e.readexcel(4,19);

      String j = "{\n"
              + "    \"email\": \""+ email +"\",\n"
              + "    \"password\": \""+ password + "\"\n"
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
	  System.out.println("User login UnSuccessful");	
	  if(responseStatusCode==400)
      {
          e.writexcel("TestCase",  13, 15, "Passed");

      }
      else
      {
          e.writexcel("TestCase",  13, 15, "Failed");

      }
  }
  }
