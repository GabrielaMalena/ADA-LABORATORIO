#include <cstdio>
#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;
vector<string> list;
int main(void){
    string str;
    int flag = 0;
    while(!cin.eof()){
        if(flag)
            cout << endl;
        else
            flag = 1;
        while(getline(cin, str) && str != ""){
            list.push_back(str);
            if(str == "") goto siguiente;
        }
            
        siguiente: ;
            for(int i = 0; i < list.size(); i++)
               reverse(list[i].begin(),  list[i].end());
            
            sort(list.begin(), list.end());
            
            for(int i = 0; i< list.size(); i++)
              reverse( list[i].begin(),  list[i].end());
            
            int max = 0;
            for(int i = 0; i < list.size(); i++)
                if(list[i].length() >= max)
                    max = list[i].length();
                    
            int contador;
            for(int i = 0; i < list.size(); i++){
                contador = max - list[i].length();
                while(contador--)
                    printf(" ");
                cout << list[i] << endl;
            }
            list.clear();
        }
    
     
    return 0;
}
