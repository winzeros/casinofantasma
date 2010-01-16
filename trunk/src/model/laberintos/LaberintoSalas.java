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
        map.setDistAndDirToRefLocation(SALA0, 10000, 200);
        map.setDistAndDirToRefLocation(SALA2, 10000, 210);
        map.setDistAndDirToRefLocation(SALA3, 10000, 220);
        map.setDistAndDirToRefLocation(SALA4, 10000, 230);
        map.setDistAndDirToRefLocation(SALA5, 10000, 240);
        map.setDistAndDirToRefLocation(SALA6, 10000, 250);
        map.setDistAndDirToRefLocation(SALA7, 10000, 260);
        map.setDistAndDirToRefLocation(SALA8, 10000, 270);
        map.setDistAndDirToRefLocation(SALA9, 10000, 280);
        map.setDistAndDirToRefLocation(SALA10, 10000, 290);
        map.setDistAndDirToRefLocation(SALA11, 10000, 300);
        map.setDistAndDirToRefLocation(SALA12, 10000, 310);
        map.setDistAndDirToRefLocation(SALA13, 10000, 320);
        map.setDistAndDirToRefLocation(SALA14, 10000, 330);
        map.setDistAndDirToRefLocation(SALA15, 10000, 340);
        map.setDistAndDirToRefLocation(SALA16, 10000, 350);
        map.setDistAndDirToRefLocation(SALA17, 10000, 360);
        map.setDistAndDirToRefLocation(SALA18, 10000, 370);
        map.setDistAndDirToRefLocation(SALA19, 10000, 380);
        map.setDistAndDirToRefLocation(SALA20, 10000, 390);
        map.setDistAndDirToRefLocation(SALA21, 10000, 400);
        map.setDistAndDirToRefLocation(SALA22, 10000, 410);
        map.setDistAndDirToRefLocation(SALA23, 10000, 420);
        map.setDistAndDirToRefLocation(SALA24, 10000, 430);
        map.setDistAndDirToRefLocation(SALA25, 10000, 440);
        map.setDistAndDirToRefLocation(SALA26, 10000, 450);
        map.setDistAndDirToRefLocation(SALA27, 10000, 460);
        map.setDistAndDirToRefLocation(SALA28, 10000, 470);
        map.setDistAndDirToRefLocation(SALA29, 10000, 480);
        map.setDistAndDirToRefLocation(SALA30, 10000, 490);
        map.setDistAndDirToRefLocation(SALA31, 10000, 500);
        map.setDistAndDirToRefLocation(SALA32, 10000, 510);
        map.setDistAndDirToRefLocation(SALA33, 10000, 520);
        map.setDistAndDirToRefLocation(SALA34, 10000, 530);
        map.setDistAndDirToRefLocation(SALA35, 10000, 540);
        map.setDistAndDirToRefLocation(SALA36, 10000, 550);
        map.setDistAndDirToRefLocation(SALA37, 8000, 185);
        map.setDistAndDirToRefLocation(SALA38, 8000, 200);
        map.setDistAndDirToRefLocation(SALA39, 8000, 215);
        map.setDistAndDirToRefLocation(SALA40, 8000, 230);
        map.setDistAndDirToRefLocation(SALA41, 8000, 245);
        map.setDistAndDirToRefLocation(SALA42, 8000, 260);
        map.setDistAndDirToRefLocation(SALA43, 8000, 275);
        map.setDistAndDirToRefLocation(SALA44, 8000, 290);
        map.setDistAndDirToRefLocation(SALA45, 8000, 305);
        map.setDistAndDirToRefLocation(SALA46, 8000, 320);
        map.setDistAndDirToRefLocation(SALA47, 8000, 335);
        map.setDistAndDirToRefLocation(SALA48, 8000, 350);
        map.setDistAndDirToRefLocation(SALA49, 8000, 365);
        map.setDistAndDirToRefLocation(SALA50, 8000, 380);
        map.setDistAndDirToRefLocation(SALA51, 8000, 395);
        map.setDistAndDirToRefLocation(SALA52, 8000, 410);
        map.setDistAndDirToRefLocation(SALA53, 8000, 425);
        map.setDistAndDirToRefLocation(SALA54, 8000, 440);
        map.setDistAndDirToRefLocation(SALA55, 8000, 455);
        map.setDistAndDirToRefLocation(SALA56, 8000, 470);
        map.setDistAndDirToRefLocation(SALA57, 8000, 485);
        map.setDistAndDirToRefLocation(SALA58, 8000, 500);
        map.setDistAndDirToRefLocation(SALA59, 8000, 515);
        map.setDistAndDirToRefLocation(SALA60, 8000, 530);
        map.setDistAndDirToRefLocation(SALA61, 6000, 200);
        map.setDistAndDirToRefLocation(SALA62, 6000, 220);
        map.setDistAndDirToRefLocation(SALA63, 6000, 240);
        map.setDistAndDirToRefLocation(SALA64, 6000, 260);
        map.setDistAndDirToRefLocation(SALA65, 6000, 280);
        map.setDistAndDirToRefLocation(SALA66, 6000, 300);
        map.setDistAndDirToRefLocation(SALA67, 6000, 320);
        map.setDistAndDirToRefLocation(SALA68, 6000, 340);
        map.setDistAndDirToRefLocation(SALA69, 6000, 360);
        map.setDistAndDirToRefLocation(SALA70, 6000, 380);
        map.setDistAndDirToRefLocation(SALA71, 6000, 400);
        map.setDistAndDirToRefLocation(SALA72, 6000, 420);
        map.setDistAndDirToRefLocation(SALA73, 6000, 440);
        map.setDistAndDirToRefLocation(SALA74, 6000, 460);
        map.setDistAndDirToRefLocation(SALA75, 6000, 480);
        map.setDistAndDirToRefLocation(SALA76, 6000, 500);
        map.setDistAndDirToRefLocation(SALA77, 6000, 520);
        map.setDistAndDirToRefLocation(SALA78, 6000, 540);
        map.setDistAndDirToRefLocation(SALA79, 4000, 200);
        map.setDistAndDirToRefLocation(SALA80, 4000, 225);
        map.setDistAndDirToRefLocation(SALA81, 4000, 250);
        map.setDistAndDirToRefLocation(SALA82, 4000, 275);
        map.setDistAndDirToRefLocation(SALA83, 4000, 300);
        map.setDistAndDirToRefLocation(SALA84, 4000, 325);
        map.setDistAndDirToRefLocation(SALA85, 4000, 350);
        map.setDistAndDirToRefLocation(SALA86, 4000, 375);
        map.setDistAndDirToRefLocation(SALA87, 4000, 400);
        map.setDistAndDirToRefLocation(SALA88, 4000, 425);
        map.setDistAndDirToRefLocation(SALA89, 4000, 450);
        map.setDistAndDirToRefLocation(SALA90, 4000, 475);
        map.setDistAndDirToRefLocation(SALA91, 4000, 500);
        map.setDistAndDirToRefLocation(SALA92, 4000, 530);
        map.setDistAndDirToRefLocation(SALA93, 2000, 200);
        map.setDistAndDirToRefLocation(SALA94, 2000, 245);
        map.setDistAndDirToRefLocation(SALA95, 2000, 290);
        map.setDistAndDirToRefLocation(SALA96, 2000, 335);
        map.setDistAndDirToRefLocation(SALA97, 2000, 380);
        map.setDistAndDirToRefLocation(SALA98, 2000, 425);
        map.setDistAndDirToRefLocation(SALA99, 2000, 470);
        map.setDistAndDirToRefLocation(SALA1, 2000, 515);

    }

    public static String[] getLaberintos() {

        String[] laberintos = null;
        String[] ficheros;
        File ruta;
        int numLab;

        try {
            ruta = new File("C:\\IngInformatica\\IAIC\\practica\\casinofantasma\\test");
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

