/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.laberintos;

import aima.search.map.ExtendableMap;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import model.Vista;
import model.xml.LectorXML;

/**
 *
 * @author Alicia
 */
public class LaberintoSalas extends ExtendableMap {


    public static LectorXML lectorXML;

    public LaberintoSalas(int escenario) {
        initMap(this, escenario);
    }

    public static final String SALA0 = "SALA0";
    public static final String SALA1 = "SALA1";
    public static final String SALA2 = "SALA2";
    public static final String SALA3 = "SALA3";
    public static final String SALA4 = "SALA4";
    public static final String SALA5 = "SALA5";
    public static final String SALA6 = "SALA6";
    public static final String SALA7 = "SALA7";
    public static final String SALA8 = "SALA8";
    public static final String SALA9 = "SALA9";
    public static final String SALA10 = "SALA10";
    public static final String SALA11 = "SALA11";
    public static final String SALA12 = "SALA12";
    public static final String SALA13 = "SALA13";
    public static final String SALA14 = "SALA14";
    public static final String SALA15 = "SALA15";
    public static final String SALA16 = "SALA16";
    public static final String SALA17 = "SALA17";
    public static final String SALA18 = "SALA18";
    public static final String SALA19 = "SALA19";
    public static final String SALA20 = "SALA20";
    public static final String SALA21 = "SALA21";
    public static final String SALA22 = "SALA22";
    public static final String SALA23 = "SALA23";
    public static final String SALA24 = "SALA24";
    public static final String SALA25 = "SALA25";
    public static final String SALA26 = "SALA26";
    public static final String SALA27 = "SALA27";
    public static final String SALA28 = "SALA28";
    public static final String SALA29 = "SALA29";
    public static final String SALA30 = "SALA30";
    public static final String SALA31 = "SALA31";
    public static final String SALA32 = "SALA32";
    public static final String SALA33 = "SALA33";
    public static final String SALA34 = "SALA34";
    public static final String SALA35 = "SALA35";
    public static final String SALA36 = "SALA36";
    public static final String SALA37 = "SALA37";
    public static final String SALA38 = "SALA38";
    public static final String SALA39 = "SALA39";
    public static final String SALA40 = "SALA40";
    public static final String SALA41 = "SALA41";
    public static final String SALA42 = "SALA42";
    public static final String SALA43 = "SALA43";
    public static final String SALA44 = "SALA44";
    public static final String SALA45 = "SALA45";
    public static final String SALA46 = "SALA46";
    public static final String SALA47 = "SALA47";
    public static final String SALA48 = "SALA48";
    public static final String SALA49 = "SALA49";
    public static final String SALA50 = "SALA50";
    public static final String SALA51 = "SALA51";
    public static final String SALA52 = "SALA52";
    public static final String SALA53 = "SALA53";
    public static final String SALA54 = "SALA54";
    public static final String SALA55 = "SALA55";
    public static final String SALA56 = "SALA56";
    public static final String SALA57 = "SALA57";
    public static final String SALA58 = "SALA58";
    public static final String SALA59 = "SALA59";
    public static final String SALA60 = "SALA60";
    public static final String SALA61 = "SALA61";
    public static final String SALA62 = "SALA62";
    public static final String SALA63 = "SALA63";
    public static final String SALA64 = "SALA64";
    public static final String SALA65 = "SALA65";
    public static final String SALA66 = "SALA66";
    public static final String SALA67 = "SALA67";
    public static final String SALA68 = "SALA68";
    public static final String SALA69 = "SALA69";
    public static final String SALA70 = "SALA70";
    public static final String SALA71 = "SALA71";
    public static final String SALA72 = "SALA72";
    public static final String SALA73 = "SALA73";
    public static final String SALA74 = "SALA74";
    public static final String SALA75 = "SALA75";
    public static final String SALA76 = "SALA76";
    public static final String SALA77 = "SALA77";
    public static final String SALA78 = "SALA78";
    public static final String SALA79 = "SALA79";
    public static final String SALA80 = "SALA80";
    public static final String SALA81 = "SALA81";
    public static final String SALA82 = "SALA82";
    public static final String SALA83 = "SALA83";
    public static final String SALA84 = "SALA84";
    public static final String SALA85 = "SALA85";
    public static final String SALA86 = "SALA86";
    public static final String SALA87 = "SALA87";
    public static final String SALA88 = "SALA88";
    public static final String SALA89 = "SALA89";
    public static final String SALA90 = "SALA90";
    public static final String SALA91 = "SALA91";
    public static final String SALA92 = "SALA92";
    public static final String SALA93 = "SALA93";
    public static final String SALA94 = "SALA94";
    public static final String SALA95 = "SALA95";
    public static final String SALA96 = "SALA96";
    public static final String SALA97 = "SALA97";
    public static final String SALA98 = "SALA98";
    public static final String SALA99 = "SALA99";

