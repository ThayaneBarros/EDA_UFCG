package pilha;

import java.util.Scanner;
import java.util.Stack;
/**
 * Programa retornar o maior elemento de uma pilha considerando os valores entre o topo e o índice passado na entrada padrão.
 * 
 * @author Thayane Barros
 *
 */
public class MaxPilhaIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" ");
		int indice = sc.nextInt();
		
		
		Stack<Integer> pilha = new Stack();
		
 		
		for(int i = 0; i < num.length; i++) {
			pilha.push(Integer.parseInt(num[i]));
		}
		
		int valor = maiorValor(pilha, indice);
		
		System.out.println(valor);

	}

	private static int maiorValor(Stack pilha, int indice) {
		Stack<Integer> pilhaAux = new Stack();
		int maior = (int) pilha.peek();
		
		for(int i = 0; i <= indice; i++) {
			int value = (int) pilha.pop();
			pilhaAux.push(value);
			
			if(value > maior) {
				maior = value;
			}
		}
		
		for(int i = 0; i <= indice; i++) {
			pilha.push(pilhaAux.pop());
		}
		
		return maior;
		
	}

}
