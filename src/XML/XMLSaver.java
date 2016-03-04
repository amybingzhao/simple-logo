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
import Model.VariableDictionary;
import org.w3c.dom.*;

import java.io.File;


/**
 * Created by blakekaplan on 3/4/16.
 */
public class XMLSaver {

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

    public void generateFile(File file) {
        myDocument = myBuilder.newDocument();
        Element myRoot = myDocument.createElement("SLogo Configuration");
    }

    public void createFile(File file) {
        TransformerFactory myTransformerFactory = TransformerFactory.newInstance();
        Transformer myTransformer;
        try {
            myTransformer = myTransformerFactory.newTransformer();
            myTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
            myTransformer.setOutputProperty(OutputKeys.METHOD, "xml");
            myTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource mySource = new DOMSource(myDocument);
            StreamResult myResult = new StreamResult(file);
            myTransformer.transform(mySource, myResult);
        } catch (Exception e) {
            System.out.println("File Creation Error");
        }
    }

}
