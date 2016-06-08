package br.com.caelum.reflection.fields;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Exercicio {

	public static Map<String,Object> getFieldMap(Object obj) throws Exception{
        Map<String,Object> map = new HashMap<>();
        Class<?> c = obj.getClass();
        for(Field f : c.getDeclaredFields()){
            f.setAccessible(true);
            map.put(f.getName(), f.get(obj));
        }
        return map;
    }
}
