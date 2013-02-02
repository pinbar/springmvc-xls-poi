package com.percipient.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.percipient.bean.Student;

public class SimpleStudentXLSView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Student student = (Student) model.get("stud");
		
		HSSFSheet sheet = workbook.createSheet("Student Report");

		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("First Name");
		header.createCell(1).setCellValue("Last Name");
		
		HSSFRow row = sheet.createRow(1);
		row.createCell(0).setCellValue(student.getFirstName());
		row.createCell(1).setCellValue(student.getLastName());
	}
}
