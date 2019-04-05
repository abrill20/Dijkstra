/** 
 *
 * Graph.java
 *
 * This class has methods for a graph, including BFS, DFS, shortest
 * path algorithms, and constructor/add edge methods.
 *
 * @author  Aaron Brill
 * Date:    May 11, 2018
 *
 */
public class Graph {
	private static Vertex v[];
	private int e[][];
	final int NO_EDGE = 100000;

	/** 
    *
    *  Graph is the constructor method
    *
    *  @param numberOfVertices is the number of vertices
    *
    */
	public Graph(int numberOfVertices) {
		v = new Vertex[numberOfVertices];
		for (int i = 0; i < v.length; i++) {
			v[i] = new Vertex(String.valueOf(i));
		}

		e = new int[numberOfVertices][numberOfVertices];
		for (int i = 0; i < e.length; i++) {
			for (int j = 0; j < e.length; j++) {
				e[i][j] = NO_EDGE;
			}
		}
	}

	/** 
    *
    *  setVertexName sets the vertex's name
    *
    *  @param vertex is the vertex's number(index)
    *  @param name is the desired name
    *
    */
	public static void setVertexName(int vertex, String name) {

		v[vertex].setName(name);

	}

	// trust that the user will call this method and never call
	// add undirected only on unique edges
	/** 
    *
    *  addDirectedEdgeWithWeight adds a directed edge with a weight
    *
    *  @param fromV is the vertex number from which the edge points
    *  @param toV is the vertex number the edge points to
    *  @param weight is the weight of the edge
    *
    */
	public void addDirectedEdgeWithWeight(int fromV, int toV, int weight) {
		e[fromV][toV] = weight;
	}

	/** 
    *
    *  addDirectedEdgeWith adds a directed edge with weight 1
    *
    *  @param fromV is the vertex number from which the edge points
    *  @param toV is the vertex number the edge points to
    *
    */
	public void addDirectedEdge(int fromV, int toV) {
		e[fromV][toV] = 1;
	}
	
	/** 
    *
    *  addEdgeWithWeight adds an edge with a weight
    *
    *  @param v1 and v2 are the vertices of the edge 
    *  @param weight is the weight of the edge
    *
    */
	public void addEdgeWithWeight(int v1, int v2, int weight) {

		e[v1][v2] = weight;
		e[v2][v1] = weight;
	}
	// trust that the user will call this method and never call
	// add directed only on unique edges
	
	/** 
    *
    *  addEdge adds an edge
    *
    *  @param v1 and v2 are the vertices of the edge
    *  they get weight 1
    *
    */
	public void addEdge(int v1, int v2) {
		e[v1][v2] = 1;
		e[v2][v1] = 1;
	}
	
	/** 
    *
    *  setAllUnvisited sets all vertices flag to unvisited
    *
    */
	private void setAllUnvisited() {
		for (int i = 0; i < v.length; i++) {
			v[i].setUnvisited();
		}
	}
	
	/** 
    *
    *  DFS performs a depth first search starting from startV
    *  
    *  @param startV is the vertex where we start
    *
    */
	public String DFS(int startV) {
		String dfsOrder = "";
		setAllUnvisited();
		StackOfInts myStack = new StackOfInts();
		myStack.push(startV);
		dfsOrder += v[startV].getName() + " " + startV + ", ";
		v[startV].setVisited();

		while (!myStack.empty()) {
			int peekedV = myStack.peek();

			int adjV = 0;
			while (adjV < e.length) {
				if (e[peekedV][adjV] != NO_EDGE && v[adjV].isUnvisited()) {
					myStack.push(adjV);
					dfsOrder += v[adjV].getName() + " " + adjV + ", ";
					v[adjV].setVisited();
					break;
				}
				adjV++;
			}

			if (adjV == e.length)
				myStack.pop();
		}

		return dfsOrder;
	}

	/** 
    *
    *  BFS performs a breadth first search starting from startV
    *  
    *  @param startV is the vertex where we start
    *
    */
	public String BFS(int startV) {
		String bfsOrder = "";
		setAllUnvisited();
		// Queue
		Queue myQ = new Queue();
		myQ.enqueue(startV);
		v[startV].setWaiting();
		while (!myQ.empty()) {
			int dqV = myQ.dequeue();
			bfsOrder += v[dqV].getName() + " " + dqV + ", ";
			v[dqV].setVisited();
			for (int adjV = 0; adjV < e[dqV].length; adjV++) {
				if (e[dqV][adjV] < NO_EDGE) {
					if (v[adjV].isUnvisited()) {
						v[adjV].setWaiting();
						myQ.enqueue(adjV);
					}
				}
			}
		}

		return bfsOrder;
	}
	
	/** 
    *
    *  Shortest path performs a brute force shortest path search
    *  on an unweighted adjacency graph from startV
    *  
    *  @param startV is the vertex where we start
    *
    */
	public String shortestPath(int startV) { // assume unweighted
		String pathStr = "";

		setAllUnvisited();
		Queue myQ = new Queue();
		myQ.enqueue(startV);
		v[startV].setWaiting();

		int dist[] = new int[e.length];
		Vertex prev[] = new Vertex[e.length];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = NO_EDGE;
		}
		dist[startV] = 0;

		// start of BFS
		while (!myQ.empty()) {
			int dqV = myQ.dequeue();
			v[dqV].setVisited();
			for (int adjV = 0; adjV < e[dqV].length; adjV++) {
				if (e[dqV][adjV] < NO_EDGE) {
					if (dist[adjV] > dist[dqV] + 1) {
						dist[adjV] = dist[dqV] + 1;
						prev[adjV] = v[dqV];
					}

					if (v[adjV].isUnvisited()) {
						v[adjV].setWaiting();
						myQ.enqueue(adjV);
					}
				}
			}

		}

		String fromV = v[startV].getName() + " " + startV + " to ";
		for (int i = 0; i < dist.length; i++) {
			pathStr += fromV + v[i].getName() + " " + i + " path length = " + dist[i] + "\n";
		}

		return pathStr;
	}
	/** 
    *
    *  dijkstras performs dijkstras algorithm on an adjacency matrix
    *  from startV
    *  
    *  @param startV is the vertex where we start
    *  
    *  @returns pathStr: the shortest path
    *
    */
	public String dijkstras(int startV) {
		String pathStr = "";

		setAllUnvisited();
		PriorityQueue myQ = new PriorityQueue();
		myQ.enqueue(startV, 0);
		v[startV].setWaiting();

		int dist[] = new int[e.length];
		int prev[] = new int[e.length];
		prev[startV] = startV;
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[startV] = 0;

		// start of BFS
		while (!myQ.empty()) {
			int dqV = myQ.dequeue();
			v[dqV].setVisited();
			for (int adjV = 0; adjV < e[dqV].length; adjV++) {
				if (e[dqV][adjV] < NO_EDGE) {  //if there is an edge
					if (dist[adjV] > dist[dqV] + e[dqV][adjV]) { //if the path to dqV to its adjacent vertex is less that the current distance
						dist[adjV] = dist[dqV] + e[dqV][adjV];
						prev[adjV] = dqV;
					}

					if (v[adjV].isUnvisited()) {
						v[adjV].setWaiting();
						myQ.enqueue(adjV, dist[adjV]);
					}
				}
			}
		}
		String fromV = "Minimum weight path from " + v[startV].getName() + " " + startV + " to ";
		for (int i = 0; i < dist.length; i++) {
			pathStr += fromV + v[i].getName() + " " + i + " is " + dist[i];
			pathStr += "\n";
		}
		
		return pathStr;
		
		}
}
