/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.casinofantasma;

import aima.gui.applications.search.map.MapAgentModel;
import aima.gui.framework.AgentView;
import aima.search.map.Map;
import aima.search.map.Point2D;
import control.laberintos.LaberintoEnvironment;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Alicia
 */
public class LaberintoAgentView extends AgentView {

    /** Clears the panel and draws the map and the tour history. */
    @Override
    public void paint(java.awt.Graphics g) {
        super.paint(g);
        MapAgentModel maModel = (MapAgentModel) model;
        if (maModel != null && !maModel.isEmpty()) {
            java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
            adjustTransformation();
            paintMap(g2);
            paintTour(g2);
            for (String loc : maModel.getLocations()) {
                paintLoc(g2, loc);
            }
        }
    }

    /**
     * Adjusts offsets and scale so that the whole map fits on the
     * view without scrolling.
     */
    private void adjustTransformation() {
        MapAgentModel maModel = (MapAgentModel) model;
        List<String> locs = maModel.getLocations();
        // adjust coordinates relative to the left upper corner of the graph area
        double minX = Double.POSITIVE_INFINITY;
        double minY = Double.POSITIVE_INFINITY;
        double maxX = Double.NEGATIVE_INFINITY;
        double maxY = Double.NEGATIVE_INFINITY;
        for (String loc : locs) {
            Point2D xy = maModel.getLocCoords(loc);
            if (xy.getX() < minX) {
                minX = xy.getX();
            }
            if (xy.getY() < minY) {
                minY = xy.getY();
            }
            if (xy.getX() > maxX) {
                maxX = xy.getX();
            }
            if (xy.getY() > maxY) {
                maxY = xy.getY();
            }
        }
        this.setBorder(20, 20, 20, 100);
        adjustTransformation(minX, minY, maxX, maxY);
    }

    /**
     * Represents roads by lines and locations by name-labeled points.
     */
    private void paintMap(java.awt.Graphics2D g2) {
        MapAgentModel maModel = (MapAgentModel) model;
        Map envMap = maModel.getEnvMap();
        Map agentMap = maModel.getAgentMap();
        List<Roadblock> roadblocks = new ArrayList<Roadblock>();
        for (String l1 : maModel.getLocations()) {
            Point2D pt1 = maModel.getLocCoords(l1);
            List<String> linkedLocs = envMap.getLocationsLinkedTo(l1);
            for (String l2 : agentMap.getLocationsLinkedTo(l1)) {
                if (!linkedLocs.contains(l2)) {
                    linkedLocs.add(l2);
                }
            }
            for (String l2 : linkedLocs) {
                Point2D pt2 = maModel.getLocCoords(l2);
                g2.setColor(Color.lightGray);
                g2.drawLine(x(pt1), y(pt1), x(pt2), y(pt2));
                boolean blockedInEnv =
                        !envMap.getLocationsLinkedTo(l2).contains(l1);
                boolean blockedInAgent =
                        !agentMap.getLocationsLinkedTo(l2).contains(l1);
                roadblocks.add(new Roadblock(pt1, pt2, blockedInEnv, blockedInAgent));
                if (blockedInEnv && blockedInAgent) {
                    boolean blockedInEnvOtherDir =
                            !envMap.getLocationsLinkedTo(l1).contains(l2);
                    boolean blockedInAgentOtherDir =
                            !agentMap.getLocationsLinkedTo(l1).contains(l2);
                    roadblocks.add(new Roadblock(pt2, pt1, blockedInEnvOtherDir, blockedInAgentOtherDir));
                }
            }
        }
        for (Roadblock block : roadblocks) {
            paintRoadblock(g2, block);
        }
    }

    /** The track of the agent is visualized with red lines. */
    private void paintTour(java.awt.Graphics2D g2) {
        MapAgentModel maModel = (MapAgentModel) model;
        Point2D lastPt = null;
        g2.setColor(Color.red);
        for (String loc : LaberintoEnvironment.historico) {
            Point2D pt = maModel.getLocCoords(loc);
            if (pt != null && lastPt != null) {
                g2.drawLine(x(pt), y(pt), x(lastPt), y(lastPt));
            }
            lastPt = pt;
        }
    }

