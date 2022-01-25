package recap_java;
import java.util.*;

class Edge {
    int src, dest, weight;
    Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
}

public class Graph {
	Hashtable adjMap = new Hashtable(10);
		// node of adjacency list 
	class Node {
		int value, weight;
		Node(int value, int weight)  {
			this.value = value;
			this.weight = weight;
		}
	}
	List<List<Node>> adj_list = new ArrayList<>();
	private Map<Vertex,List<Vertex>> adjVertices;
	public LinkedList findAdjList(Vertex vertex){
		
		return 
	}
	 public Graph(List<Vertex> vertices , List<Edge> edges) {
		for (Vertex vertex : vertices){
			adjMap.put(vertex, adj_list);
		}
	    for (Edge e : edges)
        {
            // allocate new node in adjacency List from src to dest
            adj_list.get(e.src).add(new Node(e.dest, e.weight));
        }
	    }

	 public void addVertex(String label) {
	        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
	    }

	 public void removeVertex(String label) {
	        Vertex v = new Vertex(label);
	        adjVertices.values().stream().forEach(e -> e.remove(v));
	        adjVertices.remove(new Vertex(label));
	    }
	 
	 public void addEdge(String label1, String label2) {
	        Vertex v1 = new Vertex(label1);
	        Vertex v2 = new Vertex(label2);
	        adjVertices.get(v1).add(v2);
	        adjVertices.get(v2).add(v1);
	    }

	 public void removeEdge(String label1, String label2) {
	        Vertex v1 = new Vertex(label1);
	        Vertex v2 = new Vertex(label2);
	        List<Vertex> eV1 = adjVertices.get(v1);
	        List<Vertex> eV2 = adjVertices.get(v2);
	        if (eV1 != null)
	            eV1.remove(v2);
	        if (eV2 != null)
	            eV2.remove(v1);
	    }

	 public List<Vertex> getAdjVertices(String label) {
	        return adjVertices.get(new Vertex(label));
	    }
	    
	class Vertex {
		     String label;
		        Vertex(String label) {
		            this.label = label;
		        }
	}

}
