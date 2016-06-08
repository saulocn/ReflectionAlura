package br.com.caelum.reflection.mapas;

import java.util.List;
import java.util.Map;

public class Principal {

	public static void main(String[] args) throws Exception {

		// AULA 2

		Mapeador m = new Mapeador();
		m.load("classes.prop");

		System.out.println(m.getImplementacao(List.class));
		System.out.println(m.getImplementacao(Map.class));

		// AULA 3

		List l = m.getInstancia(List.class);
		System.out.println(l.getClass());
		
		// EX 2
//		List l2 = m.getInstancia(List.class, 10);
//		System.out.println(l2.getClass());
		InterfaceExemplo i = m.getInstancia(InterfaceExemplo.class, "teste");
		System.out.println(i.getClass());

	}

}
