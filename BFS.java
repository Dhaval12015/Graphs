import java.util.*;
public class BFS {
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
		void BreathFirstSearch(int s){
			Queue<Integer> Q = new PriorityQueue<Integer>();
			boolean vis[] = new boolean[V];
			Q.add(s);
			vis[s] = true;
			HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
			for(Map.Entry<Integer, Integer> entry : hm.entrySet());
			while(Q.size()!=0){
				int n = Q.poll();
				System.out.println(n+" ");
				Iterator<Integer> it = adj[n].listIterator();
				while(it.hasNext()){
					int m = it.next();
					if(!vis[m]){
						vis[m] = true;
						Q.add(m);
					}	
				}
			}
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
		g.BreathFirstSearch(3);
	}
}
