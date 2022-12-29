package bst;

import java.util.Scanner;

public class AlturaBST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" ");
		
		int[] num2 = new int[num.length];
		for(int i = 0; i < num.length; i++) {
			num2[i] = Integer.parseInt(num[i]);
		}
		
		System.out.println(alturaBST(num2));

	}

	private static int alturaBST(int[] num) {
		BST out = new BST();
		
		for(int i = 0; i < num.length; i++) {
			out.add(num[i]);
		}
		
		return out.height();
	}
	
	public static class BST {
		
		protected Node root;
		
		public boolean isEmpty() {
			return this.root == null;
		}
		
		public int height() {
			return height(this.root);
		}

		private int height(Node node) {
			if(node == null) return -1;
			else return 1 + Math.max(height(node.left), height(node.right));
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
