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
            System.out.println("3) Comparar duas expressões");
            System.out.println("4) Sair");
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
                    System.out.println("\n===== VERIFICAR IGUALDADE ENTRE EXPRESSÕES =====");

                    try {
                        
                        System.out.print("\nDigite a PRIMEIRA expressão → ");
                        String exp1 = sc.nextLine().trim();

                        ConstrutorArvore construtor1 = new ConstrutorArvore();
                        ArvoreNo raiz1 = construtor1.construir(exp1);

                        AvaliadorArvore avaliador1 = new AvaliadorArvore();
                        NumComplexo r1 = avaliador1.avaliar(raiz1, sc);

                        
                        System.out.print("\nDigite a SEGUNDA expressão → ");
                        String exp2 = sc.nextLine().trim();

                        ConstrutorArvore construtor2 = new ConstrutorArvore();
                        ArvoreNo raiz2 = construtor2.construir(exp2);

                        AvaliadorArvore avaliador2 = new AvaliadorArvore();
                        NumComplexo r2 = avaliador2.avaliar(raiz2, sc);

                        
                        System.out.println("\n========= EXPRESSÃO 1 =========");
                        System.out.println("Resultado: " + r1);

                        System.out.println("\n========= EXPRESSÃO 2 =========");
                        System.out.println("Resultado: " + r2);

                        
                        boolean igualdade = r1.toString().equals(r2.toString());


                        System.out.println("\n========= COMPARAÇÃO =========");
                        if (igualdade) {
                            System.out.println("As duas expressões são **IGUAIS** numericamente!");
                        } else {
                            System.out.println("As duas expressões **NÃO SÃO IGUAIS** \n\n");
                        }

                    } catch (Exception e) {
                        System.out.println("\nErro ao comparar expressões: " + e.getMessage() + "\n");
                    }

                    break;
                    
                case "4":
                    System.out.println("\nEncerrando a calculadora [...]");
                    sc.close();
                    return;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.\n");
            }
        }
		
	}
}