    /**
     * Initializes a map with a simplified road map of Romania.
     */
    public static void initMap(ExtendableMap map, int escenario) {
        // mapOfRomania
        lectorXML = new LectorXML(escenario);
        ArrayList recorridos = lectorXML.getRecorrido();
        HashMap elemento;

        map.clear();
        
        setDistAndDirToRefLocation(map);

        for (int i = 0; i < recorridos.size(); i++) {
            elemento = (HashMap) recorridos.get(i);
            map.addBidirectionalLink("SALA" + elemento.get(Vista.ORIGEN).toString(),
                                    "SALA" + elemento.get(Vista.DESTINO).toString(),
                                    Double.parseDouble(elemento.get(Vista.APUESTA).toString()));
        }

    }

    public static void setDistAndDirToRefLocation(ExtendableMap map) {

        // distances and directions
        map.setDistAndDirToRefLocation(SALA0, 0, 0);
        map.setDistAndDirToRefLocation(SALA2, 50, 200);
        map.setDistAndDirToRefLocation(SALA3, 50, 300);
        map.setDistAndDirToRefLocation(SALA4, 50, 400);
        map.setDistAndDirToRefLocation(SALA5, 50, 500);
        map.setDistAndDirToRefLocation(SALA6, 100, 150);
        map.setDistAndDirToRefLocation(SALA7, 100, 250);
        map.setDistAndDirToRefLocation(SALA8, 100, 350);
        map.setDistAndDirToRefLocation(SALA9, 100, 450);
        map.setDistAndDirToRefLocation(SALA10, 100, 550);
        map.setDistAndDirToRefLocation(SALA11, 150, 100);
        map.setDistAndDirToRefLocation(SALA12, 150, 200);
        map.setDistAndDirToRefLocation(SALA13, 150, 300);
        map.setDistAndDirToRefLocation(SALA14, 150, 400);
        map.setDistAndDirToRefLocation(SALA15, 150, 500);
        map.setDistAndDirToRefLocation(SALA16, 200, 150);
        map.setDistAndDirToRefLocation(SALA17, 200, 250);
        map.setDistAndDirToRefLocation(SALA18, 200, 350);
        map.setDistAndDirToRefLocation(SALA19, 200, 450);
        map.setDistAndDirToRefLocation(SALA20, 200, 550);
        map.setDistAndDirToRefLocation(SALA21, 200, 650);
        map.setDistAndDirToRefLocation(SALA22, 250, 100);
        map.setDistAndDirToRefLocation(SALA23, 250, 200);
        map.setDistAndDirToRefLocation(SALA24, 250, 300);
        map.setDistAndDirToRefLocation(SALA25, 250, 400);
        map.setDistAndDirToRefLocation(SALA26, 250, 500);
        map.setDistAndDirToRefLocation(SALA27, 250, 600);
        map.setDistAndDirToRefLocation(SALA28, 250, 700);
        map.setDistAndDirToRefLocation(SALA29, 300, 150);
        map.setDistAndDirToRefLocation(SALA30, 300, 250);
        map.setDistAndDirToRefLocation(SALA31, 300, 350);
        map.setDistAndDirToRefLocation(SALA32, 300, 450);
        map.setDistAndDirToRefLocation(SALA33, 300, 550);
        map.setDistAndDirToRefLocation(SALA34, 300, 650);
        map.setDistAndDirToRefLocation(SALA35, 300, 750);
        map.setDistAndDirToRefLocation(SALA36, 300, 850);
        map.setDistAndDirToRefLocation(SALA37, 350, 100);
        map.setDistAndDirToRefLocation(SALA38, 350, 200);
        map.setDistAndDirToRefLocation(SALA39, 350, 300);
        map.setDistAndDirToRefLocation(SALA40, 350, 400);
        map.setDistAndDirToRefLocation(SALA41, 350, 500);
        map.setDistAndDirToRefLocation(SALA42, 350, 600);
        map.setDistAndDirToRefLocation(SALA43, 350, 700);
        map.setDistAndDirToRefLocation(SALA44, 350, 800);
        map.setDistAndDirToRefLocation(SALA45, 350, 900);
        map.setDistAndDirToRefLocation(SALA46, 400, 150);
        map.setDistAndDirToRefLocation(SALA47, 400, 250);
        map.setDistAndDirToRefLocation(SALA48, 400, 350);
        map.setDistAndDirToRefLocation(SALA49, 400, 450);
        map.setDistAndDirToRefLocation(SALA50, 400, 550);
        map.setDistAndDirToRefLocation(SALA51, 400, 650);
        map.setDistAndDirToRefLocation(SALA52, 400, 750);
        map.setDistAndDirToRefLocation(SALA53, 400, 850);
        map.setDistAndDirToRefLocation(SALA54, 400, 950);
        map.setDistAndDirToRefLocation(SALA55, 400, 1050);
        map.setDistAndDirToRefLocation(SALA56, 450, 100);
        map.setDistAndDirToRefLocation(SALA57, 450, 200);
        map.setDistAndDirToRefLocation(SALA58, 450, 300);
        map.setDistAndDirToRefLocation(SALA59, 450, 400);
        map.setDistAndDirToRefLocation(SALA60, 450, 500);
        map.setDistAndDirToRefLocation(SALA61, 450, 600);
        map.setDistAndDirToRefLocation(SALA62, 450, 700);
        map.setDistAndDirToRefLocation(SALA63, 450, 800);
        map.setDistAndDirToRefLocation(SALA64, 450, 900);
        map.setDistAndDirToRefLocation(SALA65, 450, 1000);
        map.setDistAndDirToRefLocation(SALA66, 450, 1100);
        map.setDistAndDirToRefLocation(SALA67, 500, 150);
        map.setDistAndDirToRefLocation(SALA68, 500, 250);
        map.setDistAndDirToRefLocation(SALA69, 500, 350);
        map.setDistAndDirToRefLocation(SALA70, 500, 450);
        map.setDistAndDirToRefLocation(SALA71, 500, 550);
        map.setDistAndDirToRefLocation(SALA72, 500, 650);
        map.setDistAndDirToRefLocation(SALA73, 500, 750);
        map.setDistAndDirToRefLocation(SALA74, 500, 850);
        map.setDistAndDirToRefLocation(SALA75, 500, 950);
        map.setDistAndDirToRefLocation(SALA76, 500, 1050);
        map.setDistAndDirToRefLocation(SALA77, 500, 1150);
        map.setDistAndDirToRefLocation(SALA78, 500, 1250);
        map.setDistAndDirToRefLocation(SALA79, 500, 1350);
        map.setDistAndDirToRefLocation(SALA80, 550, 100);
        map.setDistAndDirToRefLocation(SALA81, 550, 200);
        map.setDistAndDirToRefLocation(SALA82, 550, 300);
        map.setDistAndDirToRefLocation(SALA83, 550, 400);
        map.setDistAndDirToRefLocation(SALA84, 550, 500);
        map.setDistAndDirToRefLocation(SALA85, 550, 600);
        map.setDistAndDirToRefLocation(SALA86, 550, 700);
        map.setDistAndDirToRefLocation(SALA87, 550, 800);
        map.setDistAndDirToRefLocation(SALA88, 550, 900);
        map.setDistAndDirToRefLocation(SALA89, 550, 1000);
        map.setDistAndDirToRefLocation(SALA90, 550, 1100);
        map.setDistAndDirToRefLocation(SALA91, 550, 1200);
        map.setDistAndDirToRefLocation(SALA92, 550, 1300);
        map.setDistAndDirToRefLocation(SALA93, 550, 1400);
        map.setDistAndDirToRefLocation(SALA94, 550, 1500);
        map.setDistAndDirToRefLocation(SALA95, 550, 1600);
        map.setDistAndDirToRefLocation(SALA96, 550, 1700);
        map.setDistAndDirToRefLocation(SALA97, 550, 1800);
        map.setDistAndDirToRefLocation(SALA98, 600, 150);
        map.setDistAndDirToRefLocation(SALA99, 600, 550);
        map.setDistAndDirToRefLocation(SALA1, 600, 1050);

    }

    public static String[] getLaberintos() {

        String[] laberintos = null;
        String[] ficheros;
        File ruta;
        int numLab;

        try {
            ruta = new File("F:\\Alicia\\PROYECTOS\\CasinoFantasma\\test");
            numLab = 0;

            if (ruta.isDirectory()) {

                ficheros = ruta.list();
                laberintos = new String[ficheros.length / 2];

                for (int i = 0; i < ficheros.length; i++) {
                    
                    if (ficheros[i].contains(Vista.SALAS_XML)) {
                        laberintos[numLab] = "Laberinto " + (numLab + 1);
                        numLab ++;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return laberintos;

    }
}