    /**
     * Roadblocks are represented by filled rectangles.
     * Blue denotes, the agent doesn't know it, red dentotes, there is
     * no roadblock, but the agent thinks so.
     */
    private void paintRoadblock(java.awt.Graphics2D g2, Roadblock block) {
        if (block.inEnvMap || block.inAgentMap) {
            int x = (int) (0.2 * x(block.pos1) + 0.8 * x(block.pos2) - 4);
            int y = (int) (0.2 * y(block.pos1) + 0.8 * y(block.pos2) - 4);
            if (!block.inAgentMap) {
                g2.setColor(Color.blue); // agent doesn't know the roadblock
            } else if (!block.inEnvMap) {
                g2.setColor(Color.red); // agent doesn't know the way
            } else {
                g2.setColor(Color.lightGray);
            }
            g2.fillRect(x, y, 9, 9);
        }
    }

    private void paintLoc(java.awt.Graphics2D g2, String loc) {
        MapAgentModel maModel = (MapAgentModel) model;
        Point2D pt = maModel.getLocCoords(loc);
        if (pt != null) {
            int x = x(pt);
            int y = y(pt);
            String info = "";
            List<String> history = LaberintoEnvironment.historico;
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < history.size(); i++) {
                if (history.get(i).equals(loc)) {
                    list.add(i + 1);
                }
            }
            if (!list.isEmpty()) {
                info = list.toString();
            }
            if (maModel.hasObjects(loc)) {
                g2.setColor(Color.green);
                g2.fillOval(x - 5, y - 5, 10, 10);
                ImageIcon img = new ImageIcon(getClass().getResource("images/sala.gif"));
                g2.drawImage(img.getImage(), x, y, null);
            }
            /*if (!history.isEmpty() && loc.equals(history.get(history.size() - 1))) {
            g2.setColor(Color.red);
            g2.fillOval(x - 4, y - 4, 8, 8);
            }*/
            if (maModel.hasInfos(loc)) {
                g2.setColor(Color.blue);
                //g2.drawString("i", x, y + 12);
                ImageIcon img = new ImageIcon(getClass().getResource("images/sala.gif"));
                g2.drawImage(img.getImage(), x - 15, y - 16, null);
            }
            if (maModel.isStart(loc)) {
                g2.setColor(Color.red);
                //ancho += 10;
                ImageIcon img = new ImageIcon(getClass().getResource("images/llave.gif"));
                g2.drawImage(img.getImage(), x - 15, y - 16, null);
            } else if (maModel.isDestination(loc)) {
                g2.setColor(Color.green);
                //ancho += 10;
                ImageIcon img = new ImageIcon(getClass().getResource("images/dinero.gif"));
                g2.drawImage(img.getImage(), x - 15, y - 16, null);
            } else if (history.contains(loc)) {
                g2.setColor(Color.black);
                ImageIcon img = new ImageIcon(getClass().getResource("images/trebol.gif"));
                g2.drawImage(img.getImage(), x - 15, y - 16, null);
                //ancho += 10;
            } else {
                g2.setColor(Color.lightGray);
                ImageIcon img = new ImageIcon(getClass().getResource("images/sala.gif"));
                g2.drawImage(img.getImage(), x - 15, y - 16, null);
            }
            //g2.fillRect(x - 3, y - 16, ancho, 20);
           // g2.setColor(Color.lightGray);
            //g2.drawString(loc + info, x, y);
        }
    }

    /**
     * Stores roadblock information. Roadblocks are generally printed after
     * the road itself so that they always appear in front.
     */
    private static class Roadblock {

        Point2D pos1;
        Point2D pos2;
        boolean inEnvMap;
        boolean inAgentMap;

        private Roadblock(Point2D pos1, Point2D pos2, boolean inEnvMap, boolean inAgentMap) {
            this.pos1 = pos1;
            this.pos2 = pos2;
            this.inEnvMap = inEnvMap;
            this.inAgentMap = inAgentMap;
        }
    }
}

