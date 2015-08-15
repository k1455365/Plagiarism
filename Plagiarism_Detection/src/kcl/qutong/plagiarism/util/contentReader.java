package kcl.qutong.plagiarism.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * useing this class can read content with the type java support, this is project is mainly java file
 * @author qutong
 *
 */
public class contentReader {
	String content;
	String Codecontent;
	String Textcontent;


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCodecontent() {
		return Codecontent;
	}

	public void setCodecontent(String codecontent) {
		Codecontent = codecontent;
	}

	public String getTextcontent() {
		return Textcontent;
	}

	public void setTextcontent(String textcontent) {
		Textcontent = textcontent;
	}
	/**
	 * this method will select reader based on file type,this version type is selected by user
	 * @param filetype
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public  String readerManage(int filetype,File file) throws IOException{
//		1:text; 2:java
		switch (filetype) {
		case 1:
			content=buildin(file);
			break;
		case 2:
			content=buildin(file);
			break;
		}
		return content;
	}
	/**
	 * 
	 * @param file
	 * @return
	 * content of file with string type data
	 * @throws IOException
	 */
public String buildin(File file) throws IOException{

	FileReader freader = new FileReader(file);
    BufferedReader breader = new BufferedReader(freader);
    StringBuilder sb = new StringBuilder();
    try {
        String temp = "";
        /**
         * 读取文件内容，并将读取的每一行后都不加\n
         * 其目的是为了在解析双反斜杠（//）注释时做注释中止符
         */
        while((temp=breader.readLine())!= null)
        {
            sb.append(temp);
            sb.append('\n');
        }
        Codecontent = sb.toString();
    }catch (IOException e) {
        System.out.println("cant read file");
    }finally
    {
        breader.close();
        freader.close();
    }
	
	return Codecontent;
}
}
