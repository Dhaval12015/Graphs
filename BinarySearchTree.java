import java.util.*;
import java.io.*;
public class BinarySearchTree {
	Node root,parent;
	BinarySearchTree(){
		root = null;
		parent = null;
	}
	class Node{
		Node left,right,parent;
		int data;
		Node(int data){
			this.data= data;
			left = right = parent = null;
		}
	}
	void insert(int data){
		root = add(root,data);
	}
	Node add(Node root,int data){
		if(root == null){
			root = new Node(data);
			return root;
		}
		else if(data<root.data){
			root.left = add(root.left,data);
			root.left.parent = root;
		}
		else if(data>root.data){
			root.right = add(root.right,data);
			root.right.parent = root;
		}
		return root;
	}
	void inorder(){
		inorderTraversal(root);
		System.out.println();
	}
	void inorderTraversal(Node root){
		if(root==null)
			return;
		if(root.parent!=null)
		System.out.println(root.data+" "+ root.parent.data);
		inorderTraversal(root.left);
		inorderTraversal(root.right);
	}
	void preorder(){
		preorderTraversal(root);
		System.out.println();
	}
	void preorderTraversal(Node root){
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}
	void postorder(){
		postorderTraversal(root);
		System.out.println();
	}
	void postorderTraversal(Node root){
		if(root==null)
			return;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.data+" ");
	}
	int hightOfTree(){
		return hight(root)-1;
	}
	int hight(Node root){
		if(root==null){
			return 0;
		}
		else{
			return Math.max(hight(root.left)+1,hight(root.right)+1);
		}
	}
	boolean search(int data){
		return searchInTree(root,data);
	}
	boolean searchInTree(Node root,int data){
		if(root == null){
			return false;
		}
		else if(root.data==data){
			return true;
		}
		else if(data<root.data){
			return searchInTree(root.left,data);
		}
		else if(data>root.data){
			return searchInTree(root.right,data);
		}
		return false;
	}
	List<Integer> al = new ArrayList<Integer>();
	void rls(int sum){
		if(rootToLeafSum(root,sum)){
			Iterator it = al.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
		}
		else{
			System.out.println("There is NO path Exist");
		}
	}
	boolean rootToLeafSum(Node root,int sum){
		if(root==null) return false;
		if(root.left==null && root.right==null){
			if(sum==root.data){
			al.add(root.data);
			return true;
			}
			else{
				return false;
			}
		}
		else{
			sum -= root.data;
			if(rootToLeafSum(root.left,sum)){
			//	System.out.println(root.data);
				al.add(root.data);
				return true;
			}
			if(rootToLeafSum(root.right,sum)){
				al.add(root.data);
				return true;
			}
		}
		return false;
	}
	void levelOrderTraversal(){
		lot2(root);
	}
	void lot(Node root){
		Queue<Node> q = new LinkedList<Node>();
		if(root==null) return;
		q.add(root);
		while(!q.isEmpty()){
			int s = q.size();
			for(int i=0;i<s;i++){
			System.out.print(q.peek().data+" ");
			
			if(q.peek().left!=null){
				q.add(q.peek().left);
			}
			if(q.peek().right!=null){
				q.add(q.peek().right);
			}
			q.poll();
			}

			System.out.println();
		}
	}
	void lot2(Node root){
		Queue<Node> q = new LinkedList<Node>();
		if(root==null) return;
		q.add(root);
		while(!q.isEmpty()){
			System.out.print(q.peek().data+" ");
			if(q.peek().left!=null){
				q.add(q.peek().left);
			}
			if(q.peek().right!=null){
				q.add(q.peek().right);
			}
			q.poll();
		}
	}
	void lowestCommanAnsister(int a1,int a2){
		System.out.println(lca(root,a1,a2).data);
	}
	Node lca(Node root,int a1,int a2){
		if(root == null) return null;
		if(root.data==a1 || root.data == a2){
			return root;
		}
			Node l = lca(root.left,a1,a2);
			Node r = lca(root.right,a1,a2);
			if(l!=null && r!= null) return root;
			if(l==null && r== null) return null;
		return l!=null?l:r;
	}
	void postOrderTraversalByOneStack(){
		potbos(root);
	}
	void potbos(Node root){
		Stack<Node> s = new Stack<Node>();
		Node curr = root;
		while(!(s.isEmpty() && curr == null)){
			if(curr!=null){
				s.add(curr);
				curr = curr.left;
			}
			else{
				Node temp = s.peek().right;
				if(temp==null){
					temp = s.pop();
					System.out.print(temp.data+" ");
					while(!s.isEmpty() && temp == s.peek().right){
						temp = s.pop();
						System.out.printf(temp.data+" ");
					}
				}
				else{
					curr = temp;
				}	
			}
		}
	}
	public static void main(String args[]){
		BinarySearchTree bt = new BinarySearchTree();
		bt.insert(5);
		bt.insert(2);
		bt.insert(1);
		bt.insert(3);
		bt.insert(8);
		bt.insert(6);
		bt.insert(7);
		bt.insert(9);
		bt.insert(11);
		bt.insert(10);
	//	bt.levelOrderTraversal();
		bt.inorder();
	//	bt.preorder();
	//	bt.postorder();
	//	bt.postOrderTraversalByOneStack();
	//	bt.lowestCommanAnsister(10, 11);
	//	bt.rls(25);
	/*	bt.inorder();
		System.out.println(bt.hightOfTree());
		if(bt.search(2)){
			System.out.println(1);
		}
		else{
			System.out.println(0);
		} */
	}
}
