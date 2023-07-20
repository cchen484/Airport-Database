package Parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlDomParser {
    private static final Logger loggerDOM = LogManager.getLogger(XmlDomParser.class);

    public static void parseXml(String xmlFileName, String tagName) {
        File customersXml = new File(xmlFileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(customersXml);

            document.getDocumentElement().normalize();

            //Get list of nodes with tagName
            NodeList nodes = document.getElementsByTagName(tagName);
            for(int i = 0; i<nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    NodeList nodeAttr = element.getChildNodes();
                    for(int j = 0; j<nodeAttr.getLength(); j++) {
                        Node attr = nodeAttr.item(j);
                        if(attr.getNodeType() == Node.ELEMENT_NODE) {
                            Element attrElm = (Element) attr;
                            loggerDOM.info(attrElm.getTagName() + ": " + attrElm.getAttribute("value"));
                        }

                    }
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            loggerDOM.error("Error parsing XML document");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parseXml("customers.xml", "customers");
    }

}
