package utilityClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	public String path;
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public ExcelWriter(String path) {
		this.path = path;
	}

	public void writingInExcel(String sheetname, int numOfRows, int numOfColumns, Object[][] data) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("sheetname");

		for (int r = 0; r < numOfRows; r++) {
			row = sheet.createRow(r);
			for (int c = 0; c < numOfColumns; c++) {
				cell = row.createCell(c);
				Object value = data[r][c];
				if (value instanceof String) {
					cell.setCellValue((String) value);
				} else if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				} else if (value instanceof Float) {
					cell.setCellValue((Float) value);
				}
			}
		}
		fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		System.out.println("Data has been inserted in ecxel file sucessfully");
	}

}
