package utilities;

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
	WritableSheet wshTemp = wwbCopy.getSheet("TestCase");
     Label labTemp = new Label(x, y, content);
             
         
     try {
         wshTemp.addCell(labTemp);        
         wwbCopy.write();
         wwbCopy.close();
         b.close();
     } catch (Exception e)

     {
         e.printStackTrace();
     }
}
}