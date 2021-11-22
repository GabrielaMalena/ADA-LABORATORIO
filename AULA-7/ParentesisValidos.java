import java.util.*;
public class ParentesisValidos {
	/*
	 * En el ejercicio nos pide ingresar una serie de parentesis
	 * y nos va hallar el numero minimo de parentesis validos
	 */

	//realizamos nuestra pruebas
	public static void main(String args[]){
		//String prueba = "())";
		//String prueba = "(()))(";
		String prueba = "(((";
		//String prueba = "(()))(";
		System.out.println(parentesisVal(prueba)); //imprimimos

	}

	//metodo para indicar la cantidad de los parentesis validos
	static int parentesisVal(String p){ 
		int x = 0; 	// inicializamos las varibles
		int y = 0;

		for (int i = 0; i < p.length(); ++i) { // realizamos el recorrido
			x += p.charAt(i) == '(' ? 1 : -1; // validacion
			if (x == -1) {  // cuando x> = -1
				y += 1;
				x += 1;
			}
		}

		return x + y;
	}
	/*
	 * Entrada ---------> String prueba = "())";
	 * Salida: 1
	 * 
	 * 
	 * Entrada ---------> String prueba = "(()))(";
	 * Salida:  2
	 * 
	 * 
	 * Entrada  ---------> String prueba = "(((";
	 * Salida:  3
	 */
}


