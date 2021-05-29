package database;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import xml.XmlParser;
import xml.xmlParsable;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Response {
    private xmlParsable parser = new XmlParser();

     public Document createXmlDocument(ResultSet rs, String col){
        String raw = null;
        InputStream normalized;
        try {
            raw =  getStringFromBlob(rs,col);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        normalized = new ByteArrayInputStream(normalize(raw).getBytes());
        var doc = convertStringToXMLDocument(normalized);
        return doc;
    }

    public boolean getMatching(Document doc, String variable){
        var exp = "//Assignments//*[contains(text()," + variable + ")] | //Assignments//@*[contains(.," + variable +")]";
         return parser.isValidNode(exp);
    }

    private Document convertStringToXMLDocument(InputStream fileIS) {
        return parser.createDocumentFromInputStream(fileIS);
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

    private String normalize(String xmlString) {
        var clean = xmlString.substring(xmlString.indexOf("<?xml"), xmlString.lastIndexOf(">") + 1);
        return clean;
    }

    public boolean isValidNode(Document doc, String variable) {
        boolean isValid;
        var xPath = XPathFactory.newInstance().newXPath();

        var exp = "//Assignments//*[contains(text()," + variable + ")] | //Assignments//@*[contains(.," + variable +")]";
        try {
            isValid = (boolean) xPath.compile(exp).evaluate(doc, XPathConstants.BOOLEAN);
        } catch (XPathExpressionException e) {
            return false;
        }
        return isValid;
    }

}
