package com.ev.conv;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SignalList {

	private final static Map<String, Signal> signalMap = new HashMap<String, Signal>();

	static {

		FileInputStream fs = null;
		try {
			fs = new FileInputStream("mapping-conf.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(new BufferedInputStream(fs));

			XSSFSheet sheet = wb.getSheetAt(0);
			int rowcount = sheet.getLastRowNum();
			for (int i = 1; i <= rowcount; i++) {
				XSSFRow row = sheet.getRow(i);

				Signal signal = new Signal();
				signal.setSignalMeaning(row.getCell(0).getStringCellValue());
				signal.setLength((int) row.getCell(1).getNumericCellValue());
				signal.setSignalName(row.getCell(2).getStringCellValue());
				signal.setDesc(row.getCell(3).getStringCellValue());

				String dataType = row.getCell(4).getStringCellValue();
				signal.setDataType(dataType);
				if ("number".equals(dataType)) {
					signal.setOffset((int) row.getCell(5).getNumericCellValue());
					signal.setResolution(row.getCell(6).getNumericCellValue());
					signal.setDefVal(getStringCellValue(row.getCell(7)));
				} else if ("enum".equals(dataType)) {
					signal.setDefVal(String.valueOf((int) row.getCell(7).getNumericCellValue()));
				} else if ("string".equals(dataType)) {
					signal.setDefVal(row.getCell(7).getStringCellValue());
				}

				System.out.println(signal);
				signalMap.put(signal.getSignalName(), signal);
			}

			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@SuppressWarnings("deprecation")
	private static String getStringCellValue(XSSFCell cell) {
		String strCell = "";
		switch (cell.getCellType()) {
		case XSSFCell.CELL_TYPE_STRING:
			strCell = cell.getStringCellValue();
			break;
		case XSSFCell.CELL_TYPE_NUMERIC:
			strCell = String.valueOf(cell.getNumericCellValue());
			break;
		case XSSFCell.CELL_TYPE_BOOLEAN:
			strCell = String.valueOf(cell.getBooleanCellValue());
			break;
		case XSSFCell.CELL_TYPE_BLANK:
			strCell = "";
			break;
		default:
			strCell = "";
			break;
		}
		if (strCell.equals("") || strCell == null) {
			return "";
		}
		return strCell;
	}

	public static void main(String[] args) {
		System.out.println(SignalList.getSignal("Ignition_status"));
	}

	public static Signal getSignal(String signalName) {
		return signalMap.get(signalName);
	}

}
