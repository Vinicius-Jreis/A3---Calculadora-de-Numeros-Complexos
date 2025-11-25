package calculadoranumcomplexos;
import java.util.Scanner; 
public class Calculadora {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("===== Calculadora de Números Complexos =====");
		
		System.out.println("Digite a expressão: ");
		System.out.println("Exemplo: (2 + i) + (3 + 2i)");
	    String expr = sc.nextLine();

	    ConstrutorArvore construtor = new ConstrutorArvore();
	    ArvoreNo raiz = construtor.construir(expr);
	    System.out.println("Árvore LISP: " + raiz.toLISP());

	    sc.close();
		
	}
}
