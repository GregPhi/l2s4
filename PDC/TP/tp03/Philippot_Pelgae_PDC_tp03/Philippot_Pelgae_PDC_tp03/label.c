#include <stdlib.h>
#include <stdio.h>
#include "mcu_readl.h"
#include "quicksort.h"
#define MAXTAB 50
#define SEP ' ' //défini un séparateur pour le parseur

typedef struct date{
    int year;
    int month;
    int day;} date;

typedef struct Nomine_s{
    int year;
    int domain[30];
    int name[50];
    date Bdate;
    int country[30];
    enum{MALE, FEMALE} gender;}Nomine_s;

/** je ne fais pas un parseur générique
    ce parseur ne liras que les fichier Nomines **/

int parseInt(int line[],int size){
    int a=0;
    for(int i=0;i<size;i++){
	printf("%d",line[i]-'0');
	a=a*10+line[i]-'0';
    }
    return a;
}
int ConstruireTableaux(struct Nomine_s * tab){
    int line[200];//met en mémoire la ligne
    int index=0;//index le tableau 
    int a=1;
    while(a>=0){
	a = readl(line);// donne l'information si la ligne est la dernière
	printf("\n");
	char zone =0; //permet de savoir ou nous somme dans le parseur
	int j=0;//permet de savoir ou commence la zone précédente 
	int g=0;//compte les guillemet
	for (int i =0;i<a;i++){//traverse la ligne donnée
	    if(line[i]=='\0'){break;}
	    if ((line[i]==SEP ||i==a) && g%2==0){
		switch (zone){
		    case 0: ;
			tab[index].year=parseInt(line,i);
			break;
		    case 1: ;
			memcpy(tab[index].domain,&line[j]+1,(i-j-2)*sizeof(int));//retire es guillements qui siglalise la chaine
			break;
		    case 2: ;
			memcpy(tab[index].name,&line[j]+1,(i-j-2)*sizeof(int));
			break;
		    case 3: ;
			date d;
			d.year=parseInt(line+j+1,4);
			d.month=parseInt(&line[j+6],2);
			d.day=parseInt(&line[j+9],2);
			tab[index].Bdate=d;
			break;
		    case 4: ;
			memcpy(tab[index].country,&line[j]+1,(i-j-2)*sizeof(int));
			break;
		    case 5: ;
			if (line[j+1]=='f'){tab[index].gender=FEMALE;}
			else{tab[index].gender=MALE;}
			break;
		}
	        j=i+1;
		zone+=1;
	    }
	    else if (line[i]=='"'){
		g++;
	    }
	}
	if (a>0){
	index++;}
    }// etudie la dernière ligne et ferme
    return index;//permet de savoir le nombre d'éléments a free
}
int CompareNomineParAgeDObtention(struct Nomine_s * n1,struct Nomine_s * n2){
    if( n1->year > n2->year){return 1;}
    else if(n1->year==n2->year){return 0;}
    else{return -1;}
}
int main (){
    Nomine_s tab[MAXTAB];
    int a =ConstruireTableaux(tab);
    printf("%d %d %d \n",tab[1].year,tab[0].year,CompareNomineParAgeDObtention(&tab[1],&tab[0]));
    quicksort(tab,a,sizeof(Nomine_s),(int (*) (const void *,const void*))CompareNomineParAgeDObtention);
    for(int i=0;i<a;i++){printf("%d \n",tab[i].year);}
    return 0;
}
