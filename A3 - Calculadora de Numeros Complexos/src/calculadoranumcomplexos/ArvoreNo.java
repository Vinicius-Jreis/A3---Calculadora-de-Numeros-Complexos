package calculadoranumcomplexos;

public class ArvoreNo {
	private double numero;
	private String operador;
	private ArvoreNo left, right;

	
	ArvoreNo(double numero){
		this.numero = numero;	
		this.left = null;
		this.right = null;
		this.operador = null;
	}
	
	ArvoreNo(String operador, ArvoreNo left, ArvoreNo right){
		this.operador = operador;
		this.left = left;
		this.right = right;
	}

	
	public double getNumero() {
		return numero;
	}
	
	
	public String getOperador() {
		return operador;
	}
	
	
	public ArvoreNo getLeft() {
		return left;
	}
	
	
	public ArvoreNo getRight() {
		return right;
	}
	
	

	 @Override
	    public String toString() {	 
	        return "(" + operador + " " + left.toString() + " " + right.toString() + ")";
	    }

}
