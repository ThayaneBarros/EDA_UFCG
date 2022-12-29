package linkedList;

import java.util.Scanner;

public class TrocaVizinhos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" ");
		int n = sc.nextInt();
		
		LinkedList numeros = new LinkedList();
		for(int i = 0; i < num.length; i++) {
			numeros.addLast(Integer.parseInt(num[i]));
		}

		numeros.trocaVizinhos(n);
		System.out.println(numeros.toString());

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
		
		public void trocaVizinhos(int index) {
			if(index >= 0 && index < this.size) {
				Node aux = this.head;
				Node aux2 = this.head;
				
				for(int i = 0; i < index; i++) {
					aux = aux.next;
				}
				
				if(aux.next != null) {
					aux2 = aux.next;
					
					aux.next = aux2.next;
					aux2.next = aux;
					aux2.prev = aux.prev;
					aux.prev = aux2;
					
					if(aux.next != null) {
						aux.next.prev = aux;
						
					} else {
						this.tail = aux;
					}
					
					if((aux2.prev != null)) {
						aux2.prev.next = aux2;
					} else {
						this.head = aux2;
					}
				}
	
		}
		}
		
		public String toString() {
			String out = "";
			
			if(!this.isEmpty()) {
				Node aux = this.head;
				while(aux != null) {
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
