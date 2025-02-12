package at6.classes;

public class TesteFormas {
	
	public static void main(String[] args) {
		Forma circulo = new Circulo(2.4);
		Forma quadrado = new Retangulo(2.4, 2.4);
		Forma triangulo = new Triangulo(2.4, 2.4);
		
		System.out.println(circulo.calcularArea());
		System.out.println(quadrado.calcularArea());
		System.out.println(triangulo.calcularArea());
		
	}
	
}
