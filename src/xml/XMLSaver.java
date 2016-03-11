package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import model.*;
import org.w3c.dom.*;

import java.io.File;
import java.util.List;


/**
 * Created by blakekaplan on 3/4/16.
 */
public class XMLSaver {

    private static final String XML_STYLE = "{http://xml.apache.org/xslt}indent-amount";
    private static final String CONFIG = "Config";
    private static final String BACKGROUND_COLOR = "BackgroundColor";
    private static final String PEN_COLOR = "PenColor";
    private static final String VARIABLES = "Variables";
    private static final String COMMANDS = "Commands";
    private static final String COMMAND = "Command";
    private static final String NAME = "Name";
    private static final String PROCEDURE = "Procedure";
    private static final String NUMBER_OF_ARGUMENTS = "NumberOfArguments";
    private static final String TURTLE_IMAGE = "TurtleImage";
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

    public void generateFile(String backgroundColor, String penColor, String turtleImage, File file) {
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
