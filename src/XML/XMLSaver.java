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
import java.util.ArrayList;
import java.util.List;


/**
 * Created by blakekaplan on 3/4/16.
 */
public class XMLSaver {

    public static final String XML_STYLE = "{http://xml.apache.org/xslt}indent-amount";
    public static final String ROOT_TEXT = "SLogoConfiguration";
    public static final String CONFIG = "Config";
    public static final String BACKGROUND_COLOR = "BackgroundColor";
    public static final String PEN_COLOR = "PenColor";
    public static final String TURTLES = "Turtles";
    public static final String TURTLE = "Turtle";
    public static final String IMAGE = "Image";
    public static final String Y = "Y";
    public static final String X = "X";
    public static final String ID = "ID";
    public static final String DIRECTION = "Direction";
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
        myDocument = myBuilder.newDocument();
        Element myRoot = myDocument.createElement("SLogoState");
        myDocument.appendChild(myRoot);
        myRoot.appendChild(getConfig(backgroundColor, penColor));
        myRoot.appendChild(getTurtles(turtles));
        createFile(file);
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
        for (Turtle myTurtle : myTurtles) {
            turtleElement.appendChild(makeTurtleElement(myTurtle));
        }
        return turtleElement;
    }

    private Element makeTurtleElement(Turtle myTurtle) {
        Element turtleElement = myDocument.createElement(TURTLE);
        turtleElement.appendChild(makeElement(ID, "" + myTurtle.getID()));
        turtleElement.appendChild(makeElement(X, "" + myTurtle.getCurX()));
        turtleElement.appendChild(makeElement(Y, "" + myTurtle.getCurY()));
        turtleElement.appendChild(makeElement(DIRECTION, "" + myTurtle.getDirection()));
        turtleElement.appendChild(makeElement(IMAGE, "" + myTurtle.getImage()));
        return turtleElement;
    }

    private Element makeElement(String nodeName, String data) {
        Element myElement = myDocument.createElement(nodeName);
        myElement.appendChild(myDocument.createTextNode(data));
        return myElement;
    }

    public static void main(String[] args) {
        XMLSaver mySaver = new XMLSaver(new CommandDictionary(), new VariableDictionary());
        List<Turtle> myTurts = new ArrayList<>();
        Turtle myTurtle = new Turtle(30);
        Turtle otherTurtle = new Turtle(40);
        myTurts.add(myTurtle);
        myTurts.add(otherTurtle);
        mySaver.generateFile("Test1", "Test2", "Test3", "Test4", myTurts, new File("test.xml"));
    }

}
