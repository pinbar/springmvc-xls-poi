package com.percipient.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.percipient.bean.Student;

public class RichStudentXLSView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Student student = (Student) model.get("stud");

		HSSFSheet sheet = workbook.createSheet("Student Report");

		HSSFRow header = sheet.createRow(0);
		CellStyle headerStyle = getHeaderStyle(workbook);

		Cell c1 = header.createCell(0);
		c1.setCellValue("First Name");
		c1.setCellStyle(headerStyle);
		Cell c2 = header.createCell(1);
		c2.setCellValue("Last Name");
		c2.setCellStyle(headerStyle);

		HSSFRow row = sheet.createRow(1);
		CellStyle rowStyle = getRowStyle(workbook);

		Cell c3 = row.createCell(0);
		c3.setCellValue(student.getFirstName());
		c3.setCellStyle(rowStyle);
		Cell c4 = row.createCell(1);
		c4.setCellValue(student.getLastName());
		c4.setCellStyle(rowStyle);
	}

	private CellStyle getHeaderStyle(HSSFWorkbook workbook) {

		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(Font.COLOR_RED);
		font.setFontName("Tahoma");

		style.setFont(font);
		return style;
	}

	private CellStyle getRowStyle(HSSFWorkbook workbook) {

		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		font.setColor(Font.COLOR_NORMAL);
		font.setItalic(true);
		font.setFontName("Times New Roman");

		style.setFont(font);
		return style;
	}
}
