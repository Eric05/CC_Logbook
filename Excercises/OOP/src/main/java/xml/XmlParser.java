package xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class XmlParser {

    private InputStream fileIS = null;
    private Object document = null;
    private XPath xPath = null;

    public XmlParser(InputStream fileIS) {
        this.fileIS = fileIS;
        document = createDocumentFromInputStream();
        xPath = XPathFactory.newInstance().newXPath();
    }

    public XmlParser() {

    }

    public boolean isValidNode(String expression) {
        boolean isValid;

        try {
            isValid = (boolean) xPath.compile(expression).evaluate(document, XPathConstants.BOOLEAN);
        } catch (XPathExpressionException e) {
            return false;
        }
        return isValid;
    }

    public Node getNodeByXpath(String expression) {
        Node node = null;

        try {
            node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return node;
    }

    public NodeList getListOfElementsByXpath(String expression) {
        NodeList nodelist = null;

        try {
            nodelist = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return nodelist;
    }

    public Document createDocumentFromInputStream(InputStream fileIS) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document xmlDocument = null;

        try {
            builder = builderFactory.newDocumentBuilder();
            xmlDocument = builder.parse(fileIS);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return xmlDocument;
    }

    private Document createDocumentFromInputStream() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document xmlDocument = null;

        try {
            builder = builderFactory.newDocumentBuilder();
            xmlDocument = builder.parse(fileIS);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return xmlDocument;
    }

    public String convertNodeToString(Node node) {
        StringWriter sw = new StringWriter();
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            t.transform(new DOMSource(node), new StreamResult(sw));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    //https://frontbackend.com/java/how-to-convert-xml-node-object-to-string-in-java
    public String getXMLString(Node node, boolean withoutNamespaces, StringBuffer buff, boolean endTag) {
        buff.append("<").append(namespace(node.getNodeName(), withoutNamespaces));

        if (node.hasAttributes()) {
            buff.append(" ");

            NamedNodeMap attr = node.getAttributes();
            int attrLenth = attr.getLength();
            for (int i = 0; i < attrLenth; i++) {
                Node attrItem = attr.item(i);
                String name = namespace(attrItem.getNodeName(), withoutNamespaces);
                String value = attrItem.getNodeValue();

                buff.append(name)
                        .append("=")
                        .append("\"")
                        .append(value)
                        .append("\"");

                if (i < attrLenth - 1) {
                    buff.append(" ");
                }
            }
        }

        if (node.hasChildNodes()) {
            buff.append(">");

            NodeList children = node.getChildNodes();
            int childrenCount = children.getLength();

            if (childrenCount == 1) {
                Node item = children.item(0);
                int itemType = item.getNodeType();
                if (itemType == Node.TEXT_NODE) {
                    if (item.getNodeValue() == null) {
                        buff.append("/>");
                    } else {
                        buff.append(item.getNodeValue());
                        buff.append("</")
                                .append(namespace(node.getNodeName(), withoutNamespaces))
                                .append(">");
                    }
                    endTag = false;
                }
            }
            for (int i = 0; i < childrenCount; i++) {
                Node item = children.item(i);
                int itemType = item.getNodeType();
                if (itemType == Node.DOCUMENT_NODE || itemType == Node.ELEMENT_NODE) {
                    getXMLString(item, withoutNamespaces, buff, endTag);
                }
            }
        } else {
            if (node.getNodeValue() == null) {
                buff.append("/>");
            } else {
                buff.append(node.getNodeValue());
                buff.append("</")
                        .append(namespace(node.getNodeName(), withoutNamespaces))
                        .append(">");
            }
            endTag = false;
        }
        if (endTag) {
            buff.append("</")
                    .append(namespace(node.getNodeName(), withoutNamespaces))
                    .append(">");
        }
        return buff.toString();
    }

    private static String namespace(String str, boolean withoutNamespace) {
        if (withoutNamespace && str.contains(":")) {
            return str.substring(str.indexOf(":") + 1);
        }
        return str;
    }
}
