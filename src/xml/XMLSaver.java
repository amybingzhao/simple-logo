package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import controller.Controller;
import controller.Parser;
import guipackage.GUICanvas;
import model.*;
import model.Node;
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
    public static final String VARIABLES = "Variables";
    public static final String COMMANDS = "Commands";
    public static final String COMMAND = "Command";
    public static final String NAME = "Name";
    public static final String PROCEDURE = "Procedure";
    public static final String NUMBER_OF_ARGUMENTS = "NumberOfArguments";
    public static final String TURTLE_IMAGE = "TurtleImage";
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

    public void generateFile(String backgroundColor, String penColor, String turtleImage, String language, List<Turtle> turtles, File file) {
        myDocument = myBuilder.newDocument();
        Element myRoot = myDocument.createElement("SLogoState");
        myDocument.appendChild(myRoot);
        myRoot.appendChild(getConfig(backgroundColor, penColor, turtleImage));
        myRoot.appendChild(getVariables());
        myRoot.appendChild(getCommands());
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
            e.printStackTrace();
            System.out.println("File Creation Error");
        }
    }

    private Element getConfig(String backgroundColor, String penColor, String turtleImage) {
        Element configElement = myDocument.createElement(CONFIG);
        configElement.appendChild(makeElement(BACKGROUND_COLOR, backgroundColor));
        configElement.appendChild(makeElement(PEN_COLOR, penColor));
        configElement.appendChild(makeElement(TURTLE_IMAGE, turtleImage));
        return configElement;
    }

    private Element getVariables() {
        Element variablesElement = myDocument.createElement(VARIABLES);
        for (String key : myVarDict.getKeySet()) {
            variablesElement.appendChild(makeElement(key, "" + (int) myVarDict.getNodeFor(key) ));
        }
        return variablesElement;
    }

    private Element getCommands() {
        Element commandElement = myDocument.createElement(COMMANDS);
        for (String key : myCommandDict.getCommandTextKeySet()) {
            commandElement.appendChild(makeCommandElement(key));
        }
        return commandElement;
    }

    private Element makeCommandElement(String key) {
        Element commandElement = myDocument.createElement(COMMAND);
        commandElement.appendChild(makeElement(NAME, key));
        commandElement.appendChild(makeElement(PROCEDURE, myCommandDict.getCommandTextForKey(key)));
        commandElement.appendChild(makeElement(NUMBER_OF_ARGUMENTS, "" + myCommandDict.getNumArgsForkey(key)));
        return commandElement;
    }

    private Element makeElement(String nodeName, String data) {
        Element myElement = myDocument.createElement(nodeName);
        myElement.appendChild(myDocument.createTextNode(data));
        return myElement;
    }
}
