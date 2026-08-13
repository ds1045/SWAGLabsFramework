package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcelFile {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Write Data Back to Excel File
		// 1. Create the Java representation of physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/testscriptdata.xlsx");

		// 2. Open the workbook in read mode
		Workbook wb = WorkbookFactory.create(fis);

		// 3. Take the control of sheet
		Sheet sh = wb.getSheet("product");

		// 4. Take the control of row
		Row row = sh.getRow(1);

		// 5. We have to create a cell
		Cell cell = row.createCell(3);

		// 6. Specify cell type and cell value
		cell.setCellType(CellType.STRING);
		cell.setCellValue("Sauce Labs Fleece Jacket");

		// 7. Open Workbook in write mode
		FileOutputStream fos = new FileOutputStream("./src/test/resources/testscriptdata.xlsx");

		// 8. Save the excel
		wb.write(fos);
		System.out.println("Successfully written the data onto excel file!");

		// 9. Close the workbook
		wb.close();

	}

}
