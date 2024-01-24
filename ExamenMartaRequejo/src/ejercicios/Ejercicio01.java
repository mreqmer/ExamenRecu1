package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio01 {

	/*
	 * ENTRADA: 2 RES. ESP.: tablero con 64 celdas, las cuales 32 son claras " " y
	 * 32 oscuras "#". Celdas compuestas por 2 caracteres de ancho y 2 de alto.
	 * RES.OB.: tablero con 64 celdas, las cuales 32 son claras " " y 32 oscuras"#".
	 * Celdas compuestas por 2 caracteres de ancho y 2 de alto.
	 * -----------------------------------------------------------------------------
	 * -------- ENTRADA: 4 RES. ESP.: tablero con 64 celdas, las cuales 32 son
	 * claras " " y 32 oscuras "#". Celdas compuestas por 4 caracteres de ancho y 4
	 * de alto. RES.OB.: tablero con 64 celdas, las cuales 32 son claras " " y 32
	 * oscuras"#". Celdas compuestas por 4 caracteres de ancho y 4 de alto.
	 * -----------------------------------------------------------------------------
	 * -------- ENTRADA: 1 RES. ESP.: tablero con 64 celdas, las cuales 32 son
	 * claras " " y 32 oscuras "#". Celdas compuestas por 1 caracter de ancho y 1 de
	 * alto. RES.OB.: tablero con 64 celdas, las cuales 32 son claras " " y 32
	 * oscuras"#". Celdas compuestas por 1 caracter de ancho y 4 de alto.
	 * 
	 */

	public static void main(String[] args) {
		// creación del escaner
		Scanner sc = new Scanner(System.in);
		// constantes
		// ancho del tablero
		final int ANCHO_T = 4;
		final int LARGO_T = 8;
		// variables
		// tamaño que tendrá el escaque
		int tamano;

		try {
			// pide al usuario el tamaño del escaque
			System.out.println("Introduce el tamaño: ");
			tamano = sc.nextInt();
			// condicional para comprobar que el valor sea válido
			if (tamano >= 0) {
				// bucle principal que controla las lineas de escaque totales que tiene el
				// programa, que es la constante LARGO_T
				for (int i = 0; i < LARGO_T; i++) {
					// controla las veces que se repite una linea, que es el tamaño que tiene el
					// escaque
					for (int repLinea = 0; repLinea < tamano; repLinea++) {
						// controla el ancho de las lineas y como se muestra el tabero, que es la
						// constante ANCHO_T
						for (int ancho = 0; ancho < ANCHO_T; ancho++) {
							// condicional para comprobar si empieza por escaque # o escaque " "
							if (i % 2 == 0) {
								// controla el número de espacios que va a mostrar
								for (int espacios = 0; espacios < tamano; espacios++) {
									System.out.print(" ");
								}
								// controla el número de caracteres a mostar
								for (int caracter = 0; caracter < tamano; caracter++) {
									System.out.print("#");
								}

							} else {
								// controla el número de caracteres a mostar
								for (int caracter = 0; caracter < tamano; caracter++) {
									System.out.print("#");
								}
								// controla el número de espacios que va a mostrar
								for (int espacios = 0; espacios < tamano; espacios++) {
									System.out.print(" ");
								}

							} // fin if else caracteres

						} // for ancho
							// salto de linea para pasar a otra linea de escaques
						System.out.println("");
					} // for lineas
				} // for largo
			} else {
				System.out.println("Error. No se permiten caracteres o num negativos.");
			}
		//recoge errores en caso de que sea un caracter o un decimal en vez de un número	
		} catch (InputMismatchException e) {
			System.out.println("Error. No se permiten caracteres o num negativos.");
		}

		// cierre de escaner
		sc.close();
	}
}
