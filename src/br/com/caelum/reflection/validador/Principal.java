package br.com.caelum.reflection.validador;

public class Principal {
	public static void main(String[] args) throws Exception {
		Usuario u = new Usuario();
		u.setEmail("Sem Arroba.com");
		u.setSenha("temMaisQueOito");
		u.setLogin("LoginValido");

		Boolean valido = Validador.validarObjeto(u);
		if (valido) {
			System.out.println("Objeto Válido!");
		} else {
			System.out.println("Objeto Inválido!");
		}

		Usuario u2 = new Usuario();
		u2.setEmail("Com @Arroba.com");
		u2.setSenha("menosq8");
		u2.setLogin("LoginValido");

		Boolean valido2 = Validador.validarObjeto(u2);
		if (valido2) {
			System.out.println("Objeto Válido!");
		} else {
			System.out.println("Objeto Inválido!");
		}

		Usuario u3 = new Usuario();
		u3.setEmail("Com @Arroba.com");
		u3.setSenha("Maior que oito caracteres");
		u3.setLogin("LoginVal");

		Boolean valido3 = Validador.validarObjeto(u3);
		if (valido3) {
			System.out.println("Objeto Válido!");
		} else {
			System.out.println("Objeto Inválido!");
		}

		Usuario u4 = new Usuario();
		u4.setEmail("Com @Arroba.com");
		u4.setSenha("temMaisQueOito");
		u4.setLogin("Login Muito Grande");

		Boolean valido4 = Validador.validarObjeto(u4);
		if (valido4) {
			System.out.println("Objeto Válido!");
		} else {
			System.out.println("Objeto Inválido!");
		}

	}

}
