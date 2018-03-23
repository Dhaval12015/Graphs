import java.util.*;

public class DFS {
	static class Graph{
		int V;
		LinkedList<Integer> adj[];
		Graph(int v){
			V = v;
			adj = new LinkedList[V];
			for(int i=0;i<V;i++){
				adj[i] = new LinkedList();
			}
		}
		void addEdge(int v,int w){
			adj[v].add(w);
		}
		void DepthFirstSearch(int s,boolean vis[]){
			System.out.println(s+" ");	
			vis[s] = true;
				Iterator<Integer> it = adj[s].listIterator();
				while(it.hasNext()){
					int m = it.next();
					if(!vis[m]){
					DepthFirstSearch(m,vis);
					}	
				}
			
		}
		void callDFS(int s){
			boolean vis[] = new boolean[V];
			DepthFirstSearch(0,vis);
		}
	}
	public static void main(String args[]){
		
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.callDFS(2);
	}
}
