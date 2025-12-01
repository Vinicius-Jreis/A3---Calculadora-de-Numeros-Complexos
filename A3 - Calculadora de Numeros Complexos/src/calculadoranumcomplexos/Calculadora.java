package calculadoranumcomplexos;
import java.util.Scanner; 
public class Calculadora {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("========================================");
            System.out.println("      CALCULADORA DE NÚMEROS COMPLEXOS ");
            System.out.println("========================================");
            System.out.println("1) Digitar expressão");
            System.out.println("2) Exemplos");
            System.out.println("3) Sair");
            System.out.print("Escolha uma opção → ");
            String opcao = sc.nextLine().trim();

            switch (opcao) {
                case "1":
                    System.out.print("\nDigite a expressão → ");
                    String expressao = sc.nextLine().trim();

                    if (expressao.isEmpty()) {
                        System.out.println("Erro: expressão vazia.\n");
                        break;
                    }

                    try {
                        ConstrutorArvore construtor = new ConstrutorArvore();
                        ArvoreNo raiz = construtor.construir(expressao);
                        AvaliadorArvore avaliador = new AvaliadorArvore();

                        while (true) {
	                        System.out.println("\nO que deseja ver?");
	                        System.out.println("1) Árvore LISP");
	                        System.out.println("2) Resultado");
	                        System.out.println("3) Ambos");
	                        System.out.println("4) Voltar");
	                        System.out.print("Escolha → ");
	
	                        String escolha = sc.nextLine().trim();
	
	                        if (escolha.equals("1")) {
	                            System.out.println("\n========= ÁRVORE LISP =========");
	                            System.out.println(raiz.toLISP());
	                            System.out.println("================================");
	                        }
	                        else if (escolha.equals("2")) {
	                            NumComplexo resultado = avaliador.avaliar(raiz, sc);
	                            System.out.println("\n========= RESULTADO ===========");
	                            System.out.println(resultado);
	                            System.out.println("================================");
	                        }
	                        else if (escolha.equals("3")) {
	                            System.out.println("\n========= ÁRVORE LISP =========");
	                            System.out.println(raiz.toLISP());
	                            System.out.println("================================");
	
	                            NumComplexo resultado = avaliador.avaliar(raiz, sc);
	                            System.out.println("\n========= RESULTADO ===========");
	                            System.out.println(resultado);
	                            System.out.println("================================");
	                        }
	                     
	                        else if (escolha.equals("4")) {
	                            System.out.println();
	                            break;
	                        }
	                        else {
	                            System.out.println("Opção inválida!\n");
	                        }
                        }
                    } catch (Exception e) {
                    	System.out.println("\nErro: " + e.getMessage() + "\n");
	                }

                    break;

               
                case "2":
                    System.out.println("\n===== EXEMPLOS DE EXPRESSÕES ACEITAS =====");
                    System.out.println("\n (2+3i) + (3-5i) \n");
                    System.out.println(" (2+3i) - (3+5i) \n");
                    System.out.println(" (2+3i) * (3-5i) \n");
                    System.out.println(" (2+3i) / (3-5i) \n");
                    System.out.println(" conj(2+3i) \n");
                    System.out.println(" (2+i)^3 \n");
                    System.out.println(" (a + 2i) * 3\n\n");
                    break;

               
                case "3":
                    System.out.println("\nEncerrando a calculadora [...]");
                    sc.close();
                    return;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.\n");
            }
        }
		
	}
}
