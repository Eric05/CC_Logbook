package database;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import xml.XmlParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, XPathExpressionException {
        Connection connect = getConnection();

        PreparedStatement preparedStatement;
        preparedStatement = connect.prepareStatement("select * from ispn_workflow_data limit 100");

        ResultSet rs = preparedStatement.executeQuery();

        var texts = new ArrayList<String>();
        var docs = new ArrayList<Document>();

        while (rs.next()) {
            String xmlString = getStringFromBlob(rs, "data");
            texts.add(xmlString);

            Response response = new Response();
            var d = response.createXmlDocument(rs,"data");
            docs.add(d);
            var x = response.isValidNode(d, "g");
            System.out.println(x);
        }


        var clearStrings = new ArrayList<String>();

        for (String text : texts) {
            if (hasVariable(text)) {
                clearStrings.add(normalize(text));
            }
        }

        var xmls = new ArrayList<Document>();

        for (String clearString : clearStrings) {
            xmls.add(convertStringToXMLDocument(clearString));
        }

        Node nd = null;
        var d = xmls.get(0);
        XPath xPath = XPathFactory.newInstance().newXPath();

        for (Document xml : xmls) {

            String name = null;
            String variable = "gwt.UT_Name";
            Node node = null;
            var evaluation = (boolean) xPath.compile("//from//*[@variable[contains(.,'gwt.UT_Name')]]").evaluate(xml, XPathConstants.BOOLEAN);
            if (evaluation) {
                var exp = "//Assignments//*[@variable[contains(.,'" + variable + "')]]/ancestor::Assignments[1]";
                try {
                    name = xPath.evaluate("/Workflow/WorkflowName", xml);
                    node = (Node) xPath.compile(exp).evaluate(xml, XPathConstants.NODE);
                } catch (XPathExpressionException e) {

                }
                System.out.println(name + " ------------\n" + getXMLString(node, true, new StringBuffer(), true));
            }
        }
        //for (int i = 0; i < xmls.size(); i++) {
var doc = xmls.get(5);


/*            var evaluation = (boolean) xPath.compile("//Assignments//*[@variable[contains(.,'gwt')]]").evaluate(doc, XPathConstants.BOOLEAN);
            if (evaluation) {
                var variab = "g";
                String nam= null;
                Node node = null;
                var exp = "//Assignments//*[@variable[contains(.,'" + variable + "')]]/ancestor::Assignments[1]";
                try {
                    node = (Node) xPath.compile(exp).evaluate(d, XPathConstants.NODE);
                    name = xPath.evaluate("//Workflowname", doc);
                } catch (XPathExpressionException e) {
                    e.printStackTrace();
                }
                System.out.println(" | " + name);
                System.out.println(getXMLString(node, false, new StringBuffer(), true));
            }*/



        String expression = "//Assignments[text()='gwt.alo09.PKT.amount']";
        //String expression = "//Assignments";
        try {
            nd = (Node) xPath.compile(expression).evaluate(d, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        var str = getXMLString(nd, false, new StringBuffer(), true);
        System.out.println(str);
        System.out.println(containsVariable(d, "gwt.alo09.PKT.amount"));
        System.out.println(containsVariable(d, "gw.alo09.PKT.amount"));

        Node rootNode = xmls.get(3).getDocumentElement();

        var res = ((Element) rootNode).getAttribute("version");

        System.out.println(res);

        int counter = 0;
        int counterNeg = 0;
/*        var xmlsToSearch = new ArrayList<Document>();
            if (doc.contains("variable")) {
                counter++;
                Pattern pattern = Pattern.compile("<Assignments>(.*?)</Assignments>", Pattern.DOTALL);
                Matcher matcher = pattern.matcher(doc);

                if (matcher.find()) {
                    xmlsToSearch.add(matcher.group(1));
                }
            } else {
                counterNeg++;
            }*/


        System.out.println(counter + " | " + counterNeg);

        connect.close();

    }

    /***
     * 1. get String from Blob
     * 2. normalize String to xml-Dom compatible
     * 3. create xml-Dom
     * @param rs
     */
    public static Document createXmlDocument(ResultSet rs, String col){
        String raw = null;
        String normalized;
        try {
           raw =  getStringFromBlob(rs,col);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        normalized = normalize(raw);
        Document doc = convertStringToXMLDocument(normalized);
        return doc;
    }

    private static boolean containsVariable(Document doc, String varName) {
        Node nd = null;
        String expression = "//from";
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            nd = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        var attr = nd.getAttributes().getNamedItem("variable").getNodeValue();
        return attr.equals(varName);
    }

    private static boolean hasVariable(String xmlString) {
        return xmlString.contains("variable");
    }

    public static Connection getConnection() throws SQLException {
        Connection connect;

        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/inubit74?"
                            + "user=root&password=password&serverTimezone=UTC"); //&password=my-secret-pw
        } catch (SQLException throwables) {
            throw new SQLException();
        }
        return connect;
    }

    private static String normalize(String xmlString) {
        var clean = xmlString.substring(xmlString.indexOf("<?xml"), xmlString.lastIndexOf(">") + 1);
        return clean;
    }

    private static String getStringFromBlob(ResultSet rs, String col) throws SQLException {
        String xmlString = null;

        try {
            xmlString = IOUtils.toString(rs.getBinaryStream(col), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xmlString;
    }


    private static Document convertStringToXMLDocument(String xmlString) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
              DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            org.w3c.dom.Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String convertNodeToString(Node node) {

        StringWriter sw = new StringWriter();
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            t.transform(new DOMSource(node), new StreamResult(sw));
        } catch (TransformerException te) {
            System.out.println("nodeToString Transformer Exception");
        }
        return sw.toString();
    }

    //https://frontbackend.com/java/how-to-convert-xml-node-object-to-string-in-java
    public static String getXMLString(Node node, boolean withoutNamespaces, StringBuffer buff, boolean endTag) {
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

/*    public static Document createXml(String xmlString){
        SAXReader reader = new SAXReader();

        try {
            return reader.read(xmlString);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}



