#include <bits/stdc++.h>
# define ll long long int
using namespace std;

struct arista{
    int a;
    int b;
    ll peso;
};

vector <arista> aristaList;
int _par [200001];

bool comp (arista a, arista b){
    return a.peso < b.peso;
}

int encontrar(int a){
    if(_par[a]== -1) 
    return a;
    return _par[a] =encontrar(_par[a]);
}

bool merge (int a, int b){
    a= encontrar(a);
    b= encontrar(b);
    if(a== b) return false;
    _par[a] =b;
    return true;
}

int main(){
    int x, y;
    ll resp = 0;
    int addedAristaCount =0;
    arista temporal;
    
    cin>>x>>y;
    for(int i=1; i<=x; i++) _par[i] = -1;
    for(int i=1; i<=y; i++) cin>>temporal.a>>temporal.b>>temporal.peso, aristaList.push_back(temporal);
    sort (aristaList.begin(), aristaList.end(), comp);
    for(arista e : aristaList){
        if(merge(e.a, e.b)) resp += e.peso, addedAristaCount++;
    }
    
    if(addedAristaCount == x-1)
    cout <<resp;
    else
    cout<<"noposible";
    }


