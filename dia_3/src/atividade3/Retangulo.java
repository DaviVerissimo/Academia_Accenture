package atividade3;

import javax.swing.JOptionPane;

public class Retangulo {

	private double base;

	private double altura;

	private double area;

	private double perimetro;

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
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

	public Retangulo() {

	}

	public Retangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	public void calcularArea() {
		setArea(altura * base);
	}

	public void calcularPerimetro() {
		setPerimetro((2 * base) + (2 * altura));
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 6; i++) {
			double novaBase = Integer.parseInt(JOptionPane.showInputDialog("Digite a base:"));
			double novaAltura = Integer.parseInt(JOptionPane.showInputDialog("Digite a altura:"));

			Retangulo novoRetangulo = new Retangulo(novaBase, novaAltura);

			novoRetangulo.calcularArea();
			String mensagemArea = "A area do retangulo é : " + novoRetangulo.getArea();
			JOptionPane.showMessageDialog(null, mensagemArea);

			novoRetangulo.calcularPerimetro();
			String mensagemPerimetro = "O perimetro do retangulo é : " + novoRetangulo.getPerimetro();
			JOptionPane.showMessageDialog(null, mensagemPerimetro);
		}

	}

}
