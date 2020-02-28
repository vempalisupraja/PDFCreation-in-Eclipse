package com.sample.create;


import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

public class SampleDocument {
	public static void creating() {
		Document document = new Document();
		System.out.println("**********inside document class");
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("newreoprt.pdf"));
	         document.open();
	         document.add(new Paragraph("A Hello World PDF document."));
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

