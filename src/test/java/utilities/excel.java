package utilities;


//import java.io.File;
//import java.io.IOException;
//
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//
//
//
//public class excel  {
//	
//    public File f;
//
//	public Cell getsheet() throws BiffException, IOException
//    {      f = new File("C:\\Users\\Vallivedu Mounika\\\\eclipse-workspace\\\\Api\\\\src\\\\test\\\\java\\\\TestData.xls");
//
//         Workbook wb = Workbook.getWorkbook(f);
//        Sheet sheet1 = wb.getSheet(1);
//        return sheet1.getCell(1, 1);
//    }
//        
//    
//}


import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class excel {
	String p;
	 String data;
     File f;
    Workbook b;
    WritableWorkbook wwbCopy;
 public File open(String path) {
	p=path;
	  f=new File(p);
	return (f);
     }
public String readexcel(int x,int y) throws BiffException, IOException {
	 b=Workbook.getWorkbook(f);
    Sheet s1=  b.getSheet(0);
      Cell c=s1.getCell(x,y );
     data= c.getContents();    
      b.close();   
	return(data);
}
public void writexcel(String sheetname,int x,int y,String content) throws BiffException, IOException {
    b=Workbook.getWorkbook(f);
	wwbCopy = Workbook.createWorkbook(f, b);
//    Sheet shSheet = wwbCopy.getSheet(1);
	WritableSheet wshTemp = wwbCopy.getSheet("TestCase");
     Label labTemp = new Label(x, y, content);
             
         
     try {
         wshTemp.addCell(labTemp);
          
         // Closing the writable work book
         wwbCopy.write();
         wwbCopy.close();

         // Closing the original work book
         b.close();
     } catch (Exception e)

     {
         e.printStackTrace();
     }
 

     
    
}
/*public void closexl() {
	
	 bk.close();
}*/

}