import java.util.Deque;
import java.util.LinkedList;
/*
 * En el ejercicio nos pide usar una lista enlazada doblemente
 * en la cual se espera un turno para una entrevista haciendo comparaciones
 * entre los tiempo
 */
public class InterviewWait {
	public static void main(String[] args){   
		int prueba[] = {4,-1,5,2,3};
		int x = tiempo(prueba);
		System.out.println(x);
	}

	public static int tiempo(int [] prueba){
		Deque<Integer> queue = new LinkedList<>(); // lista doblemente enlazada
		int tiempo = 0; // inicializamos en 0
		for(int i = 0; i < prueba.length; i++) {
			queue.addLast(prueba[i]);
		}

		for(int i = 0; i < prueba.length+1; i++) { // realizamos el recorrido
			int izquierdo = queue.peekFirst();
			int derecho = queue.peekLast();
			if (izquierdo == -1 || derecho == -1) {
				break;
			}
			else {
				if(izquierdo < derecho) { // realiza las comparaciones
					tiempo = tiempo + queue.removeFirst(); // remove para eliminar y nos devuelve el primer elemento
				}
				else {
					tiempo = tiempo + queue.removeLast(); // creo unanueva cola omitiendo el ultimo
				}
			}
		}
		return tiempo;
	}
	
	/*
	 * Entrada: {4,-1,5,2,3}
	 * Salida: 9
	 */
}
