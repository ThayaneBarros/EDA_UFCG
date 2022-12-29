package pilha;

import java.util.Scanner;
import java.util.Stack;
/**
 * Programa ordena os valores uma pilha dada como entrada
 * 
 * @author Thayane Barros
 *
 */
public class ordenaPilhaInvertendo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int indice = sc.nextInt();
		sc.nextLine();
		String[] num = sc.nextLine().split(" ");
	
		Stack<Integer> pilha = new Stack();
		
		for(int i = 0; i < num.length; i++) {
			pilha.push(Integer.parseInt(num[i]));
		}
		
		pilha = ordenaPilhaInvertendo(pilha);
		
		System.out.println("-");
		for(int i = 0; i < indice; i++) {
			System.out.println(pilha.pop());
		}


	}

	private static Stack ordenaPilhaInvertendo(Stack<Integer> pilha) {
		Stack<Integer> pilhaInvertida = new Stack();
		
		while(!(pilha.isEmpty())) {
			int maior = getMaxPilha(pilha);
			pilhaInvertida.push(maior);
		}
		
		return pilhaInvertida;
	}

	private static int getMaxPilha(Stack<Integer> pilha) {
		Stack<Integer> pilhaAux = new Stack();
		
		int maior = pilha.peek();
		while(!(pilha.isEmpty())) {
			int value = pilha.pop();
			pilhaAux.push(value);
			
			if(value > maior) {
				maior = value;
			}
		}
		
		while(!(pilhaAux.isEmpty())) {
			int value = pilhaAux.pop();
			pilha.push(value);

		}
		
		while(!pilha.isEmpty()) {
			int value = pilha.pop();
			
			if(value == maior) {
				break;
			}
			pilhaAux.push(value);
			
		}
		
		while(!pilhaAux.isEmpty()) {
			pilha.push(pilhaAux.pop());
			
		}
		
		
		return maior;
	}

}
