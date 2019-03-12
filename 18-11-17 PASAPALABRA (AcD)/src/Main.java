import java.util.ArrayList;
import java.util.Scanner;

import org.jdom2.Document;

public class Main {

	public static void main(String[] args) {
		int valor = 0;
		while (valor != 3) {
			valor = Consola.Opcion();

			int ContadorAciertos = 0;
			if (valor == 1) {
				String numJuego = Consola.pedirNumero();
				Document documento = AccesoFichero.generarXML(numJuego);
				ArrayList<Pregunta> lista_PasaPal = AccesoFichero.datosXML(documento);
				ConexionBD.insertarDatos(lista_PasaPal);
				for (Pregunta pregunta : lista_PasaPal) {
					if (Consola.mostrarPregunta(pregunta)) {
						ContadorAciertos += 1;
						System.out.println("tus puntos son " + ContadorAciertos);

					} else {
						ContadorAciertos -= 1;
						System.out.println("tus puntos son " + ContadorAciertos);
					}

				}

			} else if (valor == 2) {
				String numJuego = Consola.pedirNumero();
				Document documento = AccesoFichero.generarXML(numJuego);
				ArrayList<Pregunta> lista_PasaPal = AccesoFichero.datosXML(documento);
				for (Pregunta pregunta : lista_PasaPal) {
					Consola.verSolcuiones(pregunta);

				}

			}
			
			else if(valor==3) {
				System.out.println("Saliendo del programa, gracias por jugar");
				
			}

		}
	}
}
