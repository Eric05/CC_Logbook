package xml;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {
    /**
     * xPath Queries
     *
     * //*[contains(text(),'ABC')] -> select all nodes containing 'ABC'
     * //*[text()='ABC'] -> select all nodes with exactly 'ABC'
     * /.. OR /../.. OR /ancestor::{Nodename}[1] -> find parent OR GRANDPARENT OR first ancestor by name
     * // selects all elements @ selects Attribute
     *  //{Nodename}//@*[contains(.,'g')] | //{Nodename}//*[contains(.,'g')] -> selects any Attribute AND node that contains 'g'
     * //abc | //xyz  -> | or operater to select more paths
     *
     */

    public static void main(String[] args) throws FileNotFoundException {
/*        Path basePath = Paths.get(System.getProperty("user.dir"));
        Path path = basePath.resolve("scratch1.xml");*/
        Path scratch = Paths.get("C:\\Users\\DCV\\AppData\\Roaming\\JetBrains\\IdeaIC2020.3\\scratches\\scratch_1.xml");

        InputStream in = new FileInputStream(String.valueOf(scratch));
        //InputSource inputSource = new InputSource(nw InputStreamReader(in));
        var parser = new XmlParser(in);
        var bol = "//*[@*[contains(.,'xyz')]]";
        System.out.println(parser.isValidNode(bol));
var variable = "xyz";
var exp = "//Assig//*[@variable[contains(.,'" + variable + "')]]/ancestor::Assig[1]";
        //var nod = parser.getNodeByTagName("//from");
        var nod = parser.getNodeByXpath(exp);

        var str = parser.getXMLString(nod,true, new StringBuffer(), true);
        System.out.println(str);

        in = new FileInputStream(String.valueOf(scratch));
        parser = new XmlParser(in);
        var list = parser.getListOfElementsByXpath("//Property[@name]");

        for (var l : iterable(list)) {
            System.out.println(l.getAttributes().item(0).getTextContent());
        }


        //var node = (parser.getNodeByTagName("//Assignments"));
        //var str = parser.getXMLString(node,true, new StringBuffer(), true);
        //System.out.println(str);
    }

    private static String normalize(String xmlString) {
        var clean = xmlString.substring(xmlString.indexOf("<?xml"), xmlString.lastIndexOf(">") + 1);
        return clean;
    }

    public static Iterable<Node> iterable(final NodeList nodeList) {
        return () -> new Iterator<Node>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < nodeList.getLength();
            }

            @Override
            public Node next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return nodeList.item(index++);
            }
        };
    }
}


