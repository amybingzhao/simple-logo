package XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import Model.CommandDictionary;
import Model.Turtle;
import Model.VariableDictionary;
import org.w3c.dom.*;

import java.awt.*;
import java.io.File;
import java.util.List;


/**
 * Created by blakekaplan on 3/4/16.
 */
public class XMLSaver {

    public static final String XML_STYLE = "{http://xml.apache.org/xslt}indent-amount";
    public static final String ROOT_TEXT = "SLogo Configuration";
    private DocumentBuilderFactory myFactory;
    private DocumentBuilder myBuilder;
    private Document myDocument;
    private CommandDictionary myCommandDict;
    private VariableDictionary myVarDict;

    public XMLSaver(CommandDictionary comDict, VariableDictionary varDict) {

        try {
            myFactory = DocumentBuilderFactory.newInstance();
            myBuilder = myFactory.newDocumentBuilder();
            myCommandDict = comDict;
            myVarDict = varDict;
        } catch (ParserConfigurationException e) {
            System.out.println("Document Builder Error");
        }
    }

    public void generateFile(String imgName, String backgroundColor, String penColor, String language, List<Turtle> turtles, File file) {
        System.out.println(imgName);
        System.out.println(backgroundColor);
        System.out.println(penColor);
        System.out.println(language);
        for (Turtle myTurt : turtles) {
            System.out.println(myTurt);
        }
        System.out.println(file.getName());
//        myDocument = myBuilder.newDocument();
//        Element myRoot = myDocument.createElement(ROOT_TEXT);
    }

    public void createFile(File file) {
        TransformerFactory myTransformerFactory = TransformerFactory.newInstance();
        Transformer myTransformer;
        try {
            myTransformer = myTransformerFactory.newTransformer();
            myTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
            myTransformer.setOutputProperty(OutputKeys.METHOD, "xml");
            myTransformer.setOutputProperty(XML_STYLE, "4");
            DOMSource mySource = new DOMSource(myDocument);
            StreamResult myResult = new StreamResult(file);
            myTransformer.transform(mySource, myResult);
        } catch (Exception e) {
            System.out.println("File Creation Error");
        }
    }

//    private Element getConfig(){
//
//    }
}
