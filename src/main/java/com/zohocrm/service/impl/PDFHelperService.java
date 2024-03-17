package com.zohocrm.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.zohocrm.entity.Lead;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import static com.mysql.cj.conf.PropertyKey.logger;

public class PDFHelperService {


    public static ByteArrayInputStream employeePDFReport
            (List<Lead> leads) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);
            document.open();

            // Add Text to PDF file ->
            Font font = FontFactory
                    .getFont(FontFactory.COURIER, 14,BaseColor.BLACK);
            Paragraph para = new Paragraph("Employee Table", font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(10);
            // Add PDF Table Header ->
            Stream.of("Lead ID", "First Name", "Last Name","Email","Mobile","Lead Type","Address","Designation","Company","Note")
                    .forEach(headerTitle ->
                    {
                        PdfPCell header = new PdfPCell();
                        Font headFont = FontFactory.
                                getFont(FontFactory.HELVETICA_BOLD);
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, headFont));
                        table.addCell(header);
                    });

            for (Lead lead : leads) {
                PdfPCell idCell = new PdfPCell(new Phrase(lead.getLid().
                        toString()));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);

                PdfPCell firstNameCell = new PdfPCell(new Phrase
                        (lead.getFirstname()));
                firstNameCell.setPaddingLeft(4);
                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                firstNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(firstNameCell);

                PdfPCell lastNameCell = new PdfPCell(new Phrase
                        (String.valueOf(lead.getLastname())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                lastNameCell.setPaddingRight(4);
                table.addCell(lastNameCell);

                PdfPCell emailNameCell = new PdfPCell(new Phrase
                        (String.valueOf(lead.getEmail())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                lastNameCell.setPaddingRight(4);
                table.addCell(emailNameCell);

                PdfPCell mobileNameCell = new PdfPCell(new Phrase
                        (String.valueOf(lead.getMobile())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                lastNameCell.setPaddingRight(4);
                table.addCell(mobileNameCell);

                PdfPCell leadTypeNameCell = new PdfPCell(new Phrase
                        (String.valueOf(lead.getLeadType())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                lastNameCell.setPaddingRight(4);
                table.addCell(leadTypeNameCell);

                PdfPCell addressNameCell = new PdfPCell(new Phrase
                        (String.valueOf(lead.getAddress())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                lastNameCell.setPaddingRight(4);
                table.addCell(addressNameCell);

                PdfPCell designationNameCell = new PdfPCell(new Phrase
                        (String.valueOf(lead.getDesignation())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                lastNameCell.setPaddingRight(4);
                table.addCell(designationNameCell);

                PdfPCell companyNameCell = new PdfPCell(new Phrase
                        (String.valueOf(lead.getCompany())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                lastNameCell.setPaddingRight(4);
                table.addCell(companyNameCell);

                PdfPCell noteNameCell = new PdfPCell(new Phrase
                        (String.valueOf(lead.getNote())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                lastNameCell.setPaddingRight(4);
                table.addCell(noteNameCell);
            }
            document.add(table);

            document.close();
        } catch (DocumentException e) {
            System.out.println(e.toString());
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}