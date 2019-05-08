/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Adeel
 */
public class Edge {
    
	public Town origin;
	public Town destination;
	public int weight;
	public Edge next;

  public Edge (Town origin, Town destination){
    this(origin, destination, Integer.MAX_VALUE);
  }

	public Edge(Town origin, Town destination, int weight) {
		this.origin 		= origin;
		this.destination	= destination;
		this.weight 		= weight;
		this.next 		= null;
	}

	public Edge next(Edge edge) {
		this.next = edge;
		return this;
	}

  public double getWeight() {
    return weight;
  }

  public String toString() {
    return origin + "to" + destination;
  }
}
