package dia_1;

import java.util.Scanner;

public class Atividade1 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner leitor = new Scanner(System.in);
		System.out.println("Quantos bilhetes foram vendidos para a classe A? ");
		int numClasseA = leitor.nextInt();
		System.out.println("Quantos bilhetes foram vendidos para a classe B? ");
		int numClasseB = leitor.nextInt();
		System.out.println("Quantos bilhetes foram vendidos para a classe C? ");
		int numClasseC = leitor.nextInt();
		int rendaA = calcularA(numClasseA);
		int rendaB = calcularB(numClasseB);
		int rendaC = calcularC(numClasseC);
		System.out.println("foram obtidos R$ " + rendaA + " com a classe A.");
		System.out.println("foram obtidos R$ " + rendaB + " com a classe B.");
		System.out.println("foram obtidos R$ " + rendaC + " com a classe C.");
		int rendaTotal = rendaA + rendaB + rendaC;
		System.out.println("foram obtidos R$ " + rendaTotal + " no total.");
	}

	public static int calcularA(int numClasseA) {
		
		return numClasseA * 50;
	}
	
	private static int calcularB(int numClasseB) {
		
		return numClasseB * 30;
	}
	
	private static int calcularC(int numClasseC) {
		
		return numClasseC * 20;
	}

}
