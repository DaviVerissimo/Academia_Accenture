package atividade1.erros;

public class EstouroSaqueException extends Exception {

	public String getMessage() {
		return "Saldo insuficiente para saque.";
	}

	public EstouroSaqueException() {
		super();
	}

}
