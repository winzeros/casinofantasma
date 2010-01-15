
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alicia
 */
public class GeneradorXML {

    public static void main(String[] args) {

        Element root = new Element("casino");
        Element item;
        XMLOutputter outputter;

        for (int i = 0; i < 100; i++) {
            item = new Element("sala");
            item.setAttribute("id", String.valueOf(i));
            item.setAttribute("juego", String.valueOf((int) (Math.random() * 12))); //Son 12 juegos
            item.setAttribute("recompensa", String.valueOf((int) (Math.random() * 100))); //Supongo que el máximo de dias a ganar son 100
            root.addContent(item);
        }

        outputter = new XMLOutputter(Format.getPrettyFormat());

        try {
            outputter.output(new Document(root), new FileOutputStream("salas.xml"));
        } catch (Exception e) {
            e.getMessage();
        }

        root = new Element("casino");

        for (int i = 0; i < 100; i++) {
            item = new Element("camino");
            item.setAttribute("origen", String.valueOf((int) (Math.random() * 100))); //Son 100 salas
            item.setAttribute("destino", String.valueOf((int) (Math.random() * 100))); //Son 100 salas
            item.setAttribute("coste", String.valueOf((int) (Math.random() * 100))); //Supongo que el coste máximo son 100 días
            root.addContent(item);
        }

        outputter = new XMLOutputter(Format.getPrettyFormat());

        try {
            outputter.output(new Document(root), new FileOutputStream("recorrido.xml"));
        } catch (Exception e) {
            e.getMessage();
        }


    }
}
