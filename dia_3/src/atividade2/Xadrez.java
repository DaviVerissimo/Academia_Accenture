package atividade2;

import javax.swing.JOptionPane;

public class Xadrez {
	public static void main(String[] args) {
		
		int coordenadaInicialCavaloX = Integer.parseInt(JOptionPane.showInputDialog(
				"Digite a coordenada X para cavalo (posisão inicial ex 5)" ));
		
		int coordenadaInicialCavaloY = Integer.parseInt(JOptionPane.showInputDialog(
				"Digite a coordenada y para cavalo (posisão inicial ex 5)" ));
		
		int coordenadaFinalCavaloX = Integer.parseInt(JOptionPane.showInputDialog(
				"Digite a coordenada X para cavalo (posisão final ex 6)" ));
		
		int coordenadaFinalCavaloY = Integer.parseInt(JOptionPane.showInputDialog(
				"Digite a coordenada Y para cavalo (posisão final ex 6)" ));
		
		int coordenadaInicialPeaoX = Integer.parseInt(JOptionPane.showInputDialog(
				"Digite a coordenada X para peão (posisão inicial ex 4)" ));
		
		int coordenadaInicialPeaoY = Integer.parseInt(JOptionPane.showInputDialog(
				"Digite a coordenada y para peão (posisão inicial ex 2)" ));
		
		int coordenadaFinalPeaoX = Integer.parseInt(JOptionPane.showInputDialog(
				"Digite a coordenada X para peão (posisão final ex 6)" ));
		
		int coordenadaFinalPeaoY = Integer.parseInt(JOptionPane.showInputDialog(
				"Digite a coordenada Y para cavalo (posisão final ex 2)" ));
		
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