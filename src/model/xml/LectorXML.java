/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Vista;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author Alicia
 */
public class LectorXML {

    public static String path = "F:\\Alicia\\PROYECTOS\\CasinoFantasma\\test\\";
    private int escenario;


    public LectorXML(int escenario) {
        this.escenario = escenario;
    }

    public ArrayList getSalas() {

        ArrayList salas;
        HashMap atributos;
        File fichero;
        SAXBuilder builder;
        Document doc;
        Element root, e;
        List<Element> listaSalas;

        try {
            fichero = new File(path + Vista.SALAS_XML + escenario + ".xml");
            salas = new ArrayList();

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

            return salas;

        } catch (Exception ex) {
            Logger.getLogger(LectorXML.class.getName()).log(Level.ERROR, "Error al leer el fichero XML", ex);
            return null;
        }

    }

    public ArrayList getRecorrido() {

        ArrayList recorrido;
        HashMap atributos;
        File fichero;
        SAXBuilder builder;
        Document doc;
        Element root, e;

        try {
            recorrido = new ArrayList();
            fichero = new File(path + Vista.RECORRIDO_XML + escenario + ".xml");

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

            return recorrido;

        } catch (Exception ex) {
            Logger.getLogger(LectorXML.class.getName()).log(Level.ERROR, "Error al leer el fichero XML", ex);
            return null;
        }
    }

    public int getJuego(String nombreSala) {

        File fichero;
        SAXBuilder builder;
        Document doc;
        Element root, e;
        List<Element> listaSalas;
        int numJuego, i;

        try {
            numJuego = -1;
            i = 0;
            fichero = new File(path + Vista.SALAS_XML + escenario + ".xml");

            if (!fichero.exists()) {
                Logger.getLogger(LectorXML.class.getName()).log(Level.ERROR, "Error al leer el fichero XML");
            } else {
                builder = new SAXBuilder();
                doc = builder.build(fichero);
                root = doc.getRootElement();
                listaSalas = root.getChildren();

                while (i < listaSalas.size() && numJuego == -1) {
                    e = listaSalas.get(i);

                    if (("SALA" + e.getAttribute(Vista.ID).getValue().toString()).equals(nombreSala)) {
                        numJuego = Integer.parseInt(e.getAttribute(Vista.JUEGO).getValue().toString());
                    }

                    i++;
                }
            }

            return numJuego;

        } catch (Exception ex) {
            Logger.getLogger(LectorXML.class.getName()).log(Level.ERROR, "Error al leer el fichero XML", ex);
            return -1;
        }
    }

        public int getEstrategia(String nombreSala) {

        File fichero;
        SAXBuilder builder;
        Document doc;
        Element root, e;
        List<Element> listaSalas;
        int numJuego, i;

        try {
            numJuego = -1;
            i = 0;
            fichero = new File(path + Vista.SALAS_XML + escenario + ".xml");

            if (!fichero.exists()) {
                Logger.getLogger(LectorXML.class.getName()).log(Level.ERROR, "Error al leer el fichero XML");
            } else {
                builder = new SAXBuilder();
                doc = builder.build(fichero);
                root = doc.getRootElement();
                listaSalas = root.getChildren();

                while (i < listaSalas.size() && numJuego == -1) {
                    e = listaSalas.get(i);

                    if (("SALA" + e.getAttribute(Vista.ID).getValue().toString()).equals(nombreSala)) {
                        numJuego = Integer.parseInt(e.getAttribute(Vista.ESTRATEGIA).getValue().toString());
                    }

                    i++;
                }
            }

            return numJuego;

        } catch (Exception ex) {
            Logger.getLogger(LectorXML.class.getName()).log(Level.ERROR, "Error al leer el fichero XML", ex);
            return -1;
        }
    }

    public int getRecompensa(String nombreSala) {

        File fichero;
        SAXBuilder builder;
        Document doc;
        Element root, e;
        List<Element> listaSalas;
        int recompensa, i;

        try {
            recompensa = -1;
            i = 0;
            fichero = new File(path + Vista.SALAS_XML + escenario + ".xml");

            if (!fichero.exists()) {
                Logger.getLogger(LectorXML.class.getName()).log(Level.ERROR, "Error al leer el fichero XML");
            } else {
                builder = new SAXBuilder();
                doc = builder.build(fichero);
                root = doc.getRootElement();
                listaSalas = root.getChildren();

                while (i < listaSalas.size() && recompensa == -1) {
                    e = listaSalas.get(i);

                    if (("SALA" + e.getAttribute(Vista.ID).getValue().toString()).equals(nombreSala)) {
                        recompensa = Integer.parseInt(e.getAttribute(Vista.RECOMPENSA).getValue().toString());
                    }

                    i++;
                }
            }

            return recompensa;

        } catch (Exception ex) {
            Logger.getLogger(LectorXML.class.getName()).log(Level.ERROR, "Error al leer el fichero XML", ex);
            return -1;
        }
    }
}
