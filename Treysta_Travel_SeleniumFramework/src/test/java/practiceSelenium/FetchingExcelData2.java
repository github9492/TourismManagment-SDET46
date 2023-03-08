package practiceSelenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingExcelData2 {

	public static void main(String arg[]) throws EncryptedDocumentException, IOException {
		String expTestScriptName ="TourismCreatePackageTest";
		String expKey="packagelocation";
		DataFormatter df = new DataFormatter();
		FileInputStream fis= new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		short cellCount = sheet.getRow(1).getLastCellNum();
		String value="";
		for(int i =1; i<=rowCount;i++) {
			String testScriptname = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptname.equalsIgnoreCase(expTestScriptName)) {
				for(int j=0; j<cellCount; j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j)); 
					if(key.equalsIgnoreCase(expKey)) {
						value =df.formatCellValue(sheet.getRow(i+1).getCell(j));
						break;
					}
				}
				break;
			}

		}
		System.out.println(value);
	}
}
