package com.project.createPDF;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.ReportController;
import com.project.dto.TestValues;

@WebServlet("/createPDF")
public class PDFCreation extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReportController rc = new ReportController();
		try {

			PDFCreate pc = new PDFCreate();
			
			ArrayList<TestValues> list = rc.getDetails();
			System.out.println("In the PDFCreation page after retriving the values for database");
			System.out.println(list);
		/*for(TestValues t: list) {
			String name = t.getName();
			String password = t.getPassword();
			int age = t.getAge();
			System.out.println(name+" "+password+" "+age);
			pc.creating(name, password, age);
		}*/
			pc.creating(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
