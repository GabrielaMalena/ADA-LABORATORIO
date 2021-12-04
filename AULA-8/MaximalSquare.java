public class MaximalSquare{
	public int maximalSquare(char[][] matrix) {
		int filas = matrix.length;
		if(filas ==0) return 0;
		int colum = matrix [0].length;
		if(colum==0) return 0;

		int maximal_square = 0;
		int [] soluc = new int [colum];
		int item = matrix[0][0]== '0' ? 0: 1;

		for(int i=0; i<filas; i++) {
			for(int j=0; j<colum; j++) {
				int temporal =soluc[j];
				if (i==0 || j==0) {
					if(matrix[i][j] == '1') {
						soluc[j]=1;
						maximal_square = Math.max(maximal_square, soluc[j]);
					}
					else 
						soluc[j]=0;
					}
					else {
						if(matrix[i][j] == '1') {
							soluc[j]=1 + Math.min(Math.min(soluc[j], soluc[j-1]),item);
							maximal_square = Math.max(maximal_square, soluc[j]);

						}
						else
							soluc[j]=0;
					}
					item = (j== colum-1)? soluc[0] : temporal;
				}
			}
			return maximal_square*maximal_square;

		}
	}

	