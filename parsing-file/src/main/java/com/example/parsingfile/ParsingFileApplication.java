package com.example.parsingfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import util.FileParsingUtil;

import java.io.File;

@SpringBootApplication
public class ParsingFileApplication {

	static String FILE_PATH = "파일위치";


	static FileParsingUtil parsingUtil;

	public static void main(String[] args) {
		SpringApplication.run(ParsingFileApplication.class, args);

		parsingUtil = new FileParsingUtil();
		parsingUtil.getMetadata(FILE_PATH);
		parsingUtil.getMimeType(new File(FILE_PATH));
		parsingUtil.getPdfContent(FILE_PATH);
	}



}
