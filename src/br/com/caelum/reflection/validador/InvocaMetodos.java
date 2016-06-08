package br.com.caelum.reflection.validador;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvocaMetodos {
	public static void invocaTest(Object obj) throws Exception {
		Class clazz = obj.getClass();

		for (Method metodo : clazz.getMethods()) {
			if (metodo.getName().startsWith("test") && metodo.getReturnType() == void.class
					&& metodo.getParameterTypes().length == 0) {
				try {
					metodo.invoke(obj);
				} catch (InvocationTargetException ex) {
					ex.getTargetException().printStackTrace();
				}
			}
		}
	}
	
	public static void chamarTestes(Object obj) throws Throwable{

	    Class<?> clazz = obj.getClass();

	    for(Method m : clazz.getMethods()){
	        if(m.getName().startsWith("test") && 
	                m.getReturnType() == void.class &&
	                m.getParameterTypes().length == 0){
	            try{
	                m.invoke(obj);
	            }catch(InvocationTargetException ex){
	                throw ex.getTargetException();
	            }  
	        }
	    }
	}
}
