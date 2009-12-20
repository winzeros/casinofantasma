/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.laberintos;

import aima.search.map.ExtendableMap;

/**
 *
 * @author Alicia
 */
public class LaberintoSalas2 extends ExtendableMap {

	public LaberintoSalas2() {
		initMap(this);
	}

	// The different locations in the simplified map of part of Romania
	public static final String ENTRADA = "ENTRADA";
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
	public static final String SALIDA1 = "SALIDA1";
	public static final String SALIDA2 = "SALIDA2";
	public static final String SALIDA3 = "SALIDA3";

	/**
	 * Initializes a map with a simplified road map of Romania.
	 */
	public static void initMap(ExtendableMap map) {
		// mapOfRomania
		map.clear();
		map.addBidirectionalLink(ENTRADA, SALA1, 71.0);
		map.addBidirectionalLink(ENTRADA, SALA7, 151.0);
		map.addBidirectionalLink(SALA1, SALA2, 75.0);
		map.addBidirectionalLink(SALA2, SALA3, 118.0);
		map.addBidirectionalLink(SALA2, SALA7, 140.0);
		map.addBidirectionalLink(SALA3, SALA4, 111.0);
		map.addBidirectionalLink(SALA4, SALA5, 70.0);
		map.addBidirectionalLink(SALA5, SALA6, 75.0);
		map.addBidirectionalLink(SALA6, SALA9, 120.0);
		map.addBidirectionalLink(SALA7, SALA10, 99.0);
		map.addBidirectionalLink(SALA7, SALA8, 80.0);
		map.addBidirectionalLink(SALA8, SALA11, 97.0);
		map.addBidirectionalLink(SALA8, SALA9, 146.0);
		map.addBidirectionalLink(SALA9, SALA11, 138.0);
		map.addBidirectionalLink(SALA10, SALA13, 211.0);
		map.addBidirectionalLink(SALA11, SALA13, 101.0);
		map.addBidirectionalLink(SALA12, SALA13, 90.0);
		map.addBidirectionalLink(SALA13, SALA15, 85.0);
		map.addBidirectionalLink(SALA14, SALA16, 87.0);
		map.addBidirectionalLink(SALA15, SALIDA1, 142.0);
		map.addBidirectionalLink(SALA15, SALIDA2, 98.0);
		map.addBidirectionalLink(SALA16, SALIDA1, 92.0);
		// addBidirectionalLink(SALIDA1 - already all linked
		map.addBidirectionalLink(SALIDA2, SALIDA3, 86.0);
		// addBidirectionalLink(SALIDA3 - already all linked

		// distances and directions
		// reference location: Bucharest
		map.setDistAndDirToRefLocation(SALA2, 366, 117);
		map.setDistAndDirToRefLocation(SALA13, 0, 360);
		map.setDistAndDirToRefLocation(SALA9, 160, 74);
		map.setDistAndDirToRefLocation(SALA6, 242, 82);
		map.setDistAndDirToRefLocation(SALIDA3, 161, 282);
		map.setDistAndDirToRefLocation(SALA10, 176, 142);
		map.setDistAndDirToRefLocation(SALA12, 77, 25);
		map.setDistAndDirToRefLocation(SALIDA2, 151, 260);
		map.setDistAndDirToRefLocation(SALA16, 226, 202);
		map.setDistAndDirToRefLocation(SALA4, 244, 102);
		map.setDistAndDirToRefLocation(SALA5, 241, 92);
		map.setDistAndDirToRefLocation(SALA14, 234, 181);
		map.setDistAndDirToRefLocation(ENTRADA, 380, 131);
		map.setDistAndDirToRefLocation(SALA11, 100, 116);
		map.setDistAndDirToRefLocation(SALA8, 193, 115);
		map.setDistAndDirToRefLocation(SALA7, 253, 123);
		map.setDistAndDirToRefLocation(SALA3, 329, 105);
		map.setDistAndDirToRefLocation(SALA15, 80, 247);
		map.setDistAndDirToRefLocation(SALIDA1, 199, 222);
		map.setDistAndDirToRefLocation(SALA1, 374, 125);
	}
}


