package util;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class FileParsingUtil {

    public static void getMimeType(File file) {
        String mimeType;
        Tika tika = new Tika();

        try {
            mimeType = tika.detect(file);
            System.out.println("mimeType : "+mimeType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getMetadata(String filePath) {

        Tika tika = new Tika();
        Metadata metadata = new Metadata();

        try (TikaInputStream inputStream = TikaInputStream.get(Paths.get(filePath))) {
            String contents = tika.parseToString(inputStream, metadata);

            for(String name : metadata.names()) {
                System.out.println(name + " : " + metadata.get(name));
            }

        } catch (IOException | TikaException e) {
            e.printStackTrace();
        }
    }

    public static void getPdfContent(String filePath) {

        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        try {
            FileInputStream inputStream = new FileInputStream(new File(filePath));

            ParseContext parseContext = new ParseContext();

            PDFParser pdfparser = new PDFParser();
            pdfparser.parse(inputStream, handler, metadata,parseContext);

            System.out.println("Contents of the PDF :" + handler.toString());

            System.out.println("Metadata of the PDF:");
            String[] metadataNames = metadata.names();

            for(String name : metadataNames) {
                System.out.println(name+ " : " + metadata.get(name));
            }

        } catch ( IOException | TikaException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

}

