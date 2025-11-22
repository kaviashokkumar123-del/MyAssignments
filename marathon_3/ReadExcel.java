package marathon_3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readData() throws IOException {
		//set up the [ppath
		XSSFWorkbook wb = new XSSFWorkbook("./Excel_Files/Salesforce.xlsx");
		
		//workSheet
		XSSFSheet ws = wb.getSheetAt(0);
		
		//to get the row count
		int rounCount = ws.getLastRowNum();
		System.out.println(rounCount);
		
		//get the column count
		int colCount = ws.getRow(1).getLastCellNum();
		System.out.println(colCount);
		
		//Create 2D array
		String[][] data = new String[rounCount][colCount];
		for(int i=0;i<rounCount; i++)
		{
			for(int j=0;j<colCount;j++)
			{
				String getCellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i][j]=getCellValue;
			}
		}
		wb.close();
		return data;
	}
	
	public static String[][] readData1() throws IOException {
		//set up the [ppath
		XSSFWorkbook wb = new XSSFWorkbook("./Excel_Files/Salesforce.xlsx");
		
		//workSheet
		XSSFSheet ws = wb.getSheetAt(1);
		
		//to get the row count
		int rounCount = ws.getLastRowNum();
		System.out.println(rounCount);
		
		//get the column count
		int colCount = ws.getRow(1).getLastCellNum();
		System.out.println(colCount);
		
		//Create 2D array
		String[][] data = new String[rounCount][colCount];
		for(int i=0;i<rounCount; i++)
		{
			for(int j=0;j<colCount;j++)
			{
				String getCellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i][j]=getCellValue;
			}
		}
		wb.close();
		return data;
	}
}
