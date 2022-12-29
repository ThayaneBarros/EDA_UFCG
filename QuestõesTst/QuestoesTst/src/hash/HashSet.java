package hash;

import java.util.Arrays;
import java.util.Scanner;

public class HashSet {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = sc.nextInt();
		HashSet2 hash = new HashSet2(tamanho);
		String[] entrada = sc.nextLine().split(" ");
		
		while(!entrada[0].equals("end")) {
			if(entrada[0].equals("put")) {
				System.out.println(Arrays.toString(hash.put(Integer.parseInt(entrada[1]))));
			
			} else if(entrada[0].equals("remove")) {
				System.out.println(Arrays.toString(hash.remove(Integer.parseInt(entrada[1]))));
				
			}  else if(entrada[0].equals("contains")) {
				System.out.println(hash.contains(Integer.parseInt(entrada[1])));
				
			} 
			
			entrada = sc.nextLine().split(" ");
			
		}

	}
	
	public static class HashSet2{
		
		protected Integer[] tabela;
		protected int size;
		public static final Integer APAGADO = null;
		
		public HashSet2(int capacity) {
			this.tabela = new Integer[capacity];
		}
		
		private int hash(int v) {
			return v % this.tabela.length;
		}
		
		public Integer[] put(int value) {
			int sondagem = 0;
			int hash;
			
			while(sondagem < this.tabela.length) {
				hash = (this.hash(value) + sondagem) % this.tabela.length;
				Integer i = this.tabela[hash];
				
				if(i == null || i == value || i == APAGADO) {
					this.tabela[hash] = value;
					this.size++;
					return this.tabela;
				}
				sondagem++;
			}
			
			return this.tabela;
			
		}
		
		public Integer[] remove(int value) {
			int sondagem = 0;
			int hash;
			
			while(sondagem < this.tabela.length) {
				hash = (this.hash(value) + sondagem) % this.tabela.length;
				
				if(this.tabela[hash] != null && this.tabela[hash] == value) {
					this.tabela[hash] = APAGADO;
					this.size--;
					return this.tabela;
				}
				sondagem++;
			}
			
			return this.tabela;
		}
		
		public boolean contains(int value) {
			int sondagem = 0;
			int hash;
			
			while(sondagem < this.tabela.length) {
				hash = (this.hash(value) + sondagem) % this.tabela.length;
				
				if(this.tabela[hash] != null && this.tabela[hash] == value) {
					return true;
				}
				if(this.tabela[hash] == null) {
					return false;
				}
				sondagem++;
			}
			
			return false;
		}
		}
	}


