package br.com.caelum.reflection.mapas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MapaDeClasses {

	private Map<Class<?>, Class<?>> mapa = new HashMap<>();

	private Map<String, String> mapaString = new HashMap<>();

	public void load(String nomeDoArquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
		Properties p = new Properties();
		p.load(new FileInputStream(nomeDoArquivo));
		for (Object key : p.keySet()) {
			Class<?> interf = Class.forName(key.toString());
			Class<?> impl = Class.forName(p.get(key).toString());
			if (!interf.isInterface()) {
				throw new RuntimeException("O tipo " + interf.getName() + " não é uma interface!");
			}
			if (!interf.isAssignableFrom(impl)) {
				throw new RuntimeException(
						"A classe " + interf.getName() + " não implementa a classe " + impl.getName() + "!");
			}
			mapa.put(interf, impl);
		}

	}

	public Class<?> getImplementacao(Class<?> interf) {
		return mapa.get(interf);
	}

	public Class<?> getClass(String chave) throws Exception {
		String valor = mapaString.get(chave);
		if (valor != null) {
			return Class.forName(valor);
		} else {
			throw new RuntimeException("Chave inválida");
		}
	}

	public Object getInstancia(Class<?> interf) throws InstantiationException, IllegalAccessException {
		Class<?> impl = mapa.get(interf);
		return impl.newInstance();
	}

	public Object getObject(String s) throws Exception {
		return getClass(s).newInstance();
	}
	
	public Object getObject(String s , Object[] params) throws Exception {
		Class<?> impl = getClass(s);
		Class<?>[] tiposConstrutor = new Class<?>[params.length];
		for (int i = 0; i < tiposConstrutor.length; i++) {
			tiposConstrutor[i] = params[i].getClass();
		}
		Constructor<?> c = impl.getConstructor(tiposConstrutor);
		return c.newInstance(params);
	}
}
