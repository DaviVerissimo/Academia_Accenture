package atividade1;

import java.time.LocalDateTime;

import atividade1.erros.DepositoInvalidoException;
import atividade1.erros.EstouroSaqueException;

public abstract class ContaBancaria {

	private long numero;
	private Cliente cliente;
	private double saldo;
	private LocalDateTime data;

	public ContaBancaria(long numero, Cliente cliente, double saldo, LocalDateTime data) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
		this.data = data;
	}

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

	public abstract void depositar(double deposito) throws DepositoInvalidoException;

	public abstract double sacar(double saque) throws EstouroSaqueException;

	public abstract String exibirDetalhes();

	public abstract double trasferir(double transferencia);

}
