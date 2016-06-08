package br.com.caelum.reflection.validador;

import java.lang.reflect.Method;

public class Validador {
	public static Boolean validarObjeto(Object obj) throws Exception {
		Boolean resultado = true;

		Class clazz = obj.getClass();

		for (Method metodo : clazz.getMethods()) {
			if (metodo.getName().startsWith("validar") && metodo.getReturnType() == Boolean.class
					&& metodo.getReturnType() != void.class && metodo.getParameterTypes().length == 0) {
				Boolean retorno = (Boolean) metodo.invoke(obj);
				resultado = resultado && retorno.booleanValue();
			}
		}

		return resultado;
	}


}
