package xml;

import controller.Controller;
import model.Turtle;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by blakekaplan on 3/4/16.
 */
public class XMLParser {

    public static final String CONFIG = "Config";
    public static final String DELIMITER = "-";
    public static final String MAKE = "make ";
    private DocumentBuilderFactory myFactory;
    private DocumentBuilder myBuilder;

    private Controller myController;

    private String backgroundColor;
    private String penColor;
    private String turtleImage;
    private List<Turtle> myTurtles;

    public XMLParser(Controller controller) {
        myController = controller;
    }

    public void parse(File myFile) throws IOException, ParserConfigurationException, SAXException {
        myFactory = DocumentBuilderFactory.newInstance();
        myBuilder = myFactory.newDocumentBuilder();
        Document myDocument = myBuilder.parse(myFile);
        myDocument.getDocumentElement().normalize();
        NodeList categories = myDocument.getDocumentElement().getChildNodes();
        for (int i = 0; i < categories.getLength(); i++) handleDocumentNode(categories.item(i));
    }

    private void handleDocumentNode(Node entry) {
        if (entry instanceof Element) {
            Element entryElement = (Element) entry;
            switch (entryElement.getNodeName()) {
                case CONFIG:
                    parseConfig(entryElement);
                    break;
                case "Turtles":
                    parseTurtles(entryElement);
                    break;
                case "Variables":
                    parseVariables(entryElement);
                    break;
                case "Commands":
                    parseCommands(entryElement);
                    break;
            }
        }
    }

    private void parseConfig(Element configElement) {
        List<String> configData = extract(configElement);
        backgroundColor = getTextForEntry(configData.get(0));
        penColor = getTextForEntry(configData.get(1));
        turtleImage = getTextForEntry(configData.get(2));
    }

    private void parseTurtles(Element turtleElements) {
        myTurtles = new ArrayList<>();
        NodeList myTurtleNodes = turtleElements.getChildNodes();
        for (int i = 0; i < myTurtleNodes.getLength(); i++) {
            if (myTurtleNodes.item(i) instanceof Element) {
                Element turtleElement = (Element) myTurtleNodes.item(i);
                makeTurtle(extract(turtleElement));
            }
        }
    }

    private void parseVariables(Element variableElement) {
        List<String> variableData = extract(variableElement);
        for (String var : variableData) {
            myController.processCommand(MAKE + getNameForEntry(var) + " " + getTextForEntry(var));
        }
    }

    private void parseCommands(Element commandsElement) {
        NodeList myList = commandsElement.getChildNodes();
        for (int i = 0; i < myList.getLength(); i++) {
            Node myNode = myList.item(i);
            if (myNode instanceof Element){
                Element commandElement = (Element) myNode;
                List<String> data = extract(commandElement);
                myController.processCommand(getTextForEntry(data.get(1)));
            }
        }
    }

    private void makeTurtle(List<String> turtleData) {
        Turtle myTurtle = new Turtle(Double.parseDouble(getTextForEntry(turtleData.get(0))));
        myTurtles.add(myTurtle);
    }

    private List<String> extract(Element data) {
        ArrayList<String> extractedData = new ArrayList<>();
        NodeList dataList = data.getChildNodes();
        for (int i = 0; i < dataList.getLength(); i++) {
            Node dataNode = dataList.item(i);
            if (dataNode instanceof Element) {
                Element dataElement = (Element) dataNode;
                extractedData.add(dataElement.getNodeName() + DELIMITER + dataElement.getTextContent());
            }
        }
        return extractedData;
    }

    private String getTextForEntry(String entry) {
        String[] splitEntry = entry.split(DELIMITER);
        return splitEntry[1];
    }

    private String getNameForEntry(String entry) {
        String[] splitEntry = entry.split(DELIMITER);
        return splitEntry[0];
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getPenColor() {
        return penColor;
    }

    public String getTurtleImage() {
        return turtleImage;
    }

    public List<Turtle> getTurtles() {
        return myTurtles;
    }

}