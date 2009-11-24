/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.games.wolfssheeps;

import aima.search.framework.*;
import aima.search.uninformed.DepthLimitedSearch;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Alicia
 */
public class WolfsSheepsDemo {

    public static void main(String[] args) {
        wolfsSheepsDemo();
    }

    private static void wolfsSheepsDemo() {
        System.out.println("WolfsSheepsDemo -->");
        try {
            Problem problem = new Problem(new WolfsSheepsBoard(),
                    new WolfsSheepsSuccesorFunction(),
                    new WolfsSheepsGoalTest());
            Search search = new DepthLimitedSearch(9);
            SearchAgent agent = new SearchAgent(problem, search);
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static void printInstrumentation(Properties properties) {
        Iterator keys = properties.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            System.out.println(key + " : " + property);
        }

    }

    private static void printActions(List actions) {
        for (int i = 0; i < actions.size(); i++) {
            String action = (String) actions.get(i);
            System.out.println(action);
        }
    }
}
