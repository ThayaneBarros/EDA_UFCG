package pilha;

import java.util.Scanner;
import java.util.Stack;
/**
 * Programa inverte os valores de uma pilha até um determinado índice lido da entrada.
 *  
 * @author Thayane Barros
 *
 */
public class PilhaInvertida {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int capacidade = sc.nextInt();
		sc.nextLine();
		String[] num = sc.nextLine().split(" ");
		
		int indice = sc.nextInt();
		
		int[] num2 = new int[capacidade];
		for(int i = 0; i < num.length; i++) {
			num2[i] = Integer.parseInt(num[i]);
		}
		
		Stack pilha = invertePilhaIndex(num2, capacidade, indice);
		
		System.out.println("-");
		for(int i = 0; i < capacidade; i++) {
			System.out.println(pilha.pop());
		}

	}

	private static Stack invertePilhaIndex(int[] num2, int capacidade, int indice) {
		Stack<Integer> pilhaNum = new Stack();
		for(int i = 0; i < capacidade; i++) {
			pilhaNum.push(num2[i]);
		}
		
		Stack<Integer> pilhaAux = new Stack();
		for(int i = 0; i <= indice; i++) {
			pilhaAux.push(pilhaNum.pop());
		}
		
		Stack<Integer> pilhaAuxInvertida = new Stack();
		for(int i = 0; i <= indice; i++) {
			pilhaAuxInvertida.push(pilhaAux.pop());
		}
		
		for(int i = 0; i <= indice; i++) {
			pilhaNum.push(pilhaAuxInvertida.pop());
		}
		
		return pilhaNum;
		
	}

}
