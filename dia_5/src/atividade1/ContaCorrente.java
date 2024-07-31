package atividade1;

import java.time.LocalDateTime;

import atividade1.erros.DepositoInvalidoException;
import atividade1.erros.EstouroSaqueException;

public class ContaCorrente extends ContaBancaria {

	private double taxaDeOperacao;

	public double getTaxaDeOperacao() {
		return taxaDeOperacao;
	}

	public void setTaxaDeOperacao(double taxaDeOperacao) {
		this.taxaDeOperacao = taxaDeOperacao;
	}

	public ContaCorrente(long numero, Cliente cliente, double saldo, LocalDateTime data) {
		super(numero, cliente, saldo, data);
	}

	@Override
	public void depositar(double deposito) throws DepositoInvalidoException {
		if (deposito > 0) {
			setSaldo(super.getSaldo() + deposito);
		}

		else {
			throw new DepositoInvalidoException();
		}
	}

	@Override
	public double sacar(double saque) throws EstouroSaqueException {
		double novoSaldo = (super.getSaldo() - saque) - taxaDeOperacao;
		if (novoSaldo > 0) {
			setSaldo(novoSaldo);
			return saque;
		} else if (saque > super.getSaldo()) {
			throw new EstouroSaqueException();
		}
		return 0;
	}

	@Override
	public String exibirDetalhes() {
		String extrato = super.getData() + "\n" + "Cliente: " + super.getCliente().getNome() + " "
				+ super.getCliente().getSobrenome() + "\n" + "CPF: " + super.getCliente().getCpf() + "\n"
				+ "Numero da conta: " + super.getNumero() + "\n" + "taxa de operação: " + taxaDeOperacao
				+ super.getNumero() + "\n" + "Saldo: " + super.getSaldo();

		return extrato;

	}

	@Override
	public double trasferir(double transferencia) {
		double novoSaldo = super.getSaldo() - transferencia;
		if (novoSaldo > 0) {
			super.setSaldo(novoSaldo);
			return transferencia;
		}

		return 0;
	}

	public ContaCorrente(long numero, Cliente cliente, double saldo, LocalDateTime data, double taxaDeOperacao) {
		super(numero, cliente, saldo, data);
		this.taxaDeOperacao = taxaDeOperacao;
	}

}
