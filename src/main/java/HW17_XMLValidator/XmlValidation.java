package HW17_XMLValidator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XmlValidation {
    public static boolean isValid(String path) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = db.parse(path);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            return false;
        }
        return true;
    }
}
