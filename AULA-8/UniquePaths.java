import java.util.*;
class UniquePaths {
	int[][] prueba; 

	// metodo para el camino con obstaculos
	public int uniquePathsWithObstacles(int[][] cuadricula) {
		if(cuadricula == null || cuadricula.length == 0)
			return 0;

		prueba = new int[cuadricula.length][cuadricula[0].length];
		return uniquePaths(cuadricula, 0, 0);
	}


	// metodo para el unico camino sin obstaculos
	private int uniquePaths(int[][] cuadricula, int x, int y){
		if(x >= cuadricula[0].length || y >= cuadricula.length || cuadricula[y][x] == 1)
			return 0;

		else if(x == cuadricula[0].length - 1 && y == cuadricula.length - 1)
			return 1;

		else if(prueba[y][x] > 0)
			return prueba[y][x];

		return cuadricula[y][x] = uniquePaths(cuadricula, x + 1, y) + uniquePaths(cuadricula, x, y + 1);
	}


	public static void main(String[]args){
		UniquePaths uniquePaths= new UniquePaths();
		System.out.println(uniquePaths.uniquePathsWithObstacles(new int [3][2]));

	} 
}