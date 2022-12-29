package linkedList;

import java.util.Scanner;

public class RemoveIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" ");
		int n = sc.nextInt();
		
		LinkedList numeros = new LinkedList();
		for(int i = 0; i < num.length; i++) {
			numeros.addLast(Integer.parseInt(num[i]));
		}
		
		numeros.remove(n);
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
		
		public int removeFirsh() {
			if(isEmpty()) throw new RuntimeException();
			
			int value = this.head.data;
			
			if(this.head.next == null) {
				this.head = null;
				this.tail = null;
			} else {
				this.head = this.head.next;
				this.head.prev = null;
			}
			
			this.size--;
			return value;
			
		}
		
		public int removeLast() {
			if(isEmpty()) throw new RuntimeException();
			
			int value = this.tail.data;
			
			if(this.head.next == null) {
				this.head = null;
				this.tail = null;
			} else {
				this.tail = this.tail.prev;
				this.tail.next = null;
			}
			
			this.size--;
			return value;
		}

		public int remove(int index) {
			if(index < 0 || index > this.size) {
				throw new IndexOutOfBoundsException();
			}
			
			if(index == 0 ) return this.removeFirsh();
			else if(index == this.size -  1) return this.removeLast();
			
			Node aux = this.head;
			for(int i = 0; i < index; i++) {
				aux = aux.next;
			}
				
			aux.prev.next = aux.next;
			aux.next.prev = aux.prev;
				
			size--;
			return aux.data;
			
		}
		
		public String toString() {
			String out = "";	
			
			Node aux = this.head;
			for(int i = 0; i < this.size; i++) {
				out += aux.data + " ";		
				aux = aux.next;
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
