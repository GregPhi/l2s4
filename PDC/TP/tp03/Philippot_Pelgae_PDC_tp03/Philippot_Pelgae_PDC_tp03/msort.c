#include <stdio.h>
#include <stdlib.h>
#include "mcu_readl.h"
#include "quicksort.h" 
#define NMAXLINE 40
#define NMAXCHAR 200


int fichier[NMAXLINE][NMAXCHAR];
int length;

void readFile(){
    int i=0;
    int a=1;
    while(a!=EOF){
	a=readl(fichier[i]);
	if (a==EOF){
	    length=i;
	}
	else{i++;}
    }
}
void printFile(){
    for(int i=0;i<length;i++){
	int j=0;
	while(fichier[i][j]!='\n'&&fichier[i][j]!=EOF&&j<NMAXCHAR){
	putchar(fichier[i][j]);
	j++;
	}
	putchar('\n');
    }
}
int main(void){
    readFile();
    quicksort(fichier,length,4*NMAXCHAR,strcmp2);
    putchar('\n');
    printFile();
}
