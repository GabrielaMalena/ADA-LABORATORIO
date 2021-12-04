#include<bits/stdc++.h>
using namespace std;

int BookShop() {
  int n, x;
  cin >> n >> x;
  vector<int> precio(n), paginas(n);
  for (int&v : precio) cin >> v;
  for (int&v : paginas) cin >> v;
  vector<vector<int>> prueba(n+1,vector<int>(x+1,0));
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j <= x; j++) {
      prueba[i][j] = prueba[i-1][j];
      int izquierda = j-precio[i-1];
      if (izquierda >= 0) {
    prueba[i][j] = max(prueba[i][j], prueba[i-1][izquierda]+paginas[i-1]);
      }
    }
  }
  cout << prueba[n][x] << endl;
}
