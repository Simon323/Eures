import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

public class Data {

    public ArrayList<ArrayList<Vertex>> getVertexList(){

        ArrayList<Vertex> list;
        ArrayList<ArrayList<Vertex>> vertexArrayList = new ArrayList<ArrayList<Vertex>>();

        try {

            File fXmlFile = new File("Data/kroA100.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("vertex");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                list = new ArrayList<Vertex>();

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    for(int i = 0; i < 99; i++){
                        int idVertex = Integer.parseInt(eElement.getElementsByTagName("edge").item(i).getTextContent());
                        Double edgeLength = Math.floor((Double.parseDouble(eElement.getElementsByTagName("edge").item(i).getAttributes().getNamedItem("cost").getNodeValue()) + 0.5));
                        list.add(new Vertex(idVertex, edgeLength.intValue()));
                    }

                vertexArrayList.add(list);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vertexArrayList;
    }
}
