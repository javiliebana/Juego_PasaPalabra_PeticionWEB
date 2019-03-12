import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class AccesoFichero {

	public static Document generarXML(String dato) {
		String respuesta = "";
		URL url;
		try {
			url = new URL("http://formadorestic.com/pasapalabra/carga.php?entorno=1&IDpartida=" + dato);
			URLConnection conn = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String linea;
			// procesamos al salida
			while ((linea = rd.readLine()) != null) {
				respuesta += linea;
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SAXBuilder builder = new SAXBuilder();
		InputStream stream;
		Document documento = null;
		try {
			stream = new ByteArrayInputStream(respuesta.getBytes("UTF-8"));
			documento = builder.build(stream);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return documento;

	}

	public static ArrayList<Pregunta> datosXML(Document documento) {

		ArrayList<Pregunta> lista_PasaPal = new ArrayList();
		SAXBuilder builder = new SAXBuilder();

		Element element_raiz = documento.getRootElement();
		Element element_contenido = element_raiz.getChild("jugador");
		List<Element> lista_pregrunta = element_contenido.getChildren("pregunta");

		for (Element element_pregunta : lista_pregrunta) {
			String posicion = element_pregunta.getChild("posicion").getValue();
			String letra = element_pregunta.getChild("letra").getValue();
			String definicion = element_pregunta.getChild("definicion").getValue();
			String solucion = element_pregunta.getChild("solucion").getValue();
			Pregunta p1 = new Pregunta(letra, posicion, definicion, solucion);
			lista_PasaPal.add(p1);

		}

		return lista_PasaPal;
	}

}
