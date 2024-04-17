package GameSpringFramework.reader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ItemXMLReader {
    private static final Map<String, Map<String, Integer>> itemMap = new HashMap<String, Map<String, Integer>>();
    public static void loadItemXML() {
        try {
            File xmlFile = new File("src/GameSpringFramework/config/items.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            Element root = document.getDocumentElement();
            NodeList itemNodes = root.getChildNodes();

            for (int i = 0; i < itemNodes.getLength(); i++) {
                if (itemNodes.item(i) instanceof Element) {
                    Element itemElement = (Element) itemNodes.item(i);
                    String itemType = itemElement.getTagName();

                    NodeList items = itemElement.getChildNodes();
                    for (int j = 0; j < items.getLength(); j++) {
                        if (items.item(j) instanceof Element) {
                            Element item = (Element) items.item(j);
                            String itemName = item.getElementsByTagName("name").item(0).getTextContent();
                            int attributeValue = Integer.parseInt(item.getElementsByTagName("attributeValues").item(0).getTextContent());

                            if (!itemMap.containsKey(itemType)) {
                                itemMap.put(itemType, new HashMap<>());
                            }

                            itemMap.get(itemType).put(itemName, attributeValue);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Map<String, Integer>> getItemMap() {
        return itemMap;
    }

}
