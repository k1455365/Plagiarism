package kcl.qutong.plagiarism.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
public class TextFromPDF {
	/**
	 * simply reader all the text from a pdf file. 
	 * You have to deal with the format of the output text by yourself.
	 * 2008-2-25
	 * @param pdfFilePath file path
	 * @return all text in the pdf file
	 */
	public static String getTextFromPDF(String pdfFilePath) 
	{
		String result = null;
		FileInputStream is = null;
		PDDocument document = null;
		try {
			is = new FileInputStream(pdfFilePath);
			PDFParser parser = new PDFParser(is);
			parser.parse();
			document = parser.getPDDocument();
			PDFTextStripper stripper = new PDFTextStripper();
			result = stripper.getText(document);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (document != null) {
				try {
					document.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	public static String TextFromPDF_new(String pdfFilePath) throws IOException{
		System.out.println("*******************************using pdftotext_new****************************");
		String result = null;
		//MacOSRomanEncoding mac=new MacOSRomanEncoding();
		PDFTextStripper stripper=new PDFTextStripper ();
		PDDocument doc=PDDocument.load(pdfFilePath);
		result=stripper.getText(doc);
		//result=mac.getCharacter(result);
		return result;
	}
	static String pdftoText(String fileName) {
		System.out.println("*******************************using pdftotext****************************");
		PDFParser parser;
		String parsedText = null;;
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		File file = new File(fileName);
		if (!file.isFile()) {
			System.err.println("File " + fileName + " does not exist.");
			return null;
		}
		try {
			parser = new PDFParser(new FileInputStream(file));
		} catch (IOException e) {
			System.err.println("Unable to open PDF Parser. " + e.getMessage());
			return null;
		}
		try {
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument(cosDoc);
			pdfStripper.setStartPage(1);
			pdfStripper.setEndPage(5);
			parsedText = pdfStripper.getText(pdDoc);
		} catch (Exception e) {
			System.err
					.println("An exception occured in parsing the PDF Document."
							+ e.getMessage());
		} finally {
			try {
				if (cosDoc != null)
					cosDoc.close();
				if (pdDoc != null)
					pdDoc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		System.out.println("-------------------------content of first file is: \n"+parsedText);
		return parsedText;
	}
	public static String textFromFile(File file){
		String content=null;
		
		return content;
	}
}
