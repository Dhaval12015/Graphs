import java.util.*;
import java.math.*;
public class Topological_Sort {
	static class Graph{
		private static int V;
		private LinkedList<Integer> adj[];

		Graph(int v){
				V = v;
				adj = new LinkedList[v];
				for(int i=0;i<V;i++){
					adj[i] = new LinkedList();
				}
			}
		
	void  addEdge(int s,int d){
		adj[s].add(d);
	}
	void topologicalSortUtil(int i,boolean vis[],Stack s){
		vis[i] = true;
		Integer j;
		Iterator<Integer> it = adj[i].iterator();
		while(it.hasNext()){
			j = it.next();
			if(vis[j]==false) topologicalSortUtil(j,vis,s);
		}
		s.push(new Integer(i));
	}
	void topologicalSort(){
		Stack s = new Stack();
		boolean vis[] = new boolean[V];
		for(int i=0;i<V;i++) vis[i] = false;
		for(int i=0;i<V;i++){
			if(vis[i]==false){
				topologicalSortUtil(i,vis,s);
			}
		}
		while(s.empty()==false){
			System.out.print(s.pop()+" ");
		}	
	}
	}
	public static void main(String args[]){
		Graph g = new Graph(6);
		 	g.addEdge(5, 2);
	        g.addEdge(5, 0);
	        g.addEdge(4, 0);
	        g.addEdge(4, 1);
	        g.addEdge(2, 3);
	        g.addEdge(3, 1);
	        System.out.println("Following the oreder of topologice sort");
	        g.topologicalSort();
		
		
	}
}
