package calculadoranumcomplexos;
import java.util.Stack;

public class ConstrutorArvore {
	
	private boolean isOperador(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    
    private int prioridade(char op) {
        if (op == '+' || op == '-') {
        	return 1;
        }
        if (op == '*' || op == '/') {
        	return 2;
        }
        return 0;
    }


    public ArvoreNo construir(String expressao) {

        Stack<ArvoreNo> valores = new Stack<>();
        Stack<Character> operacoes = new Stack<>();

        String numero = "";

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == ' ') {
            	continue;
            }

            
            if (c == '(') {
                operacoes.push(c);
            }

            
            if (Character.isDigit(c) || c == '.' || c == 'i') {
                numero += c;
            }

            
            if (!numero.isEmpty() && isOperador(c)) {
                valores.push(new ArvoreNo(numero));
                numero = "";
            }

            
            if (c == ')') {
                if (!numero.isEmpty()) {
                    valores.push(new ArvoreNo(numero));
                    numero = "";
                }

                while (!operacoes.isEmpty() && operacoes.peek() != '(') {
                    createSubArvore(valores, operacoes.pop());
                }
                operacoes.pop(); 
            }

            
            if (isOperador(c)) {

               
                if (!numero.isEmpty()) {
                    valores.push(new ArvoreNo(numero));
                    numero = "";
                }

                
                while (!operacoes.isEmpty() &&
                       prioridade(operacoes.peek()) >= prioridade(c)) {

                    createSubArvore(valores, operacoes.pop());
                }

                operacoes.push(c);
            }
        }

      
        if (!numero.isEmpty()) {
            valores.push(new ArvoreNo(numero));
        }

        
        while (!operacoes.isEmpty()) {
            createSubArvore(valores, operacoes.pop());
        }

        return valores.pop();
    }

    private void createSubArvore(Stack<ArvoreNo> valores, char operador) {
        ArvoreNo right = valores.pop();
        ArvoreNo left = valores.pop();
        valores.push(new ArvoreNo(String.valueOf(operador), left, right));
    }
}
