package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import model.CommandDictionary;
import model.Turtle;
import model.VariableDictionary;
import org.w3c.dom.*;

import java.io.File;
import java.util.List;


/**
 * Created by blakekaplan on 3/4/16.
 */
public class XMLSaver {

    public static final String XML_STYLE = "{http://xml.apache.org/xslt}indent-amount";
    public static final String ROOT_TEXT = "SLogo Configuration";
    public static final String CONFIG = "Config";
    public static final String BACKGROUND_COLOR = "Background Color";
    public static final String PEN_COLOR = "Pen Color";
    public static final String TURTLES = "Turtles";
    public static final String TURTLE = "Turtle";
    public static final String IMAGE = "Image";
    public static final String Y = "Y";
    public static final String X = "X";
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

    private Element getConfig(String backgroundColor, String penColor) {
        Element configElement = myDocument.createElement(CONFIG);
        configElement.appendChild(makeElement(BACKGROUND_COLOR, backgroundColor));
        configElement.appendChild(makeElement(PEN_COLOR, penColor));
        return configElement;
    }

    private Element getTurtles(List<Turtle> myTurtles) {
        Element turtleElement = myDocument.createElement(TURTLES);

        return turtleElement;
    }

    private Element makeTurtleElement(Turtle myTurtle) {
        Element turtleElement = myDocument.createElement(TURTLE);
        turtleElement.appendChild(makeElement(X, "" + myTurtle.getCurX()));
        turtleElement.appendChild(makeElement(Y, "" + myTurtle.getCurY()));
        turtleElement.appendChild(makeElement(IMAGE, "" + myTurtle.getImage().toString()));
        return turtleElement;
    }

    private Element makeElement(String nodeName, String data) {
        Element myElement = myDocument.createElement(nodeName);
        myElement.appendChild(myDocument.createTextNode(data));
        return myElement;
    }

}
