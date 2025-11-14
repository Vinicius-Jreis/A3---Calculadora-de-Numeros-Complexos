package calculadoranumcomplexos;
import java.util.Scanner; 
public class Calculadora {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("===== Calculadora de Números Complexos =====");
		NumComplexo expr1 = new NumComplexo(3, 2);
		NumComplexo expr2 = new NumComplexo(1, -7);
		
		System.out.println("Expressao 1: " + expr1);
		System.out.println("Expressao : 2" + expr2);
		System.out.println("------------------------");
		System.out.println("\nSoma: " + expr1.soma(expr2));
		System.out.println("\nSubtração: " + expr1.subtrair(expr2));
		System.out.println("\nMultiplicação: " + expr1.multiplicar(expr2));
		System.out.println("\nDivisão: " + expr1.dividir(expr2));
		System.out.println("\nExpressão 1 conjugada: " + expr1.conjugar());
		System.out.println("\nExpressão 2 conjugada: " + expr2.conjugar());
	}

}
