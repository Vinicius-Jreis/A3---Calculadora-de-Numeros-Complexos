package calculadoranumcomplexos;

public class ArvoreNo {
	private String numero;
	private String operador;
	private ArvoreNo left, right;

	
	ArvoreNo(String numero){
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

	
	public String getNumero() {
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
	
	

	 public String toLISP() {
		 if(left == null && right == null) {
			 return numero;
		 }
		 
		 if(right == null) {
			 return "(" + operador + " " + left.toLISP() + ")";
		 }
		 
	     return "(" + operador + " " + left.toLISP() + " " + right.toLISP() + ")";
	 }

}
