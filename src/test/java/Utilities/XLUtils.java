package Utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class XLUtils {
	
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int  getRowCount(String xlfile,String xlsheet) throws IOException {
		fi=new FileInputStream (xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		int rowcount =sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	public static int getcellcount(String xlfile,String xlsheet,int rownum) throws IOException {
		
		fi=new  FileInputStream(xlfile);
		wb=new XSSFWorkbook(xlsheet);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		int cellcount =row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	public static String getcellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException {
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		
		try {
			DataFormatter formatter=new DataFormatter();
			String cellData=formatter.formatCellValue(cell);
			return cellData;
		}catch(Exception e) {
			data=" ";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public static void setcellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException {
	
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}

}
