package excelReader;

//import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;


public class ExcelReader {
	
	
		public static void main(String[] args) throws IOException
		{

//			File f = new File("\"E:\\\\testdata.xlsx\"");
			FileInputStream file=null;
			
				file = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
				
			
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sh = wb.getSheetAt(0);

			int rowcount = sh.getLastRowNum()+1;
			int colcount= sh.getRow(0).getLastCellNum();
			
			for (int i = 0; i<rowcount; i++)
			{
				XSSFRow rw = sh.getRow(i);
				
				for(int j=0; j< colcount; j++)
				{
					XSSFCell cell = rw.getCell(j);
					System.out.print(cell.toString());
//					System.out.print(sh.getRow(i).getCell(j).toString());
					System.out.print("  |  ");
				}
				System.out.println();
			}
			
			wb.close();
		}

}
