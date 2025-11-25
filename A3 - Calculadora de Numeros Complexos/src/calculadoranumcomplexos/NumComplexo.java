package calculadoranumcomplexos;

public class NumComplexo {
	private double imaginario;
	private double real;
	
	public double getImaginario() {
		return imaginario;
	}

	public double getReal() {
		return real;
	}


	NumComplexo(double real, double imaginario){
		this.real = real;
		this.imaginario = imaginario;
	}



	public NumComplexo soma(NumComplexo b) {
		NumComplexo complexoSoma = new NumComplexo(real +  b.real, imaginario + b.imaginario);
		return complexoSoma;
	}

	public NumComplexo subtrair(NumComplexo b) {
		NumComplexo complexoSubtracao =  new NumComplexo(real - b.real, imaginario - b.imaginario);
		return complexoSubtracao;
	}

	public NumComplexo multiplicar(NumComplexo b) {
		double realRes = (this.real * b.real) - (this.imaginario * b.imaginario);
		double imagRes = (this.real * b.imaginario) + (this.imaginario * b.real);
		NumComplexo complexoMultiplicacao = new NumComplexo(realRes, imagRes);
		return complexoMultiplicacao;
	}


	public NumComplexo dividir(NumComplexo b) {
		double denominador = Math.pow(b.real, 2) + Math.pow(b.imaginario, 2);
		
		if(denominador == 0) {
			System.out.println("Error. Divisão por zero!");
		}
		
		double realRes = ((this.real * b.real) + (this.imaginario * b.imaginario)) / denominador;	
		double imagRes = ((this.imaginario * b.real) - (this.real * b.imaginario)) / denominador;
		NumComplexo complexoDivisao = new NumComplexo(realRes, imagRes);
		return complexoDivisao;
	}

	public NumComplexo conjugar() {
		return new NumComplexo(real, -imaginario);
	}


@Override
	public String toString() {
		if(real == 0) { return String.format("%.2f",imaginario);}
		
		if(imaginario == 0) {return String.format("%2.f" , real);}
		
		if(imaginario < 0) {return String.format("%.2f - %.2fi", real, -imaginario);}
		
		return String.format("%.2f + %.2fi" ,real, imaginario);
	}



}
