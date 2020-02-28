package com.project.createPDF;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.project.dto.TestValues;

public class PDFCreate {
	public static void creating(ArrayList<TestValues> list) {
//		String name = n;
//		String password = p;
//		int age = a;
		/*System.out.println(name+" "+password+" "+age);
		*/Document document = new Document();
		System.out.println("**********inside document class");
		System.out.println("IN the pdf creation page");
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\Repo.pdf"));
	         document.open();
	         document.add(new Paragraph("A Hello World PDF document."));
	         document.add( Chunk.NEWLINE );
	         document.add( Chunk.NEWLINE );
	         PdfPTable pdfPTable = new PdfPTable(3);
	  
	         //Create cells
	         PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Name"));
	         PdfPCell pdfPCell2 = new PdfPCell(new Paragraph("Password"));
	         PdfPCell pdfPCell3 = new PdfPCell(new Paragraph("Age"));
	  
	         //Add cells to table
	         pdfPTable.addCell(pdfPCell1);
	         pdfPTable.addCell(pdfPCell2);
	         pdfPTable.addCell(pdfPCell3);
	  
	         //Add content to the document using Table objects.
	         //document.add(pdfPTable);
	         for(TestValues t : list) {
	        	 String name = t.getName();
	     		String password = t.getPassword();
	     		String age = Integer.toString(t.getAge());
	     		PdfPCell val1 = new PdfPCell(new Paragraph(name));
		         PdfPCell val2 = new PdfPCell(new Paragraph(password));
		         PdfPCell val3 = new PdfPCell(new Paragraph(age));
		         pdfPTable.addCell(val1);
		         pdfPTable.addCell(val2);
		         pdfPTable.addCell(val3);
	     		//document.add(new Paragraph(name+" "+password+" "+age));
	         }
	         document.add(pdfPTable);
	         document.close();
	         System.out.println("done with file");
	         writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
	 }

}
