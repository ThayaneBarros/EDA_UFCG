package heap;

import java.util.Scanner;

public class isHeap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" ");
		
		int[] num2 = new int[num.length];
		for(int i = 0; i < num.length; i++) {
			num2[i] = Integer.parseInt(num[i]);
		}
		
		Heap arr = new Heap(num2);
		
		
		System.out.println(arr.isHeap());

	}
	
	
	public static class Heap{
		private int[] heap;
		private int tail;
		
		public Heap(int cap) {
			this.heap = new int[cap];
			this.tail = -1;
		}
		
		public boolean isHeap() {
			 return recursiveIsHeap(0);
		}

		private boolean recursiveIsHeap(int aux) {
			boolean out = true;
			if(aux <= tail && left(aux) <= tail && right(aux) <= tail) {
				if(isHeap(aux)) {
					out = recursiveIsHeap(left(aux));
					if(out) {
						out = recursiveIsHeap(right(aux));
					}
					
				} else {
					out = false;
				}
			}
			return out;
		}

		private boolean isHeap(int aux) {
			return heap[aux] > heap[left(aux)] && heap[aux] > heap[right(aux)];
			
		}

		public Heap(int[] arr) {
			this.heap = arr;
			this.tail = arr.length - 1;
		}

		private int left(int i) {
			return i * 2 + 1;
		}
		
		private int right(int i) {
			return (i + 1) * 2;
		}
	
	}

}
