#include <iostream>
#include <vector>
#include <queue>

using std::cout;
using std::endl;
using std::vector;
using std::pair;

vector<long long> minimoCosto(
	int from, const vector<vector<pair<int, int>>>& lado
) {
	vector<long long> minimoCosto(lado.size(), INT64_MAX);
	minimoCosto[from] = 0;
	std::priority_queue<pair<long long, int>> frente;
	frente.push({0, from});
	while (!frente.empty()) {
		pair<long long, int> estadoActual = frente.top();
		frente.pop();
		int actual = estadoActual.segundo;
		if (-estadoActual.first != minimoCosto[actual]) {
			continue;
		}
		
		for (auto [n, nc] : lado[actual]) {
			long long nuevo = minimoCosto[actual] + nc;
			if (nuevo < minimoCosto[n]) {
				minimoCosto[n] = nuevo;
				frente.push({-nuevo, n});
			}
		}
	}
	return minimoCosto;
}

int main() {
	int numCiudad;
	int numVuelo;
	std::cin >> numCiudad >> numVuelo;
	vector<vector<pair<int, int>>> lado(numCiudad);
	vector<vector<pair<int, int>>> ladoOpuesto(numCiudad);
	for (int f = 0; f < numVuelo; f++) {
		int from;
		int to;
		int cost;
		std::cin >> from >> to >> cost;
		lado[--from].push_back({--to, cost});
		ladoOpuesto[to].push_back({from, cost});
	}
 
	vector<long long> costo1 = minimoCosto(0, lado);
	vector<long long> costo2 = minimoCosto(numCiudad - 1, ladoOpuesto);
	long long total = INT64_MAX;
	for (int c = 0; c < numCiudad; c++) {
		for (auto [n, nc] : lado[c]) {
			if (costo1[c] == INT64_MAX || costo2[n] == INT64_MAX) {
				continue;
			}
			total = std::min(
				total,
				costo1[c] + (nc / 2) + costo2[n]
			);
		}
	}
	cout << total << endl;
}
