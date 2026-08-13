package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Read the Data from Excel File
		// 1. Create the object of java representation file
		FileInputStream fis = new FileInputStream("./src/test/resources/testscriptdata.xlsx");

		// 2. Open the excel in Read Mode
		Workbook wb = WorkbookFactory.create(fis);

		// 3. Get the control of sheet
		Sheet sh = wb.getSheet("product");

		// 4. Get the control of row
		Row row = sh.getRow(1);

		// 5. Get the control of cell
		Cell cell = row.getCell(2);

		// 6. Read the data
		String data = cell.getStringCellValue();
		System.out.println("Product Name --> "+data);

		// 7. Close the WorkBook
		wb.close();
	}

}
