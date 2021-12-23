#include <stdio.h>
#include <sys/types.h>
#include <stdlib.h>
#include <stddef.h>

void KMP(char* p, size_t pl, char* t, size_t tl) {
    int sufijo[pl], longitud = 0, i = 1, j = 0, primero = 1;
    sufijo[0] = 0;
    while (i < pl) { 
        if (p[i] == p[longitud]) sufijo[i++] = ++longitud;
        else if (longitud) longitud = sufijo[longitud-1];
        else sufijo[i++] = 0;
    }
    i = 0;
    while (i < tl) { 
        if (p[j] == t[i]) { 
            j++; i++; 
        } 
        if (j == pl) {
            if (primero) primero = 0;
            else putchar(' ');
            printf("%d", i-j);
            j = sufijo[j - 1]; 
        } else if (i < tl && p[j] != t[i]) { 
            if (j) j = sufijo[j-1]; 
            else i++; 
        } 
    } 
    putchar('\n');
}

int main(void) {
    size_t a = 0, b = 0;
    char *patron = NULL, *texto = NULL;
    ssize_t p_longitud = 0, t_longitud = 0;
    while ((p_longitud = getline(&patron, &a, stdin)) >= 0 && (t_longitud = getline(&texto, &b, stdin)) >= 0) {
        KMP(patron, (size_t)(p_longitud-1), texto, (size_t)(t_longitud-1));
        free(patron);
        free(texto);
        a = 0;
        b = 0;
    }
    return 0;
}
