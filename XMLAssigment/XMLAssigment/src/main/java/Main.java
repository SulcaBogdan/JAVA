import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            File inputFile = new File("books.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Get all book elements
            NodeList nList = doc.getElementsByTagName("book");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    // Verifica pretul
                    String priceStr = eElement.getElementsByTagName("price").item(0).getTextContent();
                    double price = Double.parseDouble(priceStr);
                    if (price <= 10) {
                        continue;
                    }

                    // Verifica anul
                    String yearStr = eElement.getElementsByTagName("publish_date").item(0).getTextContent();
                    int year = Integer.parseInt(yearStr);
                    if (year <= 2005) {
                        continue;
                    }

                    // Informatiile despre carti
                    System.out.println("--- Book ---");
                    System.out.println("Title: " + eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Author: " + eElement.getElementsByTagName("author").item(0).getTextContent());
                    System.out.println("Publish date: " + yearStr);
                    System.out.println("Price: $" + priceStr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
