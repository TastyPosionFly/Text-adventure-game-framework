package GameSpringFramework.reader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class AOPReader {
    private static List<String> beforeMethod = new ArrayList<>();
    private static List<String> afterMethod = new ArrayList<>();

    public static final void AOPXMLReader(){
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("src/GameSpringFramework/config/aopConfig.xml");
            Element root = document.getDocumentElement();
            NodeList beforeMethodNodes = root.getElementsByTagName("beforeMethod");
            for (int i=0; i<beforeMethodNodes.getLength(); i++){
                Element element = (Element) beforeMethodNodes.item(i);
                String methodName = element.getTextContent();
                beforeMethod.add(methodName);
            }
            NodeList afterMethodNodes = root.getElementsByTagName("afterMethod");
            for (int i=0; i<afterMethodNodes.getLength(); i++){
                Element element = (Element) afterMethodNodes.item(i);
                String methodName = element.getTextContent();
                afterMethod.add(methodName);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> getBeforeMethod() {
        return beforeMethod;
    }
    public static List<String> getAfterMethod() {
        return afterMethod;
    }
}
