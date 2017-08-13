package pet;

import java.util.Stack;

import sun.misc.Queue;
import tree.BST;
import tree.BinarySearchTree;
import geeks.tree.BST2DLL;

public class ReverseLevelOrderTrvslTree {
	
	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(4);
		bst.insert(2);
		bst.insert(5);
		bst.insert(1);
		bst.insert(6);
		bst.insert(3);
		bst.insert(7);
		
		bst.inOrderTraversal();
		
		try {
			reverseLevelOrder(bst);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void reverseLevelOrder(BST bst) throws Exception {
		
		Queue queue = new Queue();
		Stack<BST.Node> stack = new Stack<BST.Node>();
		queue.enqueue(bst.getRoot());
		while(!queue.isEmpty()){
			BST.Node node = (BST.Node)queue.dequeue();
			stack.push(node);
			if(node!=null){
				if(node.getRightChild()!=null){
					queue.enqueue(node.getRightChild());
				}
				if(node.getLeftChild()!=null){
					queue.enqueue(node.getLeftChild());
				}
			}
		}
		
		while (!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		
		
	}

}
