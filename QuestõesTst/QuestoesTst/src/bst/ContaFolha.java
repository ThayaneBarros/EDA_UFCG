package bst;

import java.util.Scanner;

public class ContaFolha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" ");
		
		int[] num2 = new int[num.length];
		for(int i = 0; i < num.length; i++) {
			num2[i] = Integer.parseInt(num[i]);
		}
		
		System.out.println(contaFolha(num2));

	}
	
	private static int contaFolha(int[] num) {
		BST out = new BST();
		
		for(int i = 0; i < num.length; i++) {
			out.add(num[i]);
		}
		
		return out.contLeaf();
	}
	
	public static class BST {
		
		protected Node root;
		
		public boolean isEmpty() {
			return this.root == null;
		}
		
		public int contLeaf() {
			return contLeaf(this.root);
		}

		private int contLeaf(Node node) {
			if(node == null) return 0;
		//	if(node.left == null && node.right == null) return 1;
		//	else return contLeaf(node.left) + contLeaf(node.right);
			
			if(node.left == null || node.right == null) return 0;
			else return 1 + contLeaf(node.left) + contLeaf(node.right);
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
	

	public static class Node {
		
		protected int value;
		protected Node left;
		protected Node right;
		protected Node parent;
		
		public Node(int value) {
			this.value = value;
		}
		
	}

}
