import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {
	static Scanner sc = new Scanner(System.in);

	public static int Opcion() {
		boolean entrada_correcta = false;
		int valor = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("1-Jugar");
		System.out.println("2-Mostrar partida");
		System.out.println("3-Salir");
		System.out.println("-------------------------");
		while (entrada_correcta == false) {
			try {
				valor = sc.nextInt();
				entrada_correcta = true;
			} catch (InputMismatchException excecpcion) {
				sc.nextLine();
				System.out.println("Error");
			}
		}
		return valor;
	}

	public static String pedirNumero() {
		System.out.println(" ");
		System.out.println(
				"Digame el numero de partido que quiere jugar sabiendo que disponemos desde el 15000 hasta el 15500");
		int num = sc.nextInt();
		String juego = Integer.toString(num);
		return juego;
	}

	public static void verSolcuiones(Pregunta pregunta) {
		System.out.println(pregunta.getPosicion() + " " + pregunta.getLetra() + " " + pregunta.getDefinicion());
		System.out.println("Su solucion es: " + pregunta.getSolucion());
		System.out.println("----------------------------------------------");

	}

	public static boolean mostrarPregunta(Pregunta pregunta) {
		System.out.println(pregunta.getPosicion() + " " + pregunta.getLetra() + " " + pregunta.getDefinicion());
		String respuesta = sc.next();
		if (pregunta.getSolucion().equals(respuesta.toUpperCase())) {

			System.out.println("has acertado");
			return true;
		} else {

			System.out.println("has fallado, la respuesta correcta es " + pregunta.getSolucion());
			return false;

		}

	}

}
