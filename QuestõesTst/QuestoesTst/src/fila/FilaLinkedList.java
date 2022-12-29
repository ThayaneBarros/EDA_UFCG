package fila;

import java.util.Scanner;

public class FilaLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fila fila = new Fila();
		String[] entrada = sc.nextLine().split(" ");
		
		while(!entrada[0].equals("end")) {
			if(entrada[0].equals("print")) {
				System.out.println(fila.print());
			} else if(entrada[0].equals("element")) {
				System.out.println(fila.element());
				
			}  else if(entrada[0].equals("remove")) {
				if(fila.print().equals("empty")) {
					System.out.println("empty");
				} else {
					fila.remove();
				}
				
			} else if(entrada[0].equals("add")) {
				fila.add(Integer.parseInt(entrada[1]));
			} else if(entrada[0].equals("search")) {
				System.out.println(fila.search(Integer.parseInt(entrada[1])));
				
			}
			entrada = sc.nextLine().split(" ");
			
		}

	}
	
	public static class Fila {

		protected LinkedList fila;
		
		public Fila() {
			this.fila = new LinkedList();
		}
		
		public boolean isEmpty() {
			return this.fila.isEmpty();
		}
		
		public void add(int v) {
			this.fila.addLast(v);
		}
		
		public void remove() {
			if(!this.isEmpty()) {
				this.fila.removeFirsh();
			}
			
		}
		
		public int element() {	
			return this.fila.head.data;	
		}
		
		public String print() {
			return fila.toString();
		}
		
		public int search(int v) {
			return this.fila.search(v);
		}
		
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
		
		public String toString() {
			String out = "empty";
			
			if(!this.isEmpty()) {
				out = "";
				Node aux = this.head;
				while(aux != null) {
					out += aux.data + " ";
					aux = aux.next;
				}
			
			}
			
			return out.trim();
		}
		
		public int search(int v) {
			if(!this.isEmpty()) {
				Node aux = this.head;
				int cont = 0;
				
				while(aux!= null) {
					if(aux.data == v) {
						return cont;
					}
					aux = aux.next;
					cont++;
				}
				
			}
			return -1;
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
