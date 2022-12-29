package heap;

import java.util.Arrays;
import java.util.Scanner;

public class buidHeap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" ");
		
		int[] num2 = new int[num.length];
		for(int i = 0; i < num.length; i++) {
			num2[i] = Integer.parseInt(num[i]);
		}
		
		Heap arr = new Heap(num2);
		
		
		System.out.println(Arrays.toString(arr.buildHeap()));

	}
	
	public static class Heap{
		private int[] heap;
		private int tail;
		
		public Heap(int cap) {
			this.heap = new int[cap];
			this.tail = -1;
		}
		
		public Heap(int[] arr) {
			this.heap = arr;
			this.tail = arr.length - 1;
		}
		
		public int[] buildHeap() {
			for(int i = parent(tail); i >= 0; i--) {
				heapify(i);
			}
			return heap;
		}

		private void heapify(int i) {
			if(!isLeaf(i) || isValidIndex(i)) {
				int max = indexMax(i, left(i), right(i));
				
				if(max != i) {
					int aux = heap[i];
					heap[i] = heap[max];
					heap[max] = aux;
					heapify(max);
				}
			}
			
		}


		private int indexMax(int i, int left, int right) {
			int out  = i;
			
			if(isValidIndex(left) && heap[out] < heap[left]) {
				out = left;
			}
			if(isValidIndex(right) && heap[out] < heap[right]) {
				out = right;
			}
			
			return out;
		}

		private boolean isValidIndex(int i) {
			return i >= 0 && i <= tail;
		}

		private boolean isLeaf(int i) {
			return i > parent(tail) && i <= tail;
		}


		private int left(int i) {
			return i * 2 + 1;
		}
		
		private int right(int i) {
			return (i + 1) * 2;
		}
		
		private int parent(int i) {
			return (i-1)/2;
		}
	}

}
