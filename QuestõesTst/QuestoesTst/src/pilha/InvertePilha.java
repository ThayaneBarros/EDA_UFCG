package pilha;

import java.util.Scanner;
import java.util.Stack;
/**
 * Programa lê os valores que, dada uma pilha como entrada, inverte os valores dessa pilha.
 * 
 * @author Thayane Barros
 *
 */
public class InvertePilha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Stack<Integer> pilha = new Stack<>();
		Stack<Integer> pilhaAux = new Stack<>();
		
		for(int i = 0; i < num; i++) {
			pilha.push(sc.nextInt());
		}
		
		while(!pilha.isEmpty()) {
			pilhaAux.push(pilha.pop());
		}
		
		while(!pilhaAux.isEmpty()) {
			System.out.println(pilhaAux.pop());
			
		}

	}

}
