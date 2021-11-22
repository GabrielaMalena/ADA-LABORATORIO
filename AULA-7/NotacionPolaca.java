import java.util.*;

/*
 * En el ejercicio nos pide evaluar de manera
 * inversa - la notacion Polaca usando pilas
 * 
 */

public class NotacionPolaca {
	public static void main(String[] args) {
		String[] prueba = { "2", "1", "+", "3", "*" };
		//String[] prueba = { "4", "13", "5", "/", "+" };
		//String[] prueba = { "2", "1", "+", "3", "*" };

		NotacionPolaca notacion = new NotacionPolaca();
		int valor = notacion.notacionPolaca(prueba);
		System.out.println(valor);
	}


	// como vamos a trabajar en funcion de una pila
	// inicializamos primero la pila
	public int notacionPolaca(String[] pila){
		Stack<String> stack = new Stack<String>();
		int x, y;
		String valor = "",pref;
		String item = "";
		int inicializa = 0; // inicializamos variables
		int operacion= 0;


		for (int i = 0; i < pila.length; i++) { // recorrido a los caracteres en la pila
			if (pila[i] != "+" && pila[i] != "-"  // nuestroa caracteres '+', '-', '*', '/'
					&& pila[i] != "*" && pila[i] != "/") {
				stack.push(pila[i]);
				continue;
			}
			else {
				pref = pila[i]; // en caso sea el caracter indicado
			}


			// para los caracteres especiales trabajaremos
			// por casos (Caso1: +, Caso2: -, Caso3: *, Caso4: /)
			switch (pref) {
			case "/":
				x = Integer.parseInt(stack.pop()); // extraemos los datos de la cadena de la pila
				y = Integer.parseInt(stack.pop());// para convertirlos a int y realizar las operaciones
				operacion = y / x;
				valor = item + operacion;
				stack.push(valor);
				break;

			case "+":
				x = Integer.parseInt(stack.pop()); // usamos el metodo pop pars extraer
				y = Integer.parseInt(stack.pop());
				operacion = x + y;
				valor = item + operacion;
				stack.push(valor);
				break;

			case "-":

				// Performing the "-" operation by poping
				// put the first two character
				// and then again store back to the stack
				x = Integer.parseInt(stack.pop());
				y = Integer.parseInt(stack.pop());
				operacion = y - x;
				valor = item + operacion;
				stack.push(valor);
				break;

			case "*":
				x = Integer.parseInt(stack.pop()); 
				y = Integer.parseInt(stack.pop());
				operacion = x * y; // la operacion * ubica los caracteres
				valor = item + operacion;// se almacena en stack
				stack.push(valor);
				break; // rompemos el bucle- salimos de el

			default:
				continue;
			}
		}
		return Integer.parseInt(stack.pop()); // conversion a int
	}

	/*
	 * 
	 * Entrada: { "4", "13", "5", "/", "+" };
	 * Salida:  6
	 * 
	 * 
	 * Entrada: { "2", "1", "+", "3", "*" };
	 * Salida:  9
	 */
}


