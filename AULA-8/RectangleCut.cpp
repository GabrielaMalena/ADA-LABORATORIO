#include <bits/stdc++.h>
using namespace std;
 
int RectangleCut() {
    int filas, columnas;
    cin >> filas>> columnas;
    if (filas > columnas)
        swap(filas, columnas);
    

    int NUMERO_GRANDE = 1e9;
    vector<vector<int>> tablero(filas, vector<int>(columnas, NUMERO_GRANDE));
    for (int fila = 0; fila < filas; fila++) {
        for (int colum = 0; colum < columnas; ++colum) {
            if (fila > colum)
               tablero[fila][colum] = tablero[colum][fila];
            else if (fila == colum)
                tablero[fila][colum] = 0;
            else {
          
                for (int i = 0; i < fila; i++) {
                    int corte1 = 1 + tablero[i][colum] + tablero[fila - i - 1][colum];
                    tablero[fila][colum] = min(tablero[fila][colum], corte1);
                }
                
                for (int i = 0; i < colum; i++) {
                    int corte1 = 1 + tablero[fila][i] + tablero[fila][colum - i - 1];
                    tablero[fila][colum] = min(tablero[fila][colum], corte1);
                }
            }
        }
    }
    cout << tablero[filas - 1][columnas - 1];
 
    return 0;
}
