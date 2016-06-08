package br.com.caelum.reflection.fields;

import java.util.Map;

public class Principal {

	public static void main(String[] args) throws Exception {
		Usuario u = new Usuario();

		u.setLogin("Saulo");
		u.setSenha("123");
		u.setEmail("saulocn@gmail.com");
		u.setPapel("Aluno");
		u.setAtivo(true);

		//String xml = GeradorXML.geraXML(u);
		//System.out.println(xml);
		
		Map<?, ?> s = Exercicio.getFieldMap(u);
		System.out.println(s.get("email"));
		

	}

}
