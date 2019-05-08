/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayrouteproject;

import Models.Edge;
import Models.Routes;
import Models.Town;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adeel
 */
public class RailwayRouteProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Routes graph = new Routes();

        Town a = new Town("A");
        Town b = new Town("B");
        Town c = new Town("C");
        Town d = new Town("D");
        Town e = new Town("E");

        graph.routingTable.put(a, new Edge(a, b, 5).next(new Edge(a, d, 5).next(new Edge(a, e, 7))));
        graph.routingTable.put(b, new Edge(b, c, 4));
        graph.routingTable.put(c, new Edge(c, d, 8).next(new Edge(c, e, 2)));
        graph.routingTable.put(d, new Edge(d, c, 8).next(new Edge(d, e, 6)));
        graph.routingTable.put(e, new Edge(e, b, 3));

        //The distance of the route A-B-C
        ArrayList<Town> routes1 = new ArrayList<Town>();
        routes1.add(a);
        routes1.add(b);
        routes1.add(c);
        //The distance of the route A-D
        ArrayList<Town> routes2 = new ArrayList<Town>();
        routes2.add(a);
        routes2.add(d);
        //3. Distance of route A-D-C
        ArrayList<Town> routes3 = new ArrayList<Town>();
        routes3.add(a);
        routes3.add(d);
        routes3.add(c);
        //4. Distance of route A-E-B-C-D
        ArrayList<Town> routes4 = new ArrayList<Town>();
        routes4.add(a);
        routes4.add(e);
        routes4.add(b);
        routes4.add(c);
        routes4.add(d);
        //The distance of the route A-E-D
        ArrayList<Town> routes5 = new ArrayList<Town>();
        routes5.add(a);
        routes5.add(e);
        routes5.add(d);
        try {
            System.out.println("Distance between A, B, C :  " + graph.findDistanceBetweenTowns(routes1));
            System.out.println("Distance between A, D :  " + graph.findDistanceBetweenTowns(routes2));
            System.out.println("Distance between A, D, C :  " + graph.findDistanceBetweenTowns(routes3));
            System.out.println("Distance between A, E,B, C, D, :  " + graph.findDistanceBetweenTowns(routes4));
            System.out.println("Distance between A, E,B, C, D, :  " + graph.findDistanceBetweenTowns(routes5));   //no such route exception
        } catch (Exception ex) {
            System.out.println (ex.toString());
        }

        //6. Number of trips starting at C,ending at C with 3 stops max
        System.out.println("The number of trips starting at C and ending at C with a maximum of 3 stops:   " + graph.numberOfStopsBetweenTowns(c, c, 3));

        //7. Number of trips starting at A,ending at C with 4 stops max
        System.out.println("The number of trips starting at A and ending at C with exactly 4 stops:   " + graph.numberOfStopsBetweenTowns(a, c, 4));

        //8.The length of the shortest route from A to C.
        System.out.println("The length of the shortest route (in terms of distance to travel) from A to C:   " + graph.shortestRouteBetweenTowns(a, c));

        //9.The length of the shortest route from B to B.
        System.out.println("The length of the shortest route (in terms of distance to travel) from B to B:   " + graph.shortestRouteBetweenTowns(b, b));

        //10.The number of different routes from C to C with a distance of less than 30
        System.out.println("The number of different routes from C to C with a distance of less than 30:   " + graph.numRoutesWithin(c, c, 30));


    }
}
