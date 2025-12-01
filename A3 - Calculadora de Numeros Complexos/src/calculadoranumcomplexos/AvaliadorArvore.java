package calculadoranumcomplexos;

import java.util.HashMap;
import java.util.Scanner;

public class AvaliadorArvore {
	private HashMap<String, NumComplexo> variaveis = new HashMap<>();

    public NumComplexo avaliar(ArvoreNo no, Scanner sc) {

      
        if (no.getOperador() == null) {

            String valor = no.getNumero();

            if (valor.equals("i") || valor.equals("+i")) {
                return new NumComplexo(0, 1);
            }
            
            if (valor.equals("-i")) {
                return new NumComplexo(0, -1);
            }
           
            if (Character.isDigit(valor.charAt(0)) || valor.charAt(0) == '.') {
                return converterParaComplexo(valor);
            }
            
            if (!variaveis.containsKey(valor)) {
                System.out.print("Digite o valor para " + valor + " (ex: 3+2i): ");
                variaveis.put(valor, lerComplexo(sc.nextLine()));
            }

            return variaveis.get(valor);
        }

       
        String op = no.getOperador();

        if (op.equals("conj")) {
            NumComplexo unico = avaliar(no.getLeft(), sc);
            return unico.conjugar();
        }

        
        NumComplexo left = avaliar(no.getLeft(), sc);
        NumComplexo right = avaliar(no.getRight(), sc);

        switch (op) {
            case "+": 
            	return left.soma(right);
            case "-": 
            	return left.subtrair(right);
            case "*": 
            	return left.multiplicar(right);
            case "/":
            	if(right.getReal() == 0 && right.getImaginario() == 0) {
            		throw new ArithmeticException("Divisão por zero.");
            	}
            	return left.dividir(right);
            case "^":
            	int expoente = (int) right.getReal();
            	return left.potencia(expoente);
            default:
                throw new RuntimeException("Operador inválido: " + op);
        }
    }

    
    private NumComplexo converterParaComplexo(String s) {

        if (s.endsWith("i")) {
            String numero = s.substring(0, s.length() - 1);
            
            double imag;

            if (numero.isEmpty()) {
                imag = 1;
            } else {
                imag = Double.parseDouble(numero);
            }
            return new NumComplexo(0, imag);
        }

        double real = Double.parseDouble(s);
        return new NumComplexo(real, 0);
    }

   
    private NumComplexo lerComplexo(String s) {
        s = s.replace(" ", "").toLowerCase();

        if (!s.contains("i")) {
            return new NumComplexo(Double.parseDouble(s), 0);
        }

        if (s.equals("i")) {
        	return new NumComplexo(0,1);
        }
        if (s.equals("-i")) {
        	return new NumComplexo(0,-1);
        }

        String[] partes = s.split("i")[0].split("\\+|(?=-)");

        double real = 0;
        double imag = 0;

        for (String p : partes) {
            if (p.contains("i")) {
            	continue;
            }
            if (p.isEmpty()) {
            	continue;
            }
            if (s.indexOf(p + "i") != -1) {
                imag = Double.parseDouble(p);
            } else {
                real = Double.parseDouble(p);
            }
        }

        return new NumComplexo(real, imag);
    }
}
