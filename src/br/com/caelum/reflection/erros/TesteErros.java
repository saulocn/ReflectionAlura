package br.com.caelum.reflection.erros;

public class TesteErros {

	public void metodo(String s) {
		System.out.println(s);
		throw new RuntimeException();
	}

}
