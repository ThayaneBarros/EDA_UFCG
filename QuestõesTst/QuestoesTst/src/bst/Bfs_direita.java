package bst;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Bfs_direita {

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
		
		int[] arr2 = arr.buscaLargura();
		
		String out = "";
		for(int i = 0; i < arr2.length; i++) {
			out += arr2[i] + " ";
		}
		
		System.out.println(out.trim());

	}
	
	public static class Node {
		
		protected int value;
		protected Node left;
		protected Node right;
		protected Node parent;
		
		public Node(int value) {
			this.value = value;
		}

		public boolean isLeaf() {
			return left == null && right == null;
		}
		
	}
	
	public static class BST {
		
		protected Node root;
		
		public boolean isEmpty() {
			return this.root == null;
		}

		public int[] buscaLargura() {
			int[] out = new int[this.contaNo()];
			int i = 0;
			Deque<Node>fila = new LinkedList<Node>();
			
			if(!this.isEmpty()) {
				fila.addLast(this.root);
				while(!fila.isEmpty()) {
					Node current = fila.remove();
					out[i++] = current.value;
					
					if(current.right != null) {
						fila.addLast(current.right);
					}
					if(current.left != null) {
						fila.addLast(current.left);
					}
				}
			}
			return out;
		}

		public int contaNo() {
			if(isEmpty()) return 0;
			else return contaNo(this.root);
		}

		private int contaNo(Node root2) {
			if(root2 == null) {
				return 0;
			} else {
				return 1 + contaNo(root2.left) + contaNo(root2.right);
			}
			
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
