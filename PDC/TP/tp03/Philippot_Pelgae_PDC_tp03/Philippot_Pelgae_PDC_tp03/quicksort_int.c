#include <stdlib.h>
#include <stdio.h>
int rand (void);
#define TABSIZE 100

void quicksort_int(int *tab, unsigned int nelem){
    if (nelem>2){
        int j=0;
        for(int i=0; i<nelem-1;i++){
            if (tab[i]<=tab[nelem-1]){
                int a=tab[j];
                tab[j]=tab[i];
                tab[i]=a;
                j++;    
            }
        }
        int b=tab[j];
        tab[j]=tab[nelem-1];
        tab[nelem-1]=b;
        quicksort_int(&tab[0],j);
        quicksort_int(&tab[j+1],nelem-(j+1));
    }
    if(nelem ==2){
        if (tab[0]>tab[1]){
            int a =tab[0];
            tab[0]=tab[1];
            tab[1]=a;
        }
    }
}

void affichetab(int *tab,int nelem){
    for(int i =0;i<nelem;i++){
        printf("%d |",tab[i]);
    }
    putchar('\n');
}

int main(){
  int tab[TABSIZE];
  for(int i=0;i<TABSIZE;i++){
    tab[i]=rand() % TABSIZE;
  }
  affichetab(tab,TABSIZE);
  quicksort_int(tab,TABSIZE);
  affichetab(tab,TABSIZE);
}
