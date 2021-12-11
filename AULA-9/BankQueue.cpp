#include <stdio.h>  
#include <vector>
#include <algorithm> 

using namespace std;
struct Personas{
    int dinero;
    int tiempo;
    
    Personas(int din, int tiemp){
        dinero = din;
        tiempo = tiemp;
    }
};

bool compareDinero(const Personas &x, const Personas &y){
        return x.dinero >= y.dinero;
}

void queuePersonas(vector<int> &cola1, Personas cola2){
    int i = cola2.tiempo;
    
    while(i >= 0){
        if(cola1[i] == 0){
            cola1[i] = cola2.dinero;
            return;
        }  
        i--;
    }
}

int main(){ 
    int total, minutos, efectivo, timeTotal;
    int sumaTotal = 0;
    int i = 0;
	
    scanf("%d %d", &total, &minutos);
    
    vector<int> Queue1(minutos);
    vector<Personas> dinero;
    
    for(int i = 0; i < total; i++){
        scanf("%d %d", &efectivo, &timeTotal);
        Personas cola2(efectivo, timeTotal);
        dinero.push_back(cola2); 
    }
    
    sort(dinero.begin(), dinero.end(), compareDinero);
    while(i < dinero.size()){
        queuePersonas(Queue1, dinero[i]);
        i++;
    }
    

    for(int i = 0; i < Queue1.size(); i++){
        sumaTotal += Queue1[i];
    }
    
    printf("%d", sumaTotal); 
    return 0; 
}
   
