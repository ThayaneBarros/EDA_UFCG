package linkedList;

import java.util.Scanner;

public class trim {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" ");
		int quant = sc.nextInt();
	
		LinkedList num2 = new LinkedList();
		
	//	String[] num = {"1", "13", "3", "4", "5", "3", "6"};
		for(int i = 0; i < num.length; i++) {
			num2.addLast(Integer.parseInt(num[i]));
		}
		
		num2 = removeElements(num2, quant);
		System.out.println(num2.toString());

	}
	
	private static LinkedList removeElements(LinkedList num2, int quant) {
		for(int i = 0; i < quant; i++) {
			if(!num2.isEmpty()) {
				num2.removeFirsh();
				if(!num2.isEmpty()) {
					num2.removeLast();
				}
			} else {
				break;
			}
		}
		return num2;
	}

	public static class Node {
		protected int value;
		protected Node next;
		protected Node prev;
		
		public Node(int v) {
			this.value = v;
			this.next = null;
			this.prev = null;
		}
		
		public int value() {
			return this.value;
		}
	}
	
	public static class LinkedList {
		
		protected Node head;
		protected Node tail;
		protected int size;
		
		public LinkedList() {
			this.head = null;
			this.tail = null;
			this.size = 0;
		}
		
		public boolean isEmpty() {
			return this.head == null;
		}
		
		public void addLast(int v) {
			Node newNode = new Node(v);
			
			if(isEmpty()) {
				this.head = newNode;
				this.tail = newNode;
			} else {
				this.tail.next = newNode;
				newNode.prev = this.tail;
				this.tail = newNode;
			}
			
			this.size++;
			
		}
		
		public void removeFirsh() {
			if(isEmpty()) throw new RuntimeException();
			
			if(this.head.next == null) {
				this.head = null;
				this.tail = null;
			} else {
				this.head = this.head.next;
				this.head.prev = null;
			}
			
			this.size--;
			
		}
		
		public void removeLast() {
			if(isEmpty()) throw new RuntimeException();
			
			if(this.head.next == null) {
				this.head = null;
				this.tail = null;
			} else {
				this.tail = this.tail.prev;
				this.tail.next = null;
			}
			
			this.size--;
		}
		
		public String toString() {
			String out = "vazia";
			if(!isEmpty()) {
				out = "";
				Node aux = this.head;
				while(aux != null) {
					out += aux.value() + " ";
					aux = aux.next;
				}
			}
			
			return out.trim();
		}
		
		
	}

}

