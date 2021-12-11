import java.util.*;

public class MaxNonoverSegments {
	public int Solucion(int[] A, int[] B) {
		int posicionActual =-1;
		int segmentosTotal = 0;

		for(int i=0; i<A.length; i++) {
			if(A[i]>posicionActual) {
				posicionActual = B[i];
				segmentosTotal++;
			}
		}
		return segmentosTotal;
	}

	public static void main(String[] args) {

		System.out.println(new MaxNonoverSegments().Solucion(
				new int[] { 1, 3, 7, 9, 9 },
				new int[] { 5, 6, 8, 9, 10 }));

		//System.out.println(new MaxNonoverSegments().Solucion(
		//new int[] { },
		//new int[] { }));

		System.out.println(new MaxNonoverSegments().Solucion(
				new int[] { 1 },
				new int[] { 2 }));

	}

	/*
	 * 
	 * Salida: 3
               0
               1
	 */
}
