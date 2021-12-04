import java.util.*;
class UniquePaths {
    public int uniquePathsWithObstacles(int[][] cuadricula) {
	int x = cuadricula.length;
	int y = cuadricula[0].length;
	if(cuadricula[0][0] == 1) return 0;
	for(int i = 0; i < x; i++) {
	    for(int j = 0; j < y; j++) {
		if(i == 0 || j ==0) { // calculamos para la 1fila-1colum
		    if(cuadricula[i][j] == 1 || (i!=0 && cuadricula[i-1][0] == 0) || (j!=0 && cuadricula[i][j-1] == 0)) { // obstaculos
			cuadricula[i][j] = 0;
		     }
		     else {
			 cuadricula[i][j] = 1;
		     }
		  }
		  else {
		       if(cuadricula[i][j] == 1) { // calculamos para las demas celdas
			   cuadricula[i][j] = 0;
			}
			else {
			    cuadricula[i][j] = cuadricula[i-1][j] + cuadricula[i][j-1];
			}
		     }
		   }
		}
		return cuadricula[x-1][y-1];
	}
}