package dia_2;

import java.util.Scanner;

public class Atividade3 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String[][] tabuleiro = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
        };
        String jogadorAtual = "X";
        boolean vencedor = false;

        while (!vencedor && !tabuleiroCheio(tabuleiro)) {
            imprimirTabuleiro(tabuleiro);

            System.out.println("Jogador " + jogadorAtual + ", é sua vez!");
            System.out.print("Escolha a linha (0, 1, 2): ");
            int linha = leitor.nextInt();
            System.out.print("Escolha a coluna (0, 1, 2): ");
            int coluna = leitor.nextInt();

            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna].equals(" ")) {
                tabuleiro[linha][coluna] = jogadorAtual;
                vencedor = verificarVencedor(tabuleiro, jogadorAtual);
                jogadorAtual = jogadorAtual.equals("X") ? "O" : "X"; 
            } else {
                System.out.println("Jogada inválida! Tente novamente.");
            }
        }

        imprimirTabuleiro(tabuleiro);
        if (vencedor) {
            System.out.println("Parabéns, jogador " + (jogadorAtual.equals("X") ? "O" : "X") + "! Você venceu!");
        } else {
            System.out.println("O jogo empatou!");
        }

        leitor.close();
    }

    public static void imprimirTabuleiro(String[][] tabuleiro) {
        System.out.print("\n\n 0   1   2\n\n");
        for (int posicao1 = 0; posicao1 < 3; posicao1++) {
            for (int posicao2 = 0; posicao2 < 3; posicao2++) {
                System.out.print(" " + tabuleiro[posicao1][posicao2]);
                if (posicao2 < 2) {
                    System.out.print(" |");
                }
                if (posicao2 == 2) {
                    System.out.print("  " + posicao1);
                }
            }
            if (posicao1 < 2) {
                System.out.print("\n-----------");
            }
            System.out.println("\n");
        }
    }

    public static boolean tabuleiroCheio(String[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean verificarVencedor(String[][] tabuleiro, String jogador) {
        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0].equals(jogador) && tabuleiro[i][1].equals(jogador) && tabuleiro[i][2].equals(jogador)) {
                return true;
            }
        }
        // Verificar colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i].equals(jogador) && tabuleiro[1][i].equals(jogador) && tabuleiro[2][i].equals(jogador)) {
                return true;
            }
        }
        // Verificar diagonais
        if (tabuleiro[0][0].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[2][2].equals(jogador)) {
            return true;
        }
        if (tabuleiro[0][2].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[2][0].equals(jogador)) {
            return true;
        }
        return false;
    }
}
