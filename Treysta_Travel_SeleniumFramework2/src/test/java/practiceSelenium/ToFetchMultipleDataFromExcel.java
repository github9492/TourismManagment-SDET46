package practiceSelenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToFetchMultipleDataFromExcel {

	public static void main(String arg[]) throws EncryptedDocumentException, IOException {
		String expTestScriptName ="ManagePackageTest";
		String expKey="packagename";
		DataFormatter df = new DataFormatter();
		FileInputStream fis= new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		List<String> dataList =new ArrayList<>();

		for(int i =1; i<=rowCount;i++) {
			String testScriptname = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptname.equalsIgnoreCase(expTestScriptName)) {
				for(int j=0; j<sheet.getRow(i).getLastCellNum(); j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(key.equalsIgnoreCase(expKey)) {
						for(int k=i+1; ;k++) {
							String data = df.formatCellValue(sheet.getRow(k).getCell(j));
							if(data.equals("")) {
								break;
							}

							else{
								dataList.add(data);
								
							}
							 
						}
						break;
					}
					

				}
				break;
			}
		}
		System.out.println(dataList);

	}
}


