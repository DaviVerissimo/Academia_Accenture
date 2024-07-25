package atividade1;

import java.time.LocalDateTime;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class PrincipalContaCorrente {

    public static void main(String[] args) {
        
        // Cadastro dos clientes
        String nome1 = JOptionPane.showInputDialog("Digite o nome para cadastrar 1º cliente:");
        String sobrenome1 = JOptionPane.showInputDialog("Digite o sobrenome do 1º cliente:");
        String cpf1 = JOptionPane.showInputDialog("Digite o CPF do 1º cliente:");
        Cliente cliente1 = new Cliente(nome1, sobrenome1, cpf1);
        JOptionPane.showMessageDialog(null, "Cliente " + cliente1.getNome() + " foi cadastrado com sucesso!");

        String nome2 = JOptionPane.showInputDialog("Digite o nome para cadastrar 2º cliente:");
        String sobrenome2 = JOptionPane.showInputDialog("Digite o sobrenome do 2º cliente:");
        String cpf2 = JOptionPane.showInputDialog("Digite o CPF do 2º cliente:");
        Cliente cliente2 = new Cliente(nome2, sobrenome2, cpf2);
        JOptionPane.showMessageDialog(null, "Cliente " + cliente2.getNome() + " foi cadastrado com sucesso!");

        // Criação das contas
        ContaCorrente conta1 = new ContaCorrente(1, cliente1, 0.0, LocalDateTime.now());
        ContaCorrente conta2 = new ContaCorrente(2, cliente2, 0.0, LocalDateTime.now());

        // Definindo os valores para os JComboBox
        String[] listaDeClientes = {cliente1.getNome(), cliente2.getNome()};
        String[] listaDeOperacoes = {"Depositar", "Sacar", "Transferir", "Gerar extrato", "Voltar"};

        // Loop para seleção de clientes e operações
        while (true) {
            // Seleção do cliente
            JComboBox<String> comboBoxClientes = new JComboBox<>(listaDeClientes);
            int clienteEscolhido = JOptionPane.showConfirmDialog(null, comboBoxClientes, "Escolha um cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (clienteEscolhido == JOptionPane.CANCEL_OPTION) {
                break;
            }

            ContaCorrente contaSelecionada;
            if (comboBoxClientes.getSelectedItem().equals(cliente1.getNome())) {
                contaSelecionada = conta1;
            } else {
                contaSelecionada = conta2;
            }

            // Loop para seleção de operações
            while (true) {
                JComboBox<String> comboBoxOperacoes = new JComboBox<>(listaDeOperacoes);
                int operacaoEscolhida = JOptionPane.showConfirmDialog(null, comboBoxOperacoes, "Escolha uma operação", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (operacaoEscolhida == JOptionPane.CANCEL_OPTION || comboBoxOperacoes.getSelectedItem().equals("Voltar")) {
                    break;
                }

                String operacao = (String) comboBoxOperacoes.getSelectedItem();

                switch (operacao) {
                    case "Depositar":
                        String valorDepositoStr = JOptionPane.showInputDialog("Digite o valor do depósito:");
                        double valorDeposito = Double.parseDouble(valorDepositoStr);
                        contaSelecionada.depositar(valorDeposito);
                        JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso! Novo saldo: " + contaSelecionada.getSaldo());
                        break;
                    case "Sacar":
                        String valorSaqueStr = JOptionPane.showInputDialog("Digite o valor do saque:");
                        double valorSaque = Double.parseDouble(valorSaqueStr);
                        double saqueRealizado = contaSelecionada.sacar(valorSaque);
                        if (saqueRealizado > 0) {
                            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso! Novo saldo: " + contaSelecionada.getSaldo());
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente para saque.");
                        }
                        break;
                    case "Transferir":
                        String valorTransferenciaStr = JOptionPane.showInputDialog("Digite o valor da transferência:");
                        double valorTransferencia = Double.parseDouble(valorTransferenciaStr);
                        ContaCorrente contaDestino = contaSelecionada == conta1 ? conta2 : conta1;
                        double transferenciaRealizada = contaSelecionada.trasferir(valorTransferencia);
                        if (transferenciaRealizada > 0) {
                            contaDestino.depositar(transferenciaRealizada);
                            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso! Novo saldo: " + contaSelecionada.getSaldo());
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente para transferência.");
                        }
                        break;
                    case "Gerar extrato":
                        String extrato = contaSelecionada.exibirEstrato();
                        JOptionPane.showMessageDialog(null, "Extrato:\n" + extrato);
                        break;
                }
            }
        }
    }
}
