package GameSpringFramework.reader;

import GameSpringFramework.action.Action;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashMap;
import java.util.Map;

public class ActionReader {
    private static final Map<String, Action> actionMap = new HashMap<String, Action>();

    public static void loadConfig(){
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            Document document = builder.parse("src/GameSpringFramework/config/action.xml");
            NodeList nodeList = document.getElementsByTagName("action");
            for (int i=0; i<nodeList.getLength(); i++){
                Element element = (Element) nodeList.item(i);
                String vehicleType = element.getAttribute("type");
                String className = element.getTextContent();
                Class<?> clazz = Class.forName(className);
                Action action = (Action) clazz.getDeclaredConstructor().newInstance();
                actionMap.put(vehicleType,action);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Action getAction(String actionType){
        return actionMap.get(actionType);
    }

    public static Map<String, Action> getActionMap(){
        return actionMap;
    }

}
