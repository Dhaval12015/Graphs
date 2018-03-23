import java.util.*;
import java.io.*;
public class DetectCycle {
	private int V;
	private LinkedList<Integer> adj[];
	DetectCycle(int v){
		V = v;
		adj = new LinkedList[V];
		for(int i=0;i<V;i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	void addedge(int u,int v){
		adj[u].add(v);
		adj[v].add(u);
	}
	boolean isCycle(int i,boolean vis[],int p){
		
		if(!vis[i]){
			vis[i] = true;
			for(int j=0;j<adj[i].size();j++){
				if(vis[adj[i].get(j)] && adj[i].get(j)==p){
					continue;
				}
				if(vis[adj[i].get(j)] && adj[i].get(j)!=p){
					return false;
				}
				else if(!vis[adj[i].get(j)]){
					return isCycle(adj[i].get(j),vis,i);
				}
			}
		}
		return true;
	}
	boolean isTree(){
		boolean vis[] = new boolean[V];
		for(int i=0;i<V;i++) vis[i] = false;
		
			if(isCycle(0,vis,-1)) return false;
			for(int i=0;i<V;i++) if(!vis[i]) return false;
		
		return true;
	}
	public static void main(String args[]){
		DetectCycle graph = new DetectCycle(3);
		graph.addedge(0, 1);
		graph.addedge(0, 2);
	//	graph.addedge(1, 2);
		if(graph.isTree()){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}
}
