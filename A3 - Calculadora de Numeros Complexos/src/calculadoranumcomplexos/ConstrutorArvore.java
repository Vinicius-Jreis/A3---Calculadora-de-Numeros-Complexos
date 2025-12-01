package calculadoranumcomplexos;
import java.util.Stack;

public class ConstrutorArvore {
	
	 private boolean Operador(char ch) {
	        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
	    }

	    
	    private int prioridade(char op) {
	        if (op == '+' || op == '-') {
	        	return 1;
	        }
	        if (op == '*' || op == '/') {
	        	return 2;
	        }
	        if(op == '^') {
	        	return 3;
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

	            if (expressao.startsWith("conj", i)) {
	                operacoes.push('~'); 
	                i += 3; 
	                continue;
	            }
	            
	            
	            if (c == '(') {
	                operacoes.push(c);
	            }

	            
	            if (Character.isDigit(c) || Character.isLetter(c) || c == '.' || c == 'i') {
	                numero += c;
	            }

	            
	            if (!numero.isEmpty() && Operador(c)) {
	                valores.push(new ArvoreNo(numero));
	                numero = "";
	            }

	            
	            if (c == ')') {
	                if (!numero.isEmpty()) {
	                    valores.push(new ArvoreNo(numero));
	                    numero = "";
	                }

	                
	                while (!operacoes.isEmpty() && operacoes.peek() != '(' && operacoes.peek() != '~') {
	                    createSubArvore(valores, operacoes.pop());
	                }
	                
	                
	                if(operacoes.isEmpty()) {
	                	throw new RuntimeException("Parêntese ')' sem '(' correspondente");
	                }
	                
	                
	                if (!operacoes.isEmpty() && operacoes.peek() == '(') {
	                    operacoes.pop();
	                }
	                
	                if (!operacoes.isEmpty() && operacoes.peek() == '~') {
	                    operacoes.pop();
	                    ArvoreNo unico = valores.pop();
	                    valores.push(new ArvoreNo("conj", unico, null));
	                }
	               
	            }

	            
	            if (Operador(c)) {

	               if(numero.isEmpty() && valores.isEmpty()) {
	            	   throw new RuntimeException("Operador " + c + " sem operando antes.");
	               }
	            	
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
	        	char op = operacoes.pop();

	            if (op == '~') { 
	                ArvoreNo unico = valores.pop();
	                valores.push(new ArvoreNo("conj", unico, null));
	            } else {
	                createSubArvore(valores, op);
	            }
	        }

	        return valores.pop();
	    }

	    private void createSubArvore(Stack<ArvoreNo> valores, char operador) {
	        ArvoreNo right = valores.pop();
	        ArvoreNo left = valores.pop();
	        valores.push(new ArvoreNo(String.valueOf(operador), left, right));
	    }
}
