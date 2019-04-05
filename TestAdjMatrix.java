/** 
 *
 * TestAdjMatrix.java
 *
 * This program tests the Graph class with BFS, DFS,
 * shortest path, and dijkstra's
 *
 * @author  Aaron Brill
 * Date:    May 11, 2018
 *
 */
public class TestAdjMatrix {

	public static void main(String[] args) 
	{
		Graph g = new Graph(10);
		g.setVertexName(0, "Buffalo");
		g.setVertexName(1, "Glens Falls");
		g.setVertexName(2, "Syracuse");
		g.setVertexName(3, "Saratoga Springs");
		g.setVertexName(4, "Amsterdam");
		g.setVertexName(5, "Albany");
		g.setVertexName(6, "Greenwich");
		g.setVertexName(7, "Bronx");
		g.setVertexName(8, "Manhattan");
		g.setVertexName(9, "Long Island");

		g.addEdge(0,1);
		g.addEdge(0,3);
		g.addEdge(0,6);
		g.addEdge(0,7);
		g.addEdge(1,6);
		g.addEdge(1,5);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(2,8);
		g.addEdge(2,4);
		g.addEdge(4,9);
		g.addEdge(8,9);
		
		String output = g.BFS(3);
		System.out.println("BFS starting at 3");
		System.out.println(output);

		output = g.DFS(3);
		System.out.println("DFS starting at 3");
		System.out.println(output);

		output = g.shortestPath(3);
		System.out.println("Shortest paths starting at 3");
		System.out.println(output);

		Graph g2 = new Graph(10);
		g2.setVertexName(0, "Buffalo");
		g2.setVertexName(1, "Glens Falls");
		g2.setVertexName(2, "Syracuse");
		g2.setVertexName(3, "Saratoga Springs");
		g2.setVertexName(4, "Amsterdam");
		g2.setVertexName(5, "Albany");
		g2.setVertexName(6, "Greenwich");
		g2.setVertexName(7, "Bronx");
		g2.setVertexName(8, "Manhattan");
		g2.setVertexName(9, "Long Island");

		g2.addDirectedEdgeWithWeight(0,1,5);
		g2.addDirectedEdgeWithWeight(0,3,7);
		g2.addDirectedEdgeWithWeight(0,6,9);
		g2.addDirectedEdgeWithWeight(0,7,6);
		g2.addDirectedEdgeWithWeight(1,6,3);
		g2.addDirectedEdgeWithWeight(1,5,9);
		g2.addDirectedEdgeWithWeight(1,2,2);
		g2.addDirectedEdgeWithWeight(2,5,6);
		g2.addDirectedEdgeWithWeight(2,8,7);
		g2.addDirectedEdgeWithWeight(2,4,9);
		g2.addDirectedEdgeWithWeight(3,5,6);
		g2.addDirectedEdgeWithWeight(4,9,3);
		g2.addDirectedEdgeWithWeight(8,9,3);

		output = g2.dijkstras(0);
		System.out.println("Dijkstra's algorithm starting at 0");
		System.out.println(output);

	}

}
