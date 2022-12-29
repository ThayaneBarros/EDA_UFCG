package pilha;

import java.util.Scanner;
import java.util.Stack;
/**
 * Programa lê uma expressão matemática com inteiros positivos e imprime o valor resultante dessa expressão.
 * 
 * @author Thayane Barros
 *
 */
public class ExpressaoMatematica {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String expressao = sc.nextLine();
		
		String resul = resolveExpressao(expressao);
		System.out.println(resul);

	}

	private static String resolveExpressao(String expressao) {
		Stack<String> empilha = new Stack<>();
		Stack<String> desempilha = new Stack<>();
		
		String num = "";
		for(int i = 0; i < expressao.length(); i++) {
			String letra = Character.toString(expressao.charAt(i));
			if(!letra.equals(")")) {
				empilha.push(letra);
			} else {
				while(!empilha.peek().equals("(")) {
					desempilha.push(empilha.pop());
				}
				empilha.pop();
				num = resolveCalculo(desempilha);
				empilha.push(num);
			}
		}
		
		if(empilha.size() > 1) {
			while(!empilha.isEmpty()) {
				desempilha.push(empilha.pop());
			}
			num = resolveCalculo(desempilha);
		}
		
		return num;
	}

	private static String resolveCalculo(Stack<String> desempilha) {
		int out = 0;
		while(!(desempilha.size() == 1)) {
			int valor1 = Integer.parseInt(desempilha.pop());
			String caractere = desempilha.pop();
			int valor2 = Integer.parseInt(desempilha.pop());
			
			if(caractere.equals("+")) {
				out = valor1 + valor2;
				
			} else if(caractere.equals("-")) {
				out = valor1 - valor2;
				
			} else if(caractere.equals("*")) {
				out = valor1 * valor2;
				
			} else if(caractere.equals("/")) {
				out = valor1 / valor2;
				
			}
			
			desempilha.push(Integer.toString(out));
		}
		
		desempilha.pop();
		return Integer.toString(out);
	}

}
