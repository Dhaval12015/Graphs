import java.util.*;
import java.io.*;
public class RootToLeafSum extends BinarySearchTree{
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
	//	if(root==null) return false;
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
				System.out.println(root.data);
				al.add(sum);
				return true;
			}
			if(rootToLeafSum(root.right,sum)){
				al.add(sum);
				return true;
			}
		}
		return false;
	}
	public static void main(String args[]){
		BinarySearchTree bt = new BinarySearchTree();
		RootToLeafSum obj = new RootToLeafSum();
		
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
		//bt.inorder();
		obj.rls(8);
		
	}
}
