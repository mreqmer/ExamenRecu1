package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio02 {
	/*
	 * ENTRADA:8:05  | RES. ESP.: 3:55 | RES.OB.: 3:55 
	 * ENTRADA:12:00 | RES. ESP.: 12:00| RES.OB.: 12:00 
	 * ENTRADA:12:30 | RES. ESP.: 12:30| RES.OB.: 12:30
	 * ENTRADA:10:09 | RES. ESP.: 10:09| RES.OB.: 10:09 
	 * ENTRADA:4:00  | RES. ESP.: 4:00 | RES.OB.: 4:00
	 * 
	 */

	public static void main(String[] args) {
		// creaión del escaner
		Scanner sc = new Scanner(System.in);
		// constantes
		// hora máxima del reloj
		final int HORA_MAX = 12;
		// minutos que nos resultarán para las operaciones
		final int MIN_MAX = 60;
		// variables
		// hora del espejo
		int horaEspejo = -1;
		// min del espejo
		int minEspejo = -1;
		// hora real
		int horaReal = -1;
		// minutos reales
		int minReal = -1;
		// guardará si el usuario va a repetir o no el programa
		String repetir = "";
		// sirve para pasar repetir a minusculas para que el programa ignore las mayus
		String repetirMin = "";

		do {
			// pide la hora del espejo al usuario, si no esta dentro del rango permitido
			// vuelve a preguntar y si es algo dsitinto de un número da mensaje de error y
			// vuelve a preguntar
			do {
				try {

					System.out.println("Introduce la hora del espejo: ");
					horaEspejo = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Error. Introduce una hora válida.");
				} finally {
					sc.nextLine();
				}

			} while (horaEspejo < 1 || horaEspejo > 12);

			// pide los minutos del espejo al usuario, si no esta dentro del rango permitido
			// vuelve a preguntar y si es algo dsitinto de un número da mensaje de error y
			// vuelve a preguntar
			do {
				try {
					// pide al usuario los minutos del espejo
					System.out.println("Introduce los minutos del espejo: ");
					minEspejo = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Error. Introduce unos minutos válidos.");
				} finally {
					sc.nextLine();
				}

			} while (minEspejo < 0 || minEspejo > 59);

			// dependiendo de la hora que se haya introducido se hace una hora distinta.
			// si son las 12 o las 6 en punto la hora no cambia O si son las 12:30
			// si son las en punto se le resta 12 a la hora del espejo y los minutos no
			// cambian
			// si son las y media cambia la hora pero no los minutos
			// si es cualquier otra hora se le resta a 12 a la hora del espejo -1

			if (((horaEspejo == 12 || horaEspejo == 6) && (minEspejo == 0)) || (minEspejo == 30 && horaEspejo == 12)) {
				horaReal = horaEspejo;
				minReal = minEspejo;
			} else if (minEspejo == 0) {
				horaReal = HORA_MAX - horaEspejo;
				minReal = minEspejo;
			} else if (minEspejo == 30) {
				horaReal = HORA_MAX - horaEspejo - 1;
				minReal = minEspejo;
			} else {
				horaReal = HORA_MAX - horaEspejo - 1;
				minReal = MIN_MAX - minEspejo;
			}

			// muestra la nueva hora al usuario, añade un 0 a los minutos(si son menores de 10) de la salida por
			//consola para que coincida con el formato horario
			if(minReal<10) {
				System.out.println("Son las " + horaReal + " horas y 0" + minReal + " minutos");
			}else {
				System.out.println("Son las " + horaReal + " horas y " + minReal + " minutos");
			}

			

			System.out.println("¿Quiere probar otra hora?");
			repetir = sc.nextLine();
			repetirMin = repetir.toLowerCase();
		} while (repetirMin.equals("s"));

		// mensaje fin del programa
		System.out.println("FIN");

		// cierre del escaner
		sc.close();

	}

}
