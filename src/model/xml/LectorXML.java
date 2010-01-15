/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import model.Vista;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author Alicia
 */
public class LectorXML {

    public ArrayList getSalas(String path) {

        ArrayList salas = new ArrayList();
        HashMap atributos;
        File fichero = new File(path);
        SAXBuilder builder;
        Document doc;
        Element root, e;
        List<Element> listaSalas;

        try {

            if (!fichero.exists()) {
                 Logger.getLogger(LectorXML.class.getName()).log(Level.ERROR, "Error al leer el fichero XML");
            } else {
                builder = new SAXBuilder();
                doc = builder.build(fichero);
                root = doc.getRootElement();
                listaSalas = root.getChildren();

                for (int i = 0; i < listaSalas.size(); i++) {
                    e = listaSalas.get(i);

                    atributos = new HashMap();
                    atributos.put(Vista.ID, e.getAttribute(Vista.ID));
                    atributos.put(Vista.JUEGO, e.getAttribute(Vista.JUEGO));
                    atributos.put(Vista.RECOMPENSA, e.getAttribute(Vista.RECOMPENSA));

                    salas.add(atributos);
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(LectorXML.class.getName()).log(Level.ERROR, "Error al leer el fichero XML", ex);
        }

        return salas;

    }

    public ArrayList getRecorrido(String path) {

        ArrayList recorrido = new ArrayList();
        HashMap atributos;
        File fichero = new File(path);
        SAXBuilder builder;
        Document doc;
        Element root, e;
        Content content;
        List<Element> listaSalas;


        try {

            if (!fichero.exists()) {
                 Logger.getLogger(LectorXML.class.getName()).log(Level.ERROR, "Error al leer el fichero XML");
            } else {
                builder = new SAXBuilder();
                doc = builder.build(fichero);
                root = doc.getRootElement();

                for (int i = 1; i < root.getContentSize(); i += 2) {
                    e = (Element) root.getContent(i);

                    atributos = new HashMap();
                    atributos.put(Vista.ORIGEN, e.getAttribute(Vista.ORIGEN).getValue());
                    atributos.put(Vista.DESTINO, e.getAttribute(Vista.DESTINO).getValue());
                    atributos.put(Vista.APUESTA, e.getAttribute(Vista.APUESTA).getValue());

                    recorrido.add(atributos);
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(LectorXML.class.getName()).log(Level.ERROR, "Error al leer el fichero XML", ex);
        }

        return recorrido;

    }
}
