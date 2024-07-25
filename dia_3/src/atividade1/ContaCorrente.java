package atividade1;

import java.time.LocalDateTime;

public class ContaCorrente {
	private long numero;
	private Cliente cliente;
	private double saldo;
	private LocalDateTime data;

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public ContaCorrente(long numero, Cliente cliente, double saldo, LocalDateTime data) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
		this.data = data;
	}

	public void depositar(double deposito) {
		setSaldo(saldo + deposito);
	}

	public double sacar(double saque) {
		double novoSaldo = saldo - saque;
		if (novoSaldo > 0) {
			setSaldo(novoSaldo);
			return saque;
		}
		return 0;
	}

	public String exibirEstrato() {
		String extrato = data + "\n" + "Cliente: " + cliente.getNome() + " " + cliente.getSobrenome() + "\n" + "CPF: "
				+ cliente.getCpf() + "\n" + "Numero da conta: " + numero + "\n" + "Saldo: " + saldo;

		return extrato;

	}

	public double trasferir(double transferencia) {
		double novoSaldo = saldo - transferencia;
		if (novoSaldo > 0) {
			setSaldo(novoSaldo);
			return transferencia;
		}
		
		return 0;
	}

}
