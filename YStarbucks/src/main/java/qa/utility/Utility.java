package qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static String generateRandomMobileNumber() {
        Random random = new Random();
        
        // Generate random 10-digit number
        int areaCode = random.nextInt(900) + 100; // Area code should be 3 digits
        int exchangeCode = random.nextInt(900) + 100; // Exchange code should be 3 digits
        int subscriberNumber = random.nextInt(10000); // Subscriber number should be 4 digits
        
        // Format as XXX-XXX-XXXX
        return String.format("%03d-%03d-%04d", areaCode, exchangeCode, subscriberNumber);
    }
	
	static String signinExcelPath ="\\src\\main\\java\\qa\\testdata\\starbucks.xlsx";
	static String signupExcelPath ="\\src\\main\\java\\qa\\testdata\\starbuckssignup.xlsx";
	public static Object[][] getDataFromexcel(String sheetName) throws IOException
	{
		File file = null;
		//File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\qa\\testdata\\starbucks.xlsx");
		if(sheetName.equalsIgnoreCase("star")) {
		file = new File(System.getProperty("user.dir")+signinExcelPath);
		}else if(sheetName.equalsIgnoreCase("signup")) {
		file = new File(System.getProperty("user.dir")+signupExcelPath);	
		}
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][columns];
		
		for(int i=0;i<rows;i++)
		{
			XSSFRow row = sheet.getRow(i+1);
			for(int j=0;j<columns;j++)
			{
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch(cellType) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;
		
	}
	
	public static String captureScreenshot(WebDriver driver,String testName) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try{
			FileHandler.copy(src, new File(dest));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return dest;
	}
	
}
