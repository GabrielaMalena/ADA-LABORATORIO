#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const ll MODULO = 1e9+7;
const ll p1 = 31;
const ll p2 = 37;
const int maximo = 1e6+5;

int x;
ll cadena1[maximo], cadena2[maximo], pref1, pref2, suf1, suf2;
char String[maximo];

int main(){
    scanf("%s", String);
    x = (int) strlen(String);

    cadena1[0] = cadena2[0] = 1;
    for(int i = 1; i < x; i++){
        cadena1[i] = (cadena1[i-1] * p1) % MODULO;
        cadena2[i] = (cadena2[i-1] * p2) % MODULO;
    }

    for(int i = 0; i < x-1; i++){
        int l = (String[i] - 'a' + 1);
        int r = (String[x-i-1] - 'a' + 1);

        pref1 = (pref1 + l * cadena1[i]) % MODULO;
        pref2 = (pref2 + l * cadena2[i]) % MODULO;
        suf1 = (suf1 * p1 + r) % MODULO;
        suf2 = (suf2 * p2 + r) % MODULO;

        if(pref1 == suf1 && pref2 == suf2)
            printf("%d ", i+1);
    }
}
