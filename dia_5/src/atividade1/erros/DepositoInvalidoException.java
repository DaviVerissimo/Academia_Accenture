package atividade1.erros;

public class DepositoInvalidoException extends Exception {
	
	public String getMessage() {
		return "Quantia invalida. Deposito não realizado.";
	}

	public DepositoInvalidoException() {
		super();
	}
	
	

}
