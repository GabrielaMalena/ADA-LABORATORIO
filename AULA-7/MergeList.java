
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * En este ejercicio Merge k sorted lists nos pide
 * ingresar una arreglo con varias sublistas y como salida
 * nos de el array completo y ordenado con todas las sublistas
 * para ello use colas de prioridad y una clase nodo
 */

public class MergeList {

	public static NodeMergeList merge(NodeMergeList[] lista){ // merge ordenamos la lista
		PriorityQueue<NodeMergeList> cola; // nuestra cola de prioridad
		cola = new PriorityQueue<>(Comparator.comparingInt(list -> ((NodeMergeList) list).dato));//devuelve un Comparador que compara por esa clave
		//usamos el metodo sublist parapoder extraer una parte de la lista
		// apartir de ella crear una nueva lista
		cola.addAll(Arrays.asList(lista).subList(0, lista.length)); //insertamos, primer nodo en nuestra lista 
		NodeMergeList cabeza = null; // cabeza señala al primer nodo
		NodeMergeList ultimo = null; // ultimo nodo de la cola
		while (!cola.isEmpty()){ // pila vacia empty
			NodeMergeList valMin = cola.poll(); // minimo valor
			if (cabeza == null) { //
				cabeza = ultimo = valMin;
			}
			else {
				ultimo.siguiente =valMin;
				ultimo = valMin;
			}
			if (valMin.siguiente != null) { // nodo proximo
				cola.add(valMin.siguiente);
			}
		}
		return cabeza; // retorna cabeza de la lista
	}



	// metodo para mostrar nuestras listas
	public static void mostrar(NodeMergeList node) {
		while (node!= null){ // en caso sea diferente del nulo toma el sgte
			System.out.print(node.dato + ","); // nos imprime el dato
			node = node.siguiente;
		}
	}


	public static void main(String[] args) {
		int cantidad = 3;   // cantidd de listas

		NodeMergeList[] lista = new NodeMergeList[cantidad]; // mi arreglo- lista
		lista[0] = new NodeMergeList(1); // lista 1
		lista[0].siguiente = new NodeMergeList(4);//  insertamos nuestra lista ordenada
		lista[0].siguiente.siguiente = new NodeMergeList(5);

		//lista[1] = new NodeMergeList(1); // lista2
		//lista[1].siguiente = new NodeMergeList(3);
		//lista[1].siguiente.siguiente = new NodeMergeList(4);

		lista[1] = new NodeMergeList(2); // lista3
		lista[1].siguiente = new NodeMergeList(6);//  insertamos nuestra lista ordenada


		lista[2] = new NodeMergeList(2); //lista4
		lista[2].siguiente = new NodeMergeList(6); //  insertamos nuestra lista ordenada
		lista[2].siguiente.siguiente = new NodeMergeList(16);
		lista[2].siguiente.siguiente.siguiente = new NodeMergeList(26);
		lista[2].siguiente.siguiente.siguiente.siguiente = new NodeMergeList(44);


		//lista[4] = new NodeMergeList(2); //lista5
		//lista[4].siguiente = new NodeMergeList(1);
		//lista[4].siguiente.siguiente = new NodeMergeList(8);
		//lista[4].siguiente.siguiente.siguiente = new NodeMergeList(6);
		//lista[4].siguiente.siguiente.siguiente.siguiente = new NodeMergeList(10);

		NodeMergeList cabeza = merge(lista); // merge-ordenamiento
		mostrar(cabeza); // mostramos lista
	}
	
	/*
	 * 
	 * Entrada: [1,4,5] ,[1,3,4], [2,6]
	 * Salida:   1,1,2,3,4,4,5,6,
	 * 
	 * 
	 * Entrada:  [1,4,5] ,[2,6], [2,6,16,26,44]
	 * Salida:  1,2,2,4,5,6,6,16,26,44,
	 */
}
