package hash;

import java.util.Scanner;

public class WordCloud {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] frase = sc.nextLine().split(" ");
		HashMap2 mapa = new HashMap2(frase.length);
		
		for(int i = 0; i < frase.length; i++) {
			mapa.put(new Palavra(frase[i]));
		}
		
		String entrada = sc.nextLine();
		
		while(!entrada.equals("fim")) {
			System.out.println(mapa.qtdPalavra(entrada));
			entrada = sc.nextLine();
		}

	}
	
	public static class HashMap2 {
		
		protected Palavra[] tabela;
		protected static final double FATOR_DE_CARGA = 0.75;
		private int size;
		
		public HashMap2(int capacity) {
			this.tabela = new Palavra[capacity];
			
		}
		
		public void put(Palavra palavra) {
			if((this.size / this.tabela.length >= this.FATOR_DE_CARGA) || (this.size == this.tabela.length)) {
				
				Palavra[] novaTabela = new Palavra[this.tabela.length * 2];
				this.size = 0;
				
				for(int i = 0; i < this.tabela.length; i++) {
					if(this.tabela[i] != null) {
						put(novaTabela, this.tabela[i]);
					}
				}
				put(novaTabela,palavra);
				this.tabela = novaTabela;
			} else {
				put(tabela,palavra);
			}
		}

		private void put(Palavra[] tabela2, Palavra palavra) {
			int sondagem = 0;
			int hash;
			
			while(sondagem < this.tabela.length) {
				hash = (this.hash(palavra.getPalavra()) + sondagem) % this.tabela.length;
				Palavra p = tabela2[hash];
				
				if(p == null || p.getPalavra().equals(palavra.getPalavra())) {
					if(p != null && p.getPalavra().equals(palavra.getPalavra())) {
						p.acrescentaFrequencia();
					} else {
						tabela2[hash] = palavra;
						palavra.acrescentaFrequencia();
		
					}
					return;
				}
				sondagem++;
			}
			
		}
		
		private int hash(String pal) {
			return Math.abs(pal.hashCode()) % this.tabela.length;
		}
		
		public int qtdPalavra(String pal) {
			int sondagem = 0;
			int hash;
			
			while(sondagem < this.tabela.length) {
				hash = (this.hash(pal) + sondagem) % this.tabela.length;
				Palavra p = tabela[hash];
				
				if(p == null) return 0;
				else if(p != null && p.getPalavra().equals(pal)) {
					return p.getFrequencia();
				}
				sondagem++;
			}
			return 0;
		}
		
	}
	
	public static class Palavra {
		
		protected String palavra;
		protected int freq;
		
		public Palavra(String p) {
			this.palavra = p;
			this.freq = 0;
		}
		
		public void acrescentaFrequencia() {
			this.freq++;
		}
		
		public int getFrequencia() {
			return this.freq;
		}
		
		public String getPalavra() {
			return this.palavra;
		}
	}

}
