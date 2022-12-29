package linkedList;

import java.util.Scanner;

public class Filtra {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" ");
		int n = sc.nextInt();
		
		LinkedList num2 = new LinkedList();
		for(int i = 0; i < num.length; i++) {
			num2.addLast(Integer.parseInt(num[i]));
		}
		
		if(!num2.isEmpty()) {
			while(num2.contains(n)) {
				num2.remove(n);
			}
		}
		
		System.out.println(num2.toString());

	}
	
	public static class LinkedList{
		
		protected Node head;
		protected Node tail;
		public int size;
		
		public LinkedList() {
			this.size = 0;
			this.head = null;
			this.tail = null;
		}
		
		public boolean contains(int n) {
			Node aux = this.head;
			
			while(aux != null) {
				if(aux.data == n) {
					return true;
				}
				aux = aux.next;
			}
			
			return false;
		}

		public boolean isEmpty() {
			return this.head == null;
		}
		
		public void addLast(int v) {
			Node value = new Node(v);
			
			if(this.isEmpty()) {
				this.tail = value;
				this.head = value;
			} else {
				this.tail.next = value;
				value.prev = this.tail;
				this.tail = value;
			}
			
			this.size++;
		}
		
		public void remove(int v) {
			Node aux = this.head;
			
			for(int i = 0; i < this.size; i++) {
				if(aux.data == v) {
					if(i == 0) { this.removeFirsh(); }
					else if(i == this.size - 1) { this.removeLast(); }
					else {
						aux.prev.next = aux.next;
						aux.next.prev = aux.prev;
						size--;
					}
					return;
				}
				aux = aux.next;
			}
		}
		
		public void removeFirsh() {
			if(!this.isEmpty()) {
				if(this.head == this.tail) {
					this.head = null;
					this.tail = null;
				} else {
					this.head = this.head.next;
					this.head.prev = null;
				}
				
				this.size--;
			}		
		}
		
		public void removeLast() {
			if(!this.isEmpty()) {
				if(this.head == this.tail) {
					this.head = null;
					this.tail = null;
				} else {
					this.tail = this.tail.prev;
					this.tail.next = null;
				}
				
				this.size--;
			}	
		}
		
		public String toString() {
			String out = "vazia";
			
			if(!this.isEmpty()) {
				out = "";
				Node aux = this.head;
				for(int i = 0; i < this.size; i++) {
					out += aux.data + " ";
					
					aux = aux.next;
				}
			}
			
			return out.trim();
		}

	}
	
	public static class Node {
		
		protected int data;
		protected Node next;
		protected Node prev;
		
		public Node(int v) {
			this.data = v;
		}
	}

}
