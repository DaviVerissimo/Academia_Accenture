package dia_2;

import java.util.Scanner;

public class Atividade4 {
	public static void main(String[] args) {
		// implementada parcialmente sem a validação
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite a coordenada X para cavalo (posisão inicial ex 5)");
		int coordenadaInicialCavaloX = leitor.nextInt();
		System.out.println("Digite a coordenada y para cavalo (posisão inicial ex 5)");
		int coordenadaInicialCavaloY = leitor.nextInt();
		System.out.println("Digite a coordenada X para cavalo (posisão final ex 6)");
		int coordenadaFinalCavaloX = leitor.nextInt();
		System.out.println("Digite a coordenada Y para cavalo (posisão final ex 6)");
		int coordenadaFinalCavaloY = leitor.nextInt();
		
		System.out.println("Digite a coordenada X para peão (posisão inicial ex 4)");
		int coordenadaInicialPeaoX = leitor.nextInt();
		System.out.println("Digite a coordenada y para peão (posisão inicial ex 2)");
		int coordenadaInicialPeaoY = leitor.nextInt();
		System.out.println("Digite a coordenada X para peão (posisão final ex 6)");
		int coordenadaFinalPeaoX = leitor.nextInt();
		System.out.println("Digite a coordenada Y para cavalo (posisão final ex 2)");
		int coordenadaFinalPeaoY = leitor.nextInt();
		
		String[][] board = { 
				{"R","N","B","Q","K","B","N","R"},
				{"P","P","P","P","P","P","P","P"},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},
				{"p","p","p","p","p","p","p","p"},
				{"r","n","b","q","k","b","n","r"}};

		 for (int i = 0; i < board.length; i++) {
		        for (int j = 0; j < board[i].length; j++) {
		        	System.out.print(board[i][j]+"  ");
		        }
		        System.out.println("");
		    }
		 
		 //Mover Cavalo
		 System.out.println("");
		 board[coordenadaInicialCavaloX][coordenadaInicialCavaloY] = board[coordenadaFinalCavaloX][coordenadaFinalCavaloY];
		 board[coordenadaFinalCavaloX][coordenadaFinalCavaloY] = "";

		 for (int i = 0; i < board.length; i++) {
		        for (int j = 0; j < board[i].length; j++) {
		        	System.out.print(board[i][j]+"  ");
		        }
		        System.out.println("");
		    }
		 
		 // Mover Peao
		 System.out.println("");
		 board[coordenadaInicialPeaoX][coordenadaInicialPeaoY] = board[coordenadaFinalPeaoX][coordenadaFinalPeaoY];
		 board[coordenadaFinalPeaoX][coordenadaFinalPeaoY] = " ";
		 
		 for (int i = 0; i < board.length; i++) {
		        for (int j = 0; j < board[i].length; j++) {
		        	System.out.print(board[i][j]+"  ");
		        }
		        System.out.println("");
		    }
		 //imprimirBoard(board);
	}
	
	// --------------Impressão do Tabuleiro---------------------------------------
	public void imprimirBoard(String[][] board) {
		 for (int i = 0; i < board.length; i++) {
		        for (int j = 0; j < board[i].length; j++) {
		        	System.out.print(board[i][j]+"  ");
		        }
		        System.out.println("");
		    }
	}
}