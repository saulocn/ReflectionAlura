package br.com.caelum.reflection.erros;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Principal {
	public static void main(String[] args) throws Exception {
		TesteErros obj = new TesteErros();
		Class clazz = obj.getClass();

		// clazz.getMethod("metodo");
		try {
			Method m = clazz.getDeclaredMethod("metodo", String.class);
			// m.invoke(obj);
			// m.invoke(obj, 23);
			//m.setAccessible(true);
			m.invoke(obj, "teste");
		} catch (InvocationTargetException ex){
			ex.getTargetException().printStackTrace();
		}

	}

}
