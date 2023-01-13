//package com.kafkaQueue.bot.pdfExport;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.CMYKColor;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.kafkaQueue.bot.entity.User;
//import com.kafkaQueue.bot.repository.MessageRepo;
//import com.kafkaQueue.bot.repository.UserDetailsRepo;
//
//import jakarta.servlet.http.HttpServletResponse;
//
//
//@Service
//public class UserPDFExporter {
//	private List<User> listUsers;
//
//	@Autowired
//	UserDetailsRepo userDetailsRepo;
//
//	
//
//	@Autowired
//	MessageRepo messageRepo;
//
//	private XSSFWorkbook workbook;
//	private XSSFSheet sheet;
//
//
//
//	public void generate() throws DocumentException, IOException {
//
//		Document document = new Document(PageSize.A4);
//		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
////		PdfWriter.getInstance(document,byteArrayOutputStream);
//		PdfWriter.getInstance(document, Files.newOutputStream(Paths.get("sumeet.pdf")));
////		PdfWriter.getInstance(document, response.getOutputStream());
//
//		document.open();
//
//		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//		fontTitle.setSize(20);
//
//		Paragraph paragraph1 = new Paragraph("Users Report", fontTitle);
//
//		paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
//
//		document.add(paragraph1);
//
//		PdfPTable table = new PdfPTable(4);
//
//		table.setWidthPercentage(100);
//		table.setWidths(new int[] {3,3,3,3});
//		table.setSpacingBefore(5);
//
//		PdfPCell cell = new PdfPCell();
//
//		cell.setBackgroundColor(CMYKColor.BLUE);
//		cell.setPadding(5);
//
//		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//		font.setColor(CMYKColor.WHITE);
//
//		cell.setPhrase(new Phrase("User", font));
//		table.addCell(cell);
//		cell.setPhrase(new Phrase("Total Messages", font));
//		table.addCell(cell);
//		List<User> userList = userDetailsRepo.findAll();
//
//
//		for (User user: userList) {
//
////			table.addCell(String.valueOf(user.getUserNumber()));
//			table.addCell(String.valueOf(1));
////			table.addCell(String.valueOf(messageRepo.findTotalMessagesByUser(user).size()));
//			table.addCell("1212");
////			table.addCell("1212");
//
////			table.addCell("1212");
//
////			table.addCell(student.getStudentName());
//		}
//
//		// Adding the created table to the document
//		document.add(table);
//		// Closing the document
//		document.close();
//	}
//}
