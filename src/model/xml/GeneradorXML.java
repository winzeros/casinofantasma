package model.xml;


import java.io.FileOutputStream;
import model.Vista;
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

        Element root = new Element(Vista.CASINO);
        Element item;
        XMLOutputter outputter;

        for (int i = 0; i < 100; i++) {
            item = new Element(Vista.SALA);
            item.setAttribute(Vista.ID, String.valueOf(i));
            item.setAttribute(Vista.JUEGO, String.valueOf((int) (Math.random() * 11))); //Son 12 juegos
             item.setAttribute(Vista.ESTRATEGIA, String.valueOf((int) (Math.random() * 13))); //Son 8 estrategias
            item.setAttribute(Vista.RECOMPENSA, String.valueOf((int) (Math.random() * 1000))); //Supongo que el máximo de dias a ganar son 100
            root.addContent(item);
        }

        outputter = new XMLOutputter(Format.getPrettyFormat());

        try {
            outputter.output(new Document(root), new FileOutputStream(Vista.SALAS_XML + ".xml"));
        } catch (Exception e) {
            e.getMessage();
        }

        root = new Element(Vista.CASINO);

        for (int i = 0; i < 300; i++) {
            item = new Element(Vista.CAMINO);
            item.setAttribute(Vista.ORIGEN, String.valueOf((int) (Math.random() * 100))); //Son 100 salas
            item.setAttribute(Vista.DESTINO, String.valueOf((int) (Math.random() * 100))); //Son 100 salas
            item.setAttribute(Vista.APUESTA, String.valueOf((int) (Math.random() * 50))); //Supongo que el coste máximo son 100 días
            root.addContent(item);
        }

        outputter = new XMLOutputter(Format.getPrettyFormat());

        try {
            outputter.output(new Document(root), new FileOutputStream(Vista.RECORRIDO_XML + ".xml"));
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
