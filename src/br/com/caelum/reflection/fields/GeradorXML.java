package br.com.caelum.reflection.fields;

import java.lang.reflect.Field;

public class GeradorXML {
	public static String geraXML(Object obj) throws Exception{
		StringBuilder sb = new StringBuilder();
		Class<?> c = obj.getClass();
		sb.append("<"+c.getSimpleName()+"> \n");
		for (Field f : c.getDeclaredFields()) {
			sb.append("    <"+f.getName()+">");
			f.setAccessible(true);
			sb.append(f.get(obj));
			sb.append("</"+f.getName()+"> \n");
			
		}
		sb.append("</"+c.getSimpleName()+"> \n");
		return sb.toString();
	}
}
