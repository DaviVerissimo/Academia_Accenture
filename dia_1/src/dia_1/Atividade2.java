package dia_1;

import java.util.Scanner;

public class Atividade2 {
	public static void main(String[] args) {
		System.out.println("Digite um numero.");
		int vetor[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		@SuppressWarnings("resource")
		Scanner leitor = new Scanner(System.in);
		int numero = leitor.nextInt();
		boolean achou = false;

		for (int i = 0; i < 10; i++) {
			if (vetor[i] == numero) {
				achou = true;
			}
			if (achou) {
				System.out.println("Achei");
				System.out.printf("Na Posição %d está localizado o numero %d.", i, vetor[i]);
				break;
			}
		}
		if (!achou) {
			System.out.println("este numero não existe no vetor.");
		}

	}

}
