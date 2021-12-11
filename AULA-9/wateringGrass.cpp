#include <algorithm>
#include <vector>
#include <cstdio>
#include <iostream>
#include <cmath>
using namespace std;

struct area{
    double a;
    double b;
    int indice;

    bool operator < (area x) const {
        return a < x.a;
    }
};

double A1,A2,maxim;    
int n, ip, mej;
vector<int> cover;
bool factible;

int main(){
	int n,l;
	double r,w,x;
	while (cin >> n >> l >> w){
		area distancia[n];
		for (int i=0;i<n;i++){
			cin >> x >> r; 
			if (r >= w/2){
				double p = sqrt(r*r -w*w/4);
				distancia[i].a = x - p;
				distancia[i].b = x + p;
				distancia[i].indice = i;
			}
			else {
				distancia[i].a = -1;
				distancia[i].b = -1;
				distancia[i].indice = i;
			}
		}
		A1 = 0;
		A2 = l;

        sort(distancia,distancia+n);
        ip = 0;
        cover.clear();
        factible = true;
        while (distancia[ip].b < A1){
            ip++;
            if (ip == n){
                factible = false;
                break;
            }
        }
        if (A1 == A2 && factible){
            if (distancia[ip].a <= A1 && distancia[ip].b >= A1)
                cover.push_back(distancia[ip].indice);
            else factible = false;
        }
        while (A1 < A2 && factible){
            if (ip == n){
                factible = false;
                break;
            }
            maxim = -1;
            mej = -1;
            while (distancia[ip].a <= A1){
                if (distancia[ip].b - A1 > maxim){
                    maxim = distancia[ip].b - A1;
                    mej = ip;
                }
                ip++;
                if (ip == n) break;
            }
            if (mej == -1){
                factible = false;
                break;
            }
            cover.push_back(distancia[mej].indice);
            A1 = distancia[mej].b;
        }
        if (!factible)
            printf("-1\n");
        else{
            printf("%lu\n",cover.size());
        }
	}

    return 0;
}
