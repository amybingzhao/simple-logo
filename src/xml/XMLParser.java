package xml;

import org.xml.sax.SAXException;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by blakekaplan on 3/4/16.
 */
public class XMLParser {

    private DocumentBuilderFactory myFactory;
    private DocumentBuilder myBuilder;

    public void parse(File myFile) throws IOException, ParserConfigurationException, SAXException {
        myFactory = DocumentBuilderFactory.newInstance();
        myBuilder = myFactory.newDocumentBuilder();
        Document myDocument = myBuilder.parse(myFile);
    }

}
