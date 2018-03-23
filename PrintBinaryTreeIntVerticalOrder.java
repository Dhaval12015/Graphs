import java.util.*;
import java.math.*;
public class PrintBinaryTreeIntVerticalOrder {
	
	static class Node{
		
		Node left,right;
		int data;
		Node(){ Node root = null;}
		Node(int d){
			data = d;
			left=right=null;
		}
	
	Node insertNode(Node root,int d){
		if(root==null){
			root = new Node(d);
			System.out.println(root.data);
			return root;
		}
		else if(d<=root.data){
			insertNode(root.left,d);
		}
		else if(d>root.data){
			insertNode(root.right,d);
		}
		return root;
	}
	void printTree(Node root){
		if(root==null)	return;
		System.out.println(root.data);
		printTree(root.left);
		printTree(root.right);
	}
	}
	
	public static void main(String args[]){
		Node obj = new Node();
	}
}
