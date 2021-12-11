import java.util.*;
public class TieRopes {
	public int Solucion(int K, int[]A) {
		int longitudAct=0;
		int segmento=0;
		
		for(int i=0; i<A.length;i++) {
			longitudAct += A[i];
			if(longitudAct >=K) {
				segmento++;
				longitudAct=0;
			}				
		}
		return segmento;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new TieRopes().Solucion(4, new int[] {
			    1, 2, 3, 4, 1, 1, 3
			    //1, 2, 4, 1, 1, 3
		}));
	}
	
	/*
	 * Entrada:1, 2, 3, 4, 1, 1, 3
	 * Salida: 3
	 */

}
