package bst;

import java.util.Scanner;

public class balance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" ");
		
		int[] num2 = new int[num.length];
		for(int i = 0; i < num.length; i++) {
			num2[i] = Integer.parseInt(num[i]);
		}
		
		BST arr = new BST();
		for(int i = 0; i < num2.length; i++) {
			arr.add(num2[i]);
		}
		
		System.out.println(arr.preOrderBalance());

	}
	
public static class Node {
		
		protected int value;
		protected Node left;
		protected Node right;
		protected Node parent;
		
		public Node(int value) {
			this.value = value;
		}
	}

public static class BST {
	
	protected Node root;
	
	public boolean isEmpty() {
		return this.root == null;
	}


	public String preOrderBalance() {
		String out = "";
		return recursivePreOrderBalance(this.root, out). trim();
	}


	private String recursivePreOrderBalance(Node node, String out) {
		if(node != null) {
			out += node.value + "," + this.balance(node) + " ";
			out = recursivePreOrderBalance(node.left, out);
			out = recursivePreOrderBalance(node.right, out);
		}
		return out;
	}


	private int balance(Node node) {
		return height(node.left) - height(node.right);
	}


	private int height(Node node) {
		if(node == null) return -1;
		return 1 + Math.max(height(node.left), height(node.right));
	}


	public void add(int element) {
		if(this.isEmpty()) {
			this.root = new Node(element);
		} else {
			Node aux = this.root;
			while(aux != null) {
				if(element < aux.value) {
					if(aux.left == null) {
						Node newNode = new Node(element);
						aux.left = newNode;
						newNode.parent = aux;
						return;
					}
					aux = aux.left;
				} else {
					if(aux.right == null) {
						Node newNode = new Node(element);
						aux.right = newNode;
						newNode.parent = aux;
						return;
					}
					aux = aux.right;
				}
			}
		}
		
	}
	
}

}
