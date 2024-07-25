package atividade4;

import javax.swing.JOptionPane;

public class Circulo {

	private double raio;

	private double area;

	private double perimetro;

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}

	public Circulo() {

	}

	public Circulo(double base) {
		this.raio = base;
	}

	public void calcularArea() {
		setArea(3.14 * raio);
	}

	public void calcularPerimetro() {
		setPerimetro(2 * 3.14 * raio);
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 6; i++) {
			double novaRaio = Integer.parseInt(JOptionPane.showInputDialog("Digite o raio:"));

			Circulo novoCirculo = new Circulo(novaRaio);

			novoCirculo.calcularArea();
			String mensagemArea = "A area do circulo é : " + novoCirculo.getArea();
			JOptionPane.showMessageDialog(null, mensagemArea);

			novoCirculo.calcularPerimetro();
			String mensagemPerimetro = "O perimetro do circulo é : " + novoCirculo.getPerimetro();
			JOptionPane.showMessageDialog(null, mensagemPerimetro);
		}

	}

}
